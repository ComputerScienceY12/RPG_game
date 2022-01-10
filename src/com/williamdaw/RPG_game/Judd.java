package com.williamdaw.RPG_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Judd {
    public static JFrame mainFrame = new JFrame();

    public static JLabel areaText = new JLabel(Areas[areaIndex], JLabel.LEFT);
    public static JLabel roomText = new JLabel(Rooms[areaIndex][roomIndex], JLabel.RIGHT);

    public static void updateGUI() {
        // sets up the start-up screen
        mainFrame.setSize(1000, 500);
        mainFrame.setLocation(50, 100);
        mainFrame.setTitle(" ");
        mainFrame.getContentPane().setBackground(Color.decode(Colour[DansCode.index][2]));
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
    }

    public static void playGame(){
        areaText.setVisible(true);
        roomText.setVisible(true);
        // sets up the text for playing the game

    }

    public static void main() {
        updateGUI();

        lightButton.addActionListener(new ActionListener() { //Apply Light theme
            @Override
            public void actionPerformed(ActionEvent e) { index = 0; updateGUI();}});
        darkButton.addActionListener(new ActionListener() { //Apply Dark theme
            @Override
            public void actionPerformed(ActionEvent e) { index = 1; updateGUI();}});
        contrastButton.addActionListener(new ActionListener() { //Apply Contrast theme
            @Override
            public void actionPerformed(ActionEvent e) { index = 2; updateGUI();}});

        playButton.addActionListener(new ActionListener() { // PLAY GAME
            @Override
            public void actionPerformed(ActionEvent e) {
                playButton.setVisible(false);
                howToPlayButton.setVisible(false);
                settingsButton.setVisible(false);
                exitButton.setVisible(false);
                titleText.setVisible(false);
                backButton.setVisible(true);
                playGame();
            }
        });
        howToPlayButton.addActionListener(new ActionListener() { // HOW TO PLAY
            @Override
            public void actionPerformed(ActionEvent e) {
                titleText.setText("How To Play");
                playButton.setVisible(false);
                howToPlayButton.setVisible(false);
                settingsButton.setVisible(false);
                exitButton.setVisible(false);
                howToPlayText.setVisible(true);
                backButton.setVisible(true);
            }
        });
        settingsButton.addActionListener(new ActionListener() { // SETTINGS
            @Override
            public void actionPerformed(ActionEvent e) {
                titleText.setText("Settings");
                playButton.setVisible(false);
                howToPlayButton.setVisible(false);
                settingsButton.setVisible(false);
                exitButton.setVisible(false);
                lightButton.setVisible(true);
                darkButton.setVisible(true);
                contrastButton.setVisible(true);
                backButton.setVisible(true);
            }
        });
        exitButton.addActionListener(new ActionListener() { // EXIT GAME
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
        backButton.addActionListener(new ActionListener() { // Return to Menu
            @Override
            public void actionPerformed(ActionEvent e) {
                titleText.setText("The Mansion Murder");
                titleText.setVisible(true);
                playButton.setVisible(true);
                howToPlayButton.setVisible(true);
                settingsButton.setVisible(true);
                exitButton.setVisible(true);
                backButton.setVisible(false);
                howToPlayText.setVisible(false);
                lightButton.setVisible(false);
                darkButton.setVisible(false);
                contrastButton.setVisible(false);
                areaText.setVisible(false);
                roomText.setVisible(false);
            }
        });
    }
}

