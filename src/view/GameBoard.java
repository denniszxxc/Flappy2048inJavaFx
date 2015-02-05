/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.animation.PathTransition;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import model.Bird;
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
        ImageView gameTitle = new ImageView(new Image("view/title.png"));
        ImageView bird = new ImageView(new Image("view/startBird.png"));
        
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
        btn.relocate(300,480);

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
    public Pane endScreen(EventHandler restartHandler) {
        System.out.println("END GAME");
        canvas = null;
        
        Button btn = new Button();
        btn.setId("restartBtn");
        btn.setOnAction(restartHandler);

        Text txt = new Text();
        String str = "";
        for(int score: score.getHighScore()){
            str+= Integer.toString(score) + "\n ";
        }
        txt.setId("scoreTableText");
        txt.setText(str);
        
        VBox vbox = new VBox();
        vbox.setId("scoreTable");
        vbox.getChildren().add(txt);
        
        Pane endPane = new Pane();
        endPane.setId("endPane");
        endPane.getStylesheets().addAll(this.getClass().getResource("endScreen.css").toExternalForm());
        endPane.getChildren().addAll(vbox, btn);
        btn.setPrefSize(200f, 68f);
        btn.relocate(300,500);
        

        StackPane root = new StackPane();
        root.getChildren().addAll(endPane);
        return root;
    }

    public Pane initGamePlay(EventHandler jumpHandler) {
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setFocusTraversable(true);
        canvas.requestFocus();
        
        canvas.setOnMouseClicked(jumpHandler);
        canvas.setOnKeyPressed(jumpHandler);

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        root.setOnKeyPressed(jumpHandler);
            
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

        drawBackGround(gc);
        drawPillars(gc);
        drawBird(gc);
        drawScore(gc);
        
        return root;
    }

    public void drawBird(GraphicsContext gc) {
        double xPoisition = graphicalObjCollector.getBird().getX();
        double yPoisition = graphicalObjCollector.getBird().getY();
        int birdVal = graphicalObjCollector.getBird().getBirdValue();

        gc.setFill(Color.BURLYWOOD);
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(10);
        gc.setLineJoin(StrokeLineJoin.ROUND);

        gc.fillRect(xPoisition, yPoisition, Bird.BIRD_WiDTH, Bird.BIRD_HEIGHT);
        gc.strokeRect(xPoisition, yPoisition, Bird.BIRD_WiDTH, Bird.BIRD_HEIGHT);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Color.BLACK);
        gc.setFont(new Font(30));

        gc.fillText(Integer.toString(birdVal),
                xPoisition + Bird.BIRD_WiDTH / 2, yPoisition + Bird.BIRD_HEIGHT / 2);
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
            double xPoisition = box.getX();
            double yPoisition = box.getY();

            gc.setFill(Color.BURLYWOOD);
            gc.setStroke(Color.GRAY);
            gc.setLineWidth(10);
            gc.setLineJoin(StrokeLineJoin.ROUND);

            gc.fillRect(xPoisition, yPoisition, Box.BOX_DIMENTION, Box.BOX_DIMENTION);
            gc.strokeRect(xPoisition, yPoisition, Box.BOX_DIMENTION, Box.BOX_DIMENTION);

            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.setFill(Color.BLACK);
            gc.setFont(new Font(30));

            gc.fillText(Integer.toString(box.getBoxValue()),
                    xPoisition + Box.BOX_DIMENTION / 2, yPoisition + Box.BOX_DIMENTION / 2);

        }
    }

    public void drawBackGround(GraphicsContext gc) {
        gc.setFill(Color.SKYBLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    public void drawScore(GraphicsContext gc){
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.setTextBaseline(VPos.TOP);
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial Bold",32));

        gc.fillText("Score: " + Integer.toString(score.getCurrentScore()),
                canvas.getWidth(), 0);

    }
}
