package RealModels;

import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class RiverObject {

    private String name;
    private String effect;
    private int xLoc;
    private double ySize;

    public RiverObject(String name, String effect, int xLoc, double ySize) {
        this.name = name;
        this.effect = effect;
        this.xLoc = xLoc;
        this.ySize = ySize;
    }

    public void draw(Graphics g){

    }

    public int checkType(){
        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public double getySize() {
        return ySize;
    }

    public void setySize(double ySize) {
        this.ySize = ySize;
    }
}
