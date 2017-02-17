package com.ssu.artemiy_dobrynin.java.snake.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DobryninAM on 17.02.2017.
 */
public class Menu extends JFrame {
    JButton startGameButton;
    JButton exitButton;
    JButton optionsButton;
    private JPanel menuPanel;
    private Options options;


    public Menu() {
        initComponents();
    }

    private void initComponents() {
        options = new Options();
        optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                options.getOptionsPanel().setVisible(true);
            }
        });
    }
}
