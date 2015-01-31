/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
    
    /** 
     * Display the start screen
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
     */
    public Pane endScreen(){
        Button btn = new Button();
        btn.setText("END");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("DO Sth");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        return root;
    }    
    
    /**
     * Draw the graphical objects on screen 
     */
    public Pane draw(){
        Button btn = new Button();
        double x = Math.random();
        btn.setText(Double.toString(x));
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("do sth");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        return root;
    }
    
}
