package mikeengine;

import java.awt.Color;

public class PlayerShip extends Ship {

    PlayerShip(int x, int y, int size, int conxMax, int conxMin, int conyMax, int conyMin) {
        super(x, y, size, size, conxMax, conxMin, conyMax, conyMin);
        color = Color.blue;

    }

    @Override
    protected void checkEdge() {
        if ((xmin < containerXMin || getXMax() > containerXMax) && run != 0) {
            if (xmin < containerXMin) {
                setXMin(containerXMin + 1);
            } else {
                setXMin(containerXMax - (getXSize()));
            }
            run = 0;
        }
        if ((ymin < 0 || getYMax() > containerYMax) && rise != 0) {
            if (ymin < containerYMin) {
                setYMin(containerYMin + 1);
            } else {
                setYMin(containerYMax - (getXSize()));
            }
            rise = 0;
        }
    }




}
