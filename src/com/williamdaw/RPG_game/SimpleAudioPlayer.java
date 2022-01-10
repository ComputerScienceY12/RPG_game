package com.williamdaw.RPG_game;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleAudioPlayer {
    private static String theme;
    Long currentFrame;
    Clip clip;
    String status;
    AudioInputStream audioInputStream;

    public SimpleAudioPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(theme));

        clip = AudioSystem.getClip();

        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main(int timing) {
        try {
            if (timing == 0) theme = "intro_theme.wav"; else if (timing == 1) theme = "end_theme.wav";
            SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer();

            audioPlayer.play();
            Scanner sc = new Scanner(System.in);

            if (timing == 0) Thread.sleep(5000); else if (timing == 1) Thread.sleep(153000);

            sc.close();
            audioPlayer.stop();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void play() {
        clip.start();
        status = "play";
    }

    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }
}