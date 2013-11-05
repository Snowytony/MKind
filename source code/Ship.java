/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mikeengine;

/**
 *
 * @author MWatkins
 */
public abstract class Ship extends OnScreenObject {

    Gun myGun;
    int[] fLocations = new int[16];

    public Ship(int x, int y, int sizeX, int sizeY, int cxMax, int cxMin, int cyMax, int cyMin) {
        super(x, y, sizeX, sizeY, cxMax, cxMin, cyMax, cyMin);
        setupLocations();
    }

    
    public void setupLocations(){
        fLocations[0] = xmin;
        fLocations[1] = getYMax();
        fLocations[2] = xmin+(xsize/2);
        fLocations[3] = getYMax();
        fLocations[4] = getXMax();
        fLocations[5] = getYMax();
        fLocations[6] = xmin;
        fLocations[7] = ymin+(ysize/2);
        fLocations[8] = getXMax();
        fLocations[9] = ymin+(ysize/2);
        fLocations[10] = xmin;
        fLocations[11] = ymin;
        fLocations[12] = xmin+(xsize/2);
        fLocations[13] = ymin;
        fLocations[14] = getXMax();
        fLocations[15] = ymin;
    }



}
