package com.ssu.artemiy_dobrynin.java.snake.model.frog;

import com.ssu.artemiy_dobrynin.java.snake.model.Entity;

import java.util.Random;

/**
 * Created by DobryninAM on 17.02.2017.
 */
public abstract class Frog extends Entity {
    private int posX;
    private int posY;

    public Frog(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setRandomPosition(){
        posX = (int)Math.random();
        posY = (int)Math.random();

    }
}