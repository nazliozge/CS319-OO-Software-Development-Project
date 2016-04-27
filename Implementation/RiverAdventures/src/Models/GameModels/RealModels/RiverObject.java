package Models.GameModels.RealModels;
import Models.GameModels.Drawable;

import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class RiverObject implements Drawable{

    private String name;
    private String effect;  //we can delete effect, since we are creating child classes
    private int xLoc;
    private int yLoc; //NEW!!! added for the sake of draw method.
    private int ySize;
    private int xSize;

    //default constructor
    public RiverObject()
    {
        name="";
        effect="";
        xLoc = 0;
        ySize = 70;
        xSize = 90;
    }

    public RiverObject(String name, String effect, int xLoc, int yLoc, int ySize) {
        this.name = name;
        this.effect = effect;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.ySize = ySize;
    }

    public void draw(Graphics g){
        System.out.println("This is draw in RiverObject class");
    } //method should be overwritten by child classes

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

    public int getyLoc(){
        return yLoc;
    }
    public void setyLoc(int yLoc){
        this.yLoc = yLoc;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public int getxSize(){
        return this.xSize;
    }
}
