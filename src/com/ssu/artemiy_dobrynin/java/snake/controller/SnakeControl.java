package com.ssu.artemiy_dobrynin.java.snake.controller;

import com.ssu.artemiy_dobrynin.java.snake.model.snake.Snake;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by User on 03.03.2017.
 */
public class SnakeControl extends MouseAdapter {
    private Snake snake;

    public SnakeControl(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.getButton() == MouseEvent.BUTTON1) {
            if (snake.direction > 0) snake.direction -= 1;
            else snake.direction = 3;
        }
        if (event.getButton() == MouseEvent.BUTTON3) {
            if (snake.direction < 3) snake.direction += 1;
            else snake.direction = 0;
        }
    }
}
