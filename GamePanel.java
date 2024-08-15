import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Paddle paddle;
    private Ball ball;
    private List<Brick> bricks;
    private Timer timer;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        paddle = new Paddle(300, 550, 100, 10);
        ball = new Ball(400, 300, 20);
        bricks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                bricks.add(new Brick(j * 80 + 10, i * 30 + 10, 70, 20));
            }
        }
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paddle.move();
        ball.move();

        // Ball and paddle collision
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.setDy(-ball.getDy());
        }

        // Ball and brick collision
        for (Brick brick : bricks) {
            if (brick.isVisible() && ball.getBounds().intersects(brick.getBounds())) {
                ball.setDy(-ball.getDy());
                brick.setVisible(false);
                break;
            }
        }

        // Check if ball falls below paddle
        if (ball.getBounds().getY() > 600) {
            timer.stop();
            System.out.println("Game Over");
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) { paddle.keyPressed(e); }

    @Override
    public void keyReleased(KeyEvent e) { paddle.keyReleased(e); }

    @Override
    public void keyTyped(KeyEvent e) {}
}