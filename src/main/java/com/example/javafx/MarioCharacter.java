package com.example.javafx;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class MarioCharacter extends Rectangle {
    private static final int MARIO_WIDTH = 40;
    private static final int MARIO_HEIGHT = 60;
    private double velocityY = 0;
    private double velocityX = 0;
    private boolean isInAir = false;

    public MarioCharacter() {
        super(MARIO_WIDTH, MARIO_HEIGHT, Color.RED);
    }


    public int getMarioWidth(){
        return MARIO_WIDTH;
    }

    public int getMarioHeight(){
        return MARIO_HEIGHT;
    }

    public void moveLeft() {
        velocityX = -5;
    }

    public void moveRight() {
        velocityX = 5;
    }

    public void jump() {
        if (!isInAir) {
            velocityY = -15;
            isInAir = true;
        }
    }

    public void stop() {
        velocityX = 0;
    }

    public void update() {
        velocityY += 0.5; // Gravity effect
        this.setY(this.getY() + velocityY);
        this.setX(this.getX() + velocityX);

        // Collision detection with ground
        if (this.getY() >= 550 - MARIO_HEIGHT) {
            this.setY(550 - MARIO_HEIGHT);
            isInAir = false;
            velocityY = 0;
        }

        // Collision detection with walls
        if (this.getX() >= 800 - MARIO_WIDTH) {
            this.setX(800 - MARIO_WIDTH);
            velocityX = 0;
        }else if (this.getX() <= 40 - MARIO_WIDTH){
            this.setX(40 - MARIO_WIDTH);
            velocityX = 0;
        }
    }

    public boolean isInAir() {
        return isInAir;
    }
}
