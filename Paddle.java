package brickgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle implements KeyListener {
    private int x, y;
    private int width, height;
    private int dx;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = 0;
    }

    public void move() {
        x += dx;
        if (x < 0) x = 0;
        if (x > 800 - width) x = 800 - width;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -5;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 5;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
