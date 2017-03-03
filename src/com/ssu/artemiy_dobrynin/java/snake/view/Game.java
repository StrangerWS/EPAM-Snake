package com.ssu.artemiy_dobrynin.java.snake.view;

import javax.swing.*;

/**
 * Created by DobryninAM on 03.03.2017.
 */
public class Game extends JFrame {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    public static void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH*SCALE, HEIGHT*SCALE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
