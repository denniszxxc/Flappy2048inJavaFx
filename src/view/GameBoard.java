/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;
import model.Bird;
import model.GraphicalObjCollector;

/**
 * This Class manipulate every graphical compoents on screen
 * @author dennisli
 */
public class GameBoard {
    private Pane pane;    
    private GraphicalObjCollector graphicalObjCollector;
    
    public GameBoard(){
        graphicalObjCollector = new GraphicalObjCollector();
    }
    
    public GraphicalObjCollector getGraphicalObjCollector(){
        return graphicalObjCollector;
    }
    
    
    /** 
     * Display the start screen
     * 
     * @parm startHandler Handler for Start Button
     */
    public Pane startScreen(EventHandler<ActionEvent> startHandler ){
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
     * @return root pane with graphic elements
     */
    public Pane endScreen(){
        Button btn = new Button();
        btn.setText("END");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("DO Sth in endScreen");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        return root;
    }    
    
    /**
     * Draw the graphical objects on screen 
     * 
     * @return root
     */
    public Pane drawGamePlay(Pane root , EventHandler jumpHandler){
              
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnKeyPressed(jumpHandler);
        canvas.setOnMouseClicked(jumpHandler);
        
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
        
        gc.setFill(Color.BURLYWOOD);
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(5);
        gc.setLineJoin(StrokeLineJoin.ROUND);
        
        gc.fillRect(xPoisition, yPoisition, Bird.BIRD_WiDTH , Bird.BIRD_HEIGHT);
        gc.strokeRect(xPoisition, yPoisition, Bird.BIRD_WiDTH , Bird.BIRD_HEIGHT);
    }
}
