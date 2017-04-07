package com.ssu.artemiy_dobrynin.java.snake.view;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DobryninAM on 03.03.2017.
 */
public class MainMenu {
    public static void run() {
        final JFrame window = new JFrame("Snake by StrangerWS");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel caption = new JLabel("Snake");
        JPanel panel = new JPanel();

        JButton newGame = new JButton("New Game");
        JButton options = new JButton("Options");
        JButton exit = new JButton("Exit");

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game().run(window);
            }
        });

        panel.add(caption);
        panel.add(newGame);
        panel.add(options);
        panel.add(exit);

        window.getContentPane().add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
