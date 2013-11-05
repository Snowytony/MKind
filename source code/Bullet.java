
package mikeengine;

import java.awt.Color;

/**
 * @author MWatkins
 */
public class Bullet extends OnScreenObject {
static final int px = 1292;
static final int py = 770;

    Bullet(int startLocX, int startLocY, int xsize, int ysize) {
        super(startLocX, startLocY, xsize, ysize, px, 0, py, 0);
        setGraphic("pics/peaBullet.png");
    }

    @Override
    protected void checkEdge() {
        if (xmin < containerXMin || getXMax() > containerXMax || ymin < 0 || getYMax() > containerYMax) {
            setVisible(false);
        }
    }

}
