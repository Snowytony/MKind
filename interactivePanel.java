package mikeengine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class interactivePanel extends JPanel {

    ArrayList<OnScreenObject> objects;
    IClick myClick;
    Ipress myType;
    PlayerShip currentShip;
    private ImageIcon graphic;
    private Image gr;

    interactivePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        objects = new ArrayList<>();
        myClick = new IClick();
        myType = new Ipress();
        this.addMouseListener(myClick);
        this.addKeyListener(myType);

    }

    @Override
    public void paintComponent(Graphics g) {
        paintBackground(g);
        paintObjects(g);
        checkClick();
        checkPress();
    }

    public void move() {
        checkDeadShip();//also sets current ship
        moveObjects();//also removes invisible
        checkCollisions();

    } // end method move

    private void checkClick() {
        if (!myClick.getClicked()) {
            return;
        }
        for (int i = 0; i < objects.size(); i++) {
            OnScreenObject current = objects.get(i);
            if (current.isWithin(myClick.getX(), myClick.getY())) {
                System.out.println("CLICKED");
            }
        }
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        try{
        graphic = new ImageIcon(this.getClass().getResource("pics/testBg.png"));
            gr = graphic.getImage();
            g.drawImage(gr,0,0, this);
        } catch(Exception e){
            System.out.println("BG Error: " + e);
        }
        
    }

    private void paintObjects(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            OnScreenObject current = objects.get(i);
            g.setColor(current.getColor());
            if(current.getGraphic()!=null){
                g.drawImage(current.getGraphic(),current.getXMin(), current.getYMin(), this);
            } else {
            g.fillOval(current.getXMin(), current.getYMin(), current.getXSize(), current.getYSize());
            }
        }
    }

    public void addObject(OnScreenObject toAdd) {
        objects.add(toAdd);
    }

    private void checkPress() {
        if (myType.getDown()) {
            objects.get(0).nudge(false, 3);
        }
        if (myType.getUp()) {
            objects.get(0).nudge(false, -3);
        }
        if (myType.getLeft()) {
            objects.get(0).nudge(true, -3);
        }
        if (myType.getRight()) {
            objects.get(0).nudge(true, 3);
        }
        if (myType.getSpace()) {
            fire();
        }
    }

    private void fire() {
        OnScreenObject shotBullet = new Bullet(currentShip.getXMax(), ((currentShip.getYMax() - currentShip.getYMin()) / 2) + currentShip.getYMin(), 5,5);
        int shipBonus = 0;
        if (currentShip.getRun() > 0) {
            shipBonus = currentShip.getRun();
        }
        shotBullet.setMovement(0, shipBonus + 5);
        addObject(shotBullet);
    }

    private void checkCollisions() {
        for (int i = 0; i < objects.size() - 1; i++) {
            for (int j = 0; j < objects.size(); j++) {
                if (j != i) {
                    OnScreenObject current = objects.get(i);
                    OnScreenObject next = objects.get(j);
                    if (current.checkCollide(next)) {
                        objects.remove(i);
                        if (i < j) {
                            objects.remove(j - 1);
                        } else {
                            objects.remove(j);
                        }
                    }
                }
            }
        }
    }

    private void checkDeadShip() {
        if (objects.size() > 0) {
            try {
                currentShip = (PlayerShip) objects.get(0);
            } catch (Exception e) {
                System.out.println("GAME OVER!");
                System.exit(0);
            }
        }
    }

    private void moveObjects() {
        for (int i = 0; i < objects.size(); i++) {
            OnScreenObject current = objects.get(i);
            current.move();
            if (!current.getVisible()) {
                objects.remove(i);
            }
        }
    }
}
