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

    public Game() {
        addMouseListener(new SnakeControl(snake));
        setFocusable(true);
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
            if (i == 0) {
                g.fillOval(snake.snakeX[i] * SCALE + 1 + SCALE / 4, snake.snakeY[i] * SCALE + 1 + SCALE / 4, SCALE / 2, SCALE / 2);
            } else if (i == snake.length - 1) {
                g.fillOval(snake.snakeX[i] * SCALE + 1 + 3 * SCALE / 8, snake.snakeY[i] * SCALE + 1 + 3 * SCALE / 8, SCALE / 4, SCALE / 4);
            } else {
                g.fillOval(snake.snakeX[i] * SCALE + 1 + SCALE / 3, snake.snakeY[i] * SCALE + 1 + SCALE / 3, SCALE / 3, SCALE / 3);
            }
        }
    }

    public void run(JFrame parent) {
        PARENT = parent;
        JFrame frame = new JFrame("Catch this frog!");
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE + 1);
        frame.setLocationRelativeTo(null);
        parent.setVisible(false);

        JPanel bottomPanel = new JPanel();
        JPanel parentPanel = new JPanel();
        parentPanel.setSize(WIDTH * SCALE + 47, HEIGHT * SCALE - 3);
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(new Game(), BorderLayout.CENTER);
        parentPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(start);
        bottomPanel.add(stop);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(snake).start();
            }
        });
        frame.getContentPane().add(parentPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
