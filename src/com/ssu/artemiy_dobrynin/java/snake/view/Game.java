package com.ssu.artemiy_dobrynin.java.snake.view;

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

    Snake snake = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000/SPEED, this);

    public Game() {

    }

    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(new Color(255, 255, 255));

        for (int i = 0; i <= WIDTH * SCALE; i += SCALE) {
            g.drawLine(i, 0, i, HEIGHT * SCALE);
        }
        for (int i = 0; i <= HEIGHT * SCALE; i += SCALE) {
            g.drawLine(0, i, WIDTH * SCALE, i);
        }
    }

    public static void run(JFrame parent) {
        PARENT = parent;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE - 3);
        frame.setLocationRelativeTo(null);
        parent.setVisible(false);
        frame.add(new Game());

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
