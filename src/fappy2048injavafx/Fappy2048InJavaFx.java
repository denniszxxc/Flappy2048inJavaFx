/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fappy2048injavafx;

import controller.GameEngine;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author dennisli
 */
public class Fappy2048InJavaFx extends Application  {

    private GameEngine gameEngine;
    private Scene scene;
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        gameEngine = new GameEngine();
        Scene scene  = new Scene(gameEngine.getPane(), 800, 600);
        primaryStage.setTitle("Flappy2048 in JavaFx!");
        primaryStage.setScene(scene);
          
    // Create a handler for refreshing
        EventHandler<ActionEvent> eventHandler = e -> {
            gameEngine.update(System.nanoTime());
            scene.setRoot(gameEngine.getPane());
            
            primaryStage.show();    
        };
        
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(gameEngine.REFRESH_INTERVAL), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
