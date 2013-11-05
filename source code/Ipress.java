package mikeengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ipress implements KeyListener {

    boolean space, left, right, up, down;
Ipress(){
    space = false;
    left = false;
    right = false;
    up = false;
    down = false;
    
}
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() >= 37 && e.getKeyCode() <= 40) {
            directional(e.getKeyCode());
        } else if (e.getKeyCode() == 32) {
            space = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void directional(int dir) {
        if (dir == 37) {
            left = true;
        } else if (dir == 38) {
            up = true;
        } else if (dir == 39) {
            right = true;
        } else if (dir == 40) {
            down = true;
        }
    }


    public boolean getLeft() {
        if (left) {
            left = false;
            return true;
        } else {
            return false;

        }
    }

    public boolean getRight() {
        if (right) {
            right = false;
            return true;
        } else {
            return false;

        }
    }

    public boolean getUp() {
        if (up) {
            up = false;
            return true;
        } else {
            return false;

        }
    }

    public boolean getDown() {
        if (down) {
            down = false;
            return true;
        } else {
            return false;

        }
    }
    public boolean getSpace() {
        if (space) {
            space = false;
            return true;
        } else {
            return false;

        }
    }

}
