package mikeengine;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 *
 * MWatkins Oct 30, 2013
 */
public class MikeEngine {

    static final int fx = 1300;
    static final int fy = 800;
    static final int px = 1292;
    static final int py = 770;
    static interactivePanel ballPanel;
    static JFrame frame;

    public static void pause() {
        try {
            Thread.sleep(10); // wait 5ms
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end method pause

    public static void main(String[] args) {
        gameInit();

        while (true) {
            pause();
            ballPanel.move();
            ballPanel.repaint();
        }

    }

    public static void gameInit() {
        makeScreen();
        createPlayerShip();
        createEnemyShips();
    }

    public static void makeScreen() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(fx, fy);
        frame.setResizable(false);
        frame.setVisible(true);
        ballPanel = new interactivePanel();
        frame.getContentPane().add(ballPanel);
        ballPanel.requestFocusInWindow();

    }

    public static void createPlayerShip() {
        PlayerShip playerShip = new PlayerShip(0, 0, 25, px, 0, py, 0);
        playerShip.setGraphic("pics/ship1.png");
        ballPanel.addObject(playerShip);
    }

    private static void createEnemyShips() {
        for (int i = 0; i < 2; i++) {
            EnemyShip eShip = new EnemyShip((int) (Math.random() * 1000) + 100, (int) (Math.random() * 1000) + 100, 25, px, 200, py, 0);
            eShip.setMovement(1, -1);
            eShip.setGraphic("pics/eShip" + ((i%5)+1) + ".png");
            ballPanel.addObject(eShip);
        }
    }
}
