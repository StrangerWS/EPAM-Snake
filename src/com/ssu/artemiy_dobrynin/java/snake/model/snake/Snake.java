package com.ssu.artemiy_dobrynin.java.snake.model.snake;

import com.ssu.artemiy_dobrynin.java.snake.model.Entity;

/**
 * Created by DobryninAM on 17.02.2017.
 */
public class Snake extends Entity {
    public int direction = 0;
    public int length = 10;

    public int[] snakeX = new int[100];
    public int[] snakeY = new int[100];

    public Snake(int x0, int y0) {
        for (int i = 0; i < length; i++) {
            snakeX[i] = x0 + i;
        }
        for (int i = 0; i < length; i++) {
            snakeY[i] = y0;
        }
    }

    public void move() {
        for (int i = length; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        if (direction == 0) {
            snakeX[0]++;
        } else if (direction == 1) {
            snakeY[0]++;
        } else if (direction == 2) {
            snakeX[0]--;
        } else if (direction == 3) {
            snakeY[0]--;
        }

        for (int i = length; i > 0; i--) {
            if (snakeX[0] == snakeX[i] & snakeY[0] == snakeY[i]) {
                length = i;
            }
        }
    }
}
