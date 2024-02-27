package com.example.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


//Part 1 A
public class MarioGame extends Application {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    //private static final int SCROLL_SPEED = 3; //new stuff to make it side-scrolling



    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Creating Mario as a rectangle
        MarioCharacter mario = new MarioCharacter();

        mario.setX(WINDOW_WIDTH / 2.0 - mario.getMarioWidth() / 2.0); // Centering Mario
        mario.setY(WINDOW_HEIGHT - mario.getMarioHeight() - 50); // Positioning Mario above the bottom

        root.getChildren().add(mario);

        primaryStage.setTitle("JavaFX Mario Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Part 2B allow for moving left and right and jumping with velocity
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:

                    mario.moveLeft(); // Move left
                    break;
                case RIGHT:
                    mario.moveRight(); // Move right
                    break;
                case UP:
                    mario.jump();
                    break;
            }
        });

        scene.setOnKeyReleased(e -> { //be sure to import KeyCode
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT) {
                mario.stop(); // Stop horizontal movement when key is released
            }
        });


        // Game loop
        new AnimationTimer() { //be sure to import class

            public void handle(long currentNanoTime) {


                // mario.setX(mario.getX()-SCROLL_SPEED);  // Optional - Side-scroll by affecting the x
                mario.update();
            }
        }.start();  //starts the animation timer
    }



    public static void main(String[] args) {
        launch(args);
    }
}

