package com.daniel_judd.gui_rpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static String[][] Colour = {{"#007FAD", "#009DD6", "#FFFFFF", "#C0C0C0"}, {"#2A5BBC", "#3D71D6", "#3B3B3B", "#545454"}, {"#FFF500", "#FFF500", "#000000", "#BDBDBD"}};//Light, Dark, High Contrast //TitleTextColour, MainTextColour, BG Colour, Button BG Colour
    public static String[][] Rooms = {{"Front Garden", "Back Garden"}, {"Porch", "Living Room", "Kitchen", "Bathroom"}, {"Master Bedroom", "Children's Bedroom", "Guest Bedroom", "Bathroom"}}; //Outside, Downstairs, Upstairs
    public static String[] Areas = {"Outside", "Downstairs", "Upstairs"};

    public static int roomIndex, areaIndex, index = 0;

    public static JFrame mainFrame = new JFrame();

    public static JLabel titleText = new JLabel("The Mansion Murder", JLabel.CENTER);
    public static JLabel areaText = new JLabel(Areas[areaIndex], JLabel.LEFT);
    public static JLabel roomText = new JLabel(Rooms[areaIndex][roomIndex], JLabel.RIGHT);
    public static JLabel howToPlayText = new JLabel("Click 'Play Game!'", JLabel.CENTER);
    public static JLabel colourSchemeText = new JLabel("Colour Theme:", JLabel.CENTER);

    public static JButton playButton = new JButton("Play Game!");
    public static JButton howToPlayButton = new JButton("How To Play");
    public static JButton settingsButton = new JButton("Settings");
    public static JButton exitButton = new JButton("Exit");
    public static JButton lightButton = new JButton("Light");
    public static JButton darkButton = new JButton("Dark");
    public static JButton contrastButton = new JButton("Contrast");
    public static JButton backButton = new JButton("X");

    public static void updateGUI() {

        Font labelFont = new Font("Verdana", Font.BOLD, 20);
        Font btnFont = new Font("Verdana", Font.PLAIN, 20);
        Font colourFont = new Font("Verdana", Font.BOLD, 12);
        Font exitFont = new Font("Verdana", Font.BOLD, 30);

        mainFrame.setVisible(true);
        titleText.setVisible(true);
        playButton.setVisible(true);
        howToPlayButton.setVisible(true);
        settingsButton.setVisible(true);
        exitButton.setVisible(true);
        areaText.setVisible(false);
        roomText.setVisible(false);
        howToPlayText.setVisible(false);
        colourSchemeText.setVisible(false);
        lightButton.setVisible(false);
        darkButton.setVisible(false);
        contrastButton.setVisible(false);
        backButton.setVisible(false);

        mainFrame.setSize(1000, 500);
        mainFrame.setLocation(50, 100);
        mainFrame.setTitle(" ");
        mainFrame.getContentPane().setBackground(Color.decode(Colour[Main.index][2]));
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        mainFrame.add(titleText);
        titleText.setBounds(250, 0, 500, 100);
        titleText.setFont(labelFont);
        titleText.setForeground(Color.decode(Colour[index][0]));

        mainFrame.add(areaText);
        areaText.setBounds(100, 20, 200, 50);
        areaText.setFont(labelFont);
        areaText.setForeground(Color.decode(Colour[index][0]));

        mainFrame.add(roomText);
        roomText.setBounds(780, 20, 200, 50);
        roomText.setFont(labelFont);
        roomText.setForeground(Color.decode(Colour[index][0]));

        mainFrame.add(howToPlayText);
        howToPlayText.setBounds(375, 235, 250, 30);
        howToPlayText.setFont(labelFont);
        howToPlayText.setForeground(Color.decode(Colour[index][1]));

        mainFrame.add(colourSchemeText);
        colourSchemeText.setBounds(375, 235, 250, 30);
        colourSchemeText.setFont(labelFont);
        colourSchemeText.setForeground(Color.decode(Colour[index][1]));

        Cursor btnOver = new Cursor(Cursor.HAND_CURSOR);

        mainFrame.add(playButton);
        playButton.setBounds(300, 230, 400, 40);
        playButton.setFont(btnFont);
        playButton.setLayout(null);
        playButton.setForeground(Color.decode(Colour[index][1]));
        playButton.setBackground(Color.decode(Colour[index][3]));
        playButton.setCursor(btnOver);

        mainFrame.add(howToPlayButton);
        howToPlayButton.setBounds(300, 280, 400, 40);
        howToPlayButton.setFont(btnFont);
        howToPlayButton.setLayout(null);
        howToPlayButton.setForeground(Color.decode(Colour[index][1]));
        howToPlayButton.setBackground(Color.decode(Colour[index][3]));
        howToPlayButton.setCursor(btnOver);

        mainFrame.add(settingsButton);
        settingsButton.setBounds(300, 330, 400, 40);
        settingsButton.setFont(btnFont);
        settingsButton.setLayout(null);
        settingsButton.setForeground(Color.decode(Colour[index][1]));
        settingsButton.setBackground(Color.decode(Colour[index][3]));
        settingsButton.setCursor(btnOver);

        mainFrame.add(exitButton);
        exitButton.setBounds(300, 380, 400, 40);
        exitButton.setFont(btnFont);
        exitButton.setLayout(null);
        exitButton.setForeground(Color.decode(Colour[index][1]));
        exitButton.setBackground(Color.decode(Colour[index][3]));
        exitButton.setCursor(btnOver);

        mainFrame.add(lightButton);
        lightButton.setBounds(340, 300, 100, 40);
        lightButton.setFont(colourFont);
        lightButton.setLayout(null);
        lightButton.setForeground(Color.decode(Colour[index][1]));
        lightButton.setBackground(Color.decode(Colour[index][3]));
        lightButton.setCursor(btnOver);

        mainFrame.add(darkButton);
        darkButton.setBounds(450, 300, 100, 40);
        darkButton.setFont(colourFont);
        darkButton.setLayout(null);
        darkButton.setForeground(Color.decode(Colour[index][1]));
        darkButton.setBackground(Color.decode(Colour[index][3]));
        darkButton.setCursor(btnOver);

        mainFrame.add(contrastButton);
        contrastButton.setBounds(560, 300, 100, 40);
        contrastButton.setFont(colourFont);
        contrastButton.setLayout(null);
        contrastButton.setForeground(Color.decode(Colour[index][1]));
        contrastButton.setBackground(Color.decode(Colour[index][3]));
        contrastButton.setCursor(btnOver);

        mainFrame.add(backButton);
        backButton.setBounds(20, 20, 60, 50);
        backButton.setFont(exitFont);
        backButton.setLayout(null);
        backButton.setForeground(Color.decode(Colour[index][1]));
        backButton.setBackground(Color.decode(Colour[index][3]));
        backButton.setCursor(btnOver);

    }

    public static void playGame(){
        areaText.setVisible(true);
        roomText.setVisible(true);

    }

    public static void main(String args[]) {
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