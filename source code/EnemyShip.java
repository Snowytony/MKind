package mikeengine;

import java.awt.Color;

/**
 *
 * @author MWatkins
 */
public class EnemyShip extends Ship{
    
EnemyShip(int x, int y, int size, int conxMax, int conxMin, int conyMax, int conyMin) {
        super(x, y, size, size, conxMax, conxMin, conyMax, conyMin);
        color = Color.red;

    }

    @Override
    protected void checkEdge() {
        
        if ((xmin < containerXMin || getXMax() > containerXMax) && run != 0) {
            run *= -1;
        }
        if ((ymin < 0 || getYMax() > containerYMax) && rise != 0) {
            rise *= -1;
        }
    }


    
}
