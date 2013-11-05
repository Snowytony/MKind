package mikeengine;

import java.util.ArrayList;

/**
 *
 * @author MWatkins
 */
public class Gun {

    boolean firesLeft;//does it fire left or right
    boolean enemyBullets;//should the bullets kill the player
    int[] fireLocations = new int[16];
    boolean spread,beam,wide,burst, clear ,sidebeams, rear, rearbeam;
    /*
     10,11 12,13 14,15
     6,7         8,9
     0,1   2,3   4,5
     */
    Gun(boolean playerGun, boolean fireRight, int bulletsPerFire, int[] locations) {
        firesLeft = !fireRight;
        enemyBullets = !playerGun;
        fireLocations = locations;
    }
    public void addSpread(){
        spread = true;
    }
    public void addFBeam(){
        beam = true;
    }
    public void addWide(){
        wide = true;
    }
    public void addRear(){
        rear = true;
    }
    public void addSideBeams(){
        sidebeams = true;
    }
    public void addRearBeam(){
        rearbeam = true;
    }
    public void addBurst(){
        burst = true;
    }
    public void addClear(){
        clear = true;
    }
    

}

