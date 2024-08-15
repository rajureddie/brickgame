package brickgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick {
    private int x, y, width, height;
    private Color color;
    private boolean isVisible;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLUE;
        this.isVisible = true;
    }

    public void draw(Graphics g) {
        if (isVisible) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void setVisible(boolean visible) { this.isVisible = visible; }
    public boolean isVisible() { return isVisible; }
}
