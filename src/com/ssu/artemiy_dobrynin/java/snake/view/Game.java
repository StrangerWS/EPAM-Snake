package com.ssu.artemiy_dobrynin.java.snake.view;

import com.ssu.artemiy_dobrynin.java.snake.controller.SnakeControl;
import com.ssu.artemiy_dobrynin.java.snake.model.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DobryninAM on 03.03.2017.
 */
public class Game extends JPanel implements ActionListener {

    public static JFrame PARENT;

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Snake snake = new Snake(10, 10);
    Timer t = new Timer(1000 / SPEED, this);

    public Game() {
        addMouseListener(new SnakeControl(snake));
        setFocusable(true);
    }

    private void start(){
        t.start();
    }

    public void paint(Graphics g) {
        g.setColor(new Color(136, 183, 3));
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(new Color(65, 65, 62));

        for (int i = 0; i <= WIDTH * SCALE; i += SCALE) {
            g.drawLine(i, 0, i, HEIGHT * SCALE);
        }
        for (int i = 0; i <= HEIGHT * SCALE; i += SCALE) {
            g.drawLine(0, i, WIDTH * SCALE, i);
        }
        g.setColor(new Color(252, 255, 0));
        for (int i = 0; i < snake.length; i++) {
            g.fillOval(snake.snakeX[i] * SCALE + 1, snake.snakeY[i] * SCALE + 1, SCALE - 1, SCALE - 1);

//            if (i == 0) {
//                g.fillOval(snake.snakeX[i]*SCALE+1, snake.snakeY[i]*SCALE+1, SCALE/2, SCALE/2);
//            } else if (i == snake.length - 1){
//                g.fillOval(snake.snakeX[i]*SCALE+1, snake.snakeY[i]*SCALE+1, SCALE/4, SCALE/4);
//            } else {
//                g.fillOval(snake.snakeX[i]*SCALE+1, snake.snakeY[i]*SCALE+1, SCALE/3, SCALE/3);
//            }
        }
    }

    public void run(JFrame parent) {
        PARENT = parent;
        JFrame frame = new JFrame("Catch this frog!");
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH * SCALE + 47, HEIGHT * SCALE - 3);
        frame.setLocationRelativeTo(null);
        parent.setVisible(false);

        JPanel panel = new JPanel();
        panel.add(new Game());
        panel.add(start);
        panel.add(stop);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
