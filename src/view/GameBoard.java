/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.Bird;
import model.GraphicalObjCollector;
import model.Pillar;
import model.Box;

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

    public GameBoard() {
        graphicalObjCollector = new GraphicalObjCollector();
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
        Button btn = new Button();
        btn.setText("Start!");
        btn.setOnAction(startHandler);

        StackPane root = new StackPane();
        root.getChildren().add(btn);

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
        btn.setText("Restart");
        btn.setOnAction(restartHandler);

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        return root;
    }

    public Pane initGamePlay(EventHandler jumpHandler) {
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setOnMouseClicked(jumpHandler);
        canvas.setOnKeyPressed(jumpHandler);

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        graphicalObjCollector = new GraphicalObjCollector();
        
        return root;
    }

    /**
     * Draw the graphical objects on screen
     *
     * @return root
     */
    public Pane drawGamePlay(Pane root) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        drawBackGround(gc);
        drawPillars(gc);
        drawBird(gc);
        
        root.getChildren().clear();
        root.getChildren().add(canvas);

        // root.getChildren().clear();
        // root.getChildren().add(btn);
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
}
