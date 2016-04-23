package Models.GameModels.MetaModels;

import Models.GameModels.RealModels.RiverObject;

import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */

public class Line {

    private double yLoc;
    private RiverObject objects[];

    public double getyLoc() {
        return yLoc;
    }

    public void draw(Graphics g){

    }
    public void removeObject(int index){

    }
    public void move(){

    }


    public void setyLoc(double yLoc) {
        this.yLoc = yLoc;
    }

    public RiverObject[] getObjects() {
        return objects;
    }

    public void setObjects(RiverObject[] objects) {
        this.objects = objects;
    }

    public Line(double yLoc, RiverObject[] objects) {

        this.yLoc = yLoc;
        this.objects = objects;
    }
}
