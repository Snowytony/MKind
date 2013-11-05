package mikeengine;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 * This should be a reusable Main class which constantly
 * repaints a canvas panel for a game.
 * MWatkins Oct 30, 2013
 */
public class MikeEngine {

    static final int frameWidth = 1300;
    static final int frameHeight = 800;
    static final int canvasWidth = 1292;
    static final int canvasHeight = 770;
    static interactivePanel canvas;
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
            canvas.move();
            canvas.repaint();
        }

    }

    public static void gameInit() {//code to run at start of game
        makeScreen();//creates canvas/frame, and displays them
        
        //For testing core mechanics:
        createPlayerShip();
        createEnemyShips();
        //\
    }

    public static void makeScreen() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);//lock game resolution
        frame.setVisible(true);
        canvas = new interactivePanel();
        frame.getContentPane().add(canvas);
        canvas.requestFocusInWindow();

    }

    public static void createPlayerShip() {//adding a player ship to the canvas
        PlayerShip playerShip = new PlayerShip(0, 0, 25, canvasWidth, 0, canvasHeight, 0);
        playerShip.setGraphic("pics/ship1.png");
        canvas.addObject(playerShip);
    }

    private static void createEnemyShips() {//adding 3 enemies to the canvas with each skin.
        for (int i = 0; i < 2; i++) {
            EnemyShip eShip = new EnemyShip((int) (Math.random() * 1000) + 100, (int) (Math.random() * 1000) + 100, 25, canvasWidth, 200, canvasHeight, 0);
            eShip.setMovement(1, -1);
            eShip.setGraphic("pics/eShip" + ((i%5)+1) + ".png");
            canvas.addObject(eShip);
        }
    }
}
