/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    public Pane drawGamePlay(Pane root){
        graphicalObjCollector = new GraphicalObjCollector();
        
        Button btn = new Button();
        double x = Math.random();
        btn.setText(Double.toString(x));
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("do sth");
            }
        });
        
       root.getChildren().clear();
       root.getChildren().add(btn);
        
        return root;
    }
    
}
