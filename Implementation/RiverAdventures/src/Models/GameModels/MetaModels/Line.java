package Models.GameModels.MetaModels;

import Models.GameModels.RealModels.RiverObject;

import java.awt.*;
import java.util.ArrayList;
import java.lang.*;
/**
 * Created by Meder on 23/04/16.
 */



public class Line {

    //THESE VARIABLES' MAGNITUDES SHOULD CHANGE LATER.z
    final static int MOVE_BY = 4;
    final static int LINE_WIDTH = 40;

    private double yLoc;
    private ArrayList<RiverObject> objects;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public Line(double yLoc) {
        this.yLoc = yLoc;
        objects = new ArrayList<RiverObject>();
    }

    public Line(){
        this.yLoc = 0;
        objects = new ArrayList<RiverObject>();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - END ===============
    //++++++++++++++++++++++++++++++++++++++++++++++++


    //++++++++++++++++++++++++++++++++++++++++++++++++
    //=================== METHODS ====================
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public double getyLoc(){
        return yLoc;
    }

    public void setyLoc(double newLoc){
        this.yLoc = newLoc;
    }

    public void removeObject(int index){
        objects.remove(index);
    }

    public void addObject(RiverObject object){
        objects.add(object);
    }


    /* EVERYTIME WHEN IT IS CALLED, IT UPDATES THE POSITION OF THE LINE*/
    public void move(){
        yLoc += MOVE_BY;
    }

    public ArrayList<RiverObject> getRiverObjects(){
        return objects;
    }

    //=============== !! NEW METHOD(s) !! ================

    /* IT JUST FILLS THE LINE WITH PROPER RIVER OBJECTS
    *  ACCORDING TO THE SIZE OF THE USER CHARACTER AND LINE*/

    public void fillLine(double userCharacterWidth){
        int start = 0;
        int end = LINE_WIDTH;

        do{
            int range = (end - start) + 1;
            int location = Math.random() * range + start;
            RiverObject object = new RiverObject();
            object.setxLoc(location);

            /*Objective of setting these to 'start' is to make sure to have enough space
            * between obstacles for user character to pass through.*/

            start = location + object.getxSize() + (int)userCharacterWidth;

        }while(end - start > userCharacterWidth)
    }

    //=============== !! NEW METHOD(s) !! ================


    //============ !! NEEDS IMPLEMENTATION !! ============
    public void draw(Graphics g){
    }
}
