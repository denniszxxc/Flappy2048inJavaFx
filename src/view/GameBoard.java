/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import model.GraphicalObjCollector;
import model.Pillar;
import model.Box;
import model.Score;

/**
 * This Class manipulate every graphical compoents on screen
 *
 * @author dennisli
 */
public class GameBoard {

    public final int CANVAS_WIDTH = 800;
    public final int CANVAS_HEIGHT = 600;

    private Canvas canvas;
    private GraphicalObjCollector graphicalObjCollector;
    private Score score;

    public GameBoard() {
        graphicalObjCollector = new GraphicalObjCollector();
    }

    public GameBoard(Score score) {
        graphicalObjCollector = new GraphicalObjCollector();
        this.score = score;
    }

    public GraphicalObjCollector getGraphicalObjCollector() {
        return graphicalObjCollector;
    }

    /**
     * Display the start screen
     *
     * @parm startHandler Handler for Start Button
     */
    public Pane startScreen(EventHandler<ActionEvent> startHandler) {
        ImageView gameTitle = new ImageView(new Image("view/startScreenMessage.png"));
        ImageView bird = new ImageView(new Image("view/startScreenBird.png"));

        TranslateTransition birdTransition = new TranslateTransition(Duration.millis(1000), bird);
        birdTransition.setByY(50f);
        birdTransition.setCycleCount(Timeline.INDEFINITE);
        birdTransition.setAutoReverse(true);
        birdTransition.play();

        Button btn = new Button();
        btn.setId("startBtn");
        btn.setOnAction(startHandler);

        Pane startPane = new Pane();
        startPane.setId("startPane");
        startPane.getStylesheets().addAll(this.getClass().getResource("startScreen.css").toExternalForm());
        startPane.getChildren().addAll(gameTitle, bird, btn);
        btn.setPrefSize(200f, 68f);
        btn.relocate(300, 480);

        StackPane root = new StackPane();
        root.getChildren().add(startPane);

        return root;
    }

    /**
     * Display the end screen
     *
     * @param restartHandler restart button on action handler
     * @return root pane with graphic elements
     */
    public Pane endScreen(EventHandler<ActionEvent> restartHandler, EventHandler<ActionEvent> endHandler) {
        canvas = null;

        ImageView endScreenImage = new ImageView(new Image("view/endScreenMessage.png"));
        
        Button restartBtn = new Button();
        restartBtn.setId("restartBtn");
        restartBtn.setOnAction(restartHandler);

        Button quitBtn = new Button();
        quitBtn.setId("quitBtn");
        quitBtn.setOnAction(endHandler);

        Text scoreText = new Text();
        scoreText.setTextAlignment(TextAlignment.CENTER);
        scoreText.setId("score");
        scoreText.setText("" + score.getCurrentScore());
        StackPane scorePane = new StackPane();
        scorePane.getChildren().add(scoreText);
        scorePane.setPrefSize(200f, 100f);
        scorePane.relocate(300, 175);
        
        Text highScoreText1 = new Text();
        highScoreText1.setTextAlignment(TextAlignment.CENTER);
        highScoreText1.setId("highScore1");
        highScoreText1.setText("" + score.getHighestScore());
        StackPane highScorePane1 = new StackPane();
        highScorePane1.getChildren().add(highScoreText1);
        highScorePane1.setPrefSize(200f, 100f);
        highScorePane1.relocate(50, 375);
        
        Text highScoreText2 = new Text();
        highScoreText2.setTextAlignment(TextAlignment.CENTER);
        highScoreText2.setId("highScore2");
        highScoreText2.setText("??");
        StackPane highScorePane2 = new StackPane();
        highScorePane2.getChildren().add(highScoreText2);
        highScorePane2.setPrefSize(200f, 100f);
        highScorePane2.relocate(300, 375);
        
        Text highScoreText3 = new Text();
        highScoreText3.setTextAlignment(TextAlignment.CENTER);
        highScoreText3.setId("highScore3");
        highScoreText3.setText("?");
        StackPane highScorePane3 = new StackPane();
        highScorePane3.getChildren().add(highScoreText3);
        highScorePane3.setPrefSize(200f, 100f);
        highScorePane3.relocate(550, 375);

        Pane endPane = new Pane();
        endPane.setId("endPane");
        endPane.getStylesheets().addAll(this.getClass().getResource("endScreen.css").toExternalForm());
        endPane.getChildren().addAll(
                endScreenImage,
                scorePane,
                highScorePane1,
                highScorePane2,
                highScorePane3,
                restartBtn,
                quitBtn);
        restartBtn.setPrefSize(200f, 68f);
        restartBtn.relocate(150, 500);
        quitBtn.setPrefSize(200f, 68f);
        quitBtn.relocate(450, 500);

        StackPane root = new StackPane();
        root.getChildren().addAll(endPane);
        return root;
    }

    public Pane initGamePlay(EventHandler<InputEvent> jumpHandler) {
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setFocusTraversable(true);
        canvas.requestFocus();

        canvas.setOnMouseClicked(jumpHandler);
        canvas.setOnKeyPressed(jumpHandler);

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        root.setOnKeyPressed(jumpHandler);
        root.getStylesheets().add(this.getClass().getResource("game.css").toExternalForm());
        root.setId("mainPane");

        graphicalObjCollector = new GraphicalObjCollector();

        return root;
    }

    /**
     * Draw the graphical objects on screen
     *
     * @param root
     * @return root
     */
    public Pane drawGamePlay(Pane root) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        drawPillars(gc);
        drawBird(gc);
        drawScore(gc);

        return root;
    }

    public void drawBird(GraphicsContext gc) {
        double xPoisition = graphicalObjCollector.getBird().getX();
        double yPoisition = graphicalObjCollector.getBird().getY();
        int birdPowVal = graphicalObjCollector.getBird().getBirdPowerValue();

        drawABox(gc, xPoisition, yPoisition, birdPowVal);
    }

    public void drawPillars(GraphicsContext gc) {
        ArrayList<Pillar> pillars = graphicalObjCollector.getPillarCollector().getPillars();
        for (Pillar pillar : pillars) {
            drawBoxes(gc, pillar);
        }
    }

    public void drawBoxes(GraphicsContext gc, Pillar pillar) {
        Box[] boxes = pillar.getBoxes();
        for (Box box : boxes) {
            if (box.getBoxValue() == -1) {
                continue;
            }
            double xPoisition = box.getX();
            double yPoisition = box.getY();
            int boxPowVal = box.getBoxValue();

            drawABox(gc, xPoisition, yPoisition, boxPowVal);

        }
    }

    private void drawABox(GraphicsContext gc, double xPoisition, double yPoisition, int boxPowVal) {
        gc.setFill(Box.boxColor(boxPowVal));
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(10);
        gc.setLineJoin(StrokeLineJoin.ROUND);

        gc.fillRect(xPoisition, yPoisition, Box.BOX_DIMENTION, Box.BOX_DIMENTION);
        gc.strokeRect(xPoisition, yPoisition, Box.BOX_DIMENTION, Box.BOX_DIMENTION);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Box.fontColor(boxPowVal));
        gc.setFont(new Font("Arial Bold", Box.fontSize(boxPowVal)));

        String boxMessage;
        if (boxPowVal <= 16) {
            boxMessage = Integer.toString((int) Math.pow(2, boxPowVal));
        } else {
            boxMessage = "2^" + Integer.toString(boxPowVal);
        }
        gc.fillText(boxMessage,
                xPoisition + Box.BOX_DIMENTION / 2, yPoisition + Box.BOX_DIMENTION / 2);
    }

    public void drawScore(GraphicsContext gc) {
        gc.setFill(Color.web("#8f7a66"));
        gc.fillRoundRect(700, 20, 80, 50, 10, 10);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.TOP);
        gc.setFill(Color.web("#f9f6f2"));
        gc.setFont(new Font("Arial Bold", 13));
        gc.fillText("SCORE", canvas.getWidth() - 60, 23);
        gc.setFont(new Font("Arial Bold", 24));
        gc.fillText(Integer.toString(score.getCurrentScore()),
                canvas.getWidth() - 60, 38, 60);

    }
}
