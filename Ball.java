package brickgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y, diameter;
    private int dx, dy;
    private Color color;

    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.dx = 2;
        this.dy = -2;
        this.color = Color.RED;
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0 || x > 800 - diameter) dx = -dx;
        if (y < 0) dy = -dy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public void setDx(int dx) { this.dx = dx; }
    public void setDy(int dy) { this.dy = dy; }
}
