package com.williamdaw.RPG_game;

import javax.swing.*;

public class Judd {
    public static JFrame mainFrame = new JFrame();

//    public static JLabel areaText = new JLabel(Areas[areaIndex], JLabel.LEFT); // commented due to compilation errors
//    public static JLabel roomText = new JLabel(Rooms[areaIndex][roomIndex], JLabel.RIGHT); // commented due to compilation errors

    public static void updateGUI() {
        // sets up the start-up screen
        mainFrame.setSize(1000, 500);
        mainFrame.setLocation(50, 100);
        mainFrame.setTitle(" ");
//        mainFrame.getContentPane().setBackground(Color.decode(Colour[index][2])); // commented due to compilation errors
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
    }

    public static void playGame() {
//        areaText.setVisible(true); // commented due to compilation errors
//        roomText.setVisible(true); // commented due to compilation errors
    }
}
