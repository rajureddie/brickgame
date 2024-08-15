package brickgame;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        // Create a new JFrame to hold the game panel
        JFrame frame = new JFrame("Brick Breaker Game");
        
        // Create the game panel and add it to the frame
        GamePanel panel = new GamePanel();
        frame.add(panel);
        
        // Set frame properties
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
