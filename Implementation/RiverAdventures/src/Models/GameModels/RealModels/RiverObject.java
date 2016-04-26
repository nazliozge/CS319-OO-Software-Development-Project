package Models.GameModels.RealModels;
import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class RiverObject {

    private String name;
    private String effect;  //we can delete effect, since we are creating child classes
    private int xLoc;
    private double ySize;
    private int xSize;

    //default constructor
    public RiverObject()
    {
        name="";
        effect="";
        xLoc = 0;
        ySize = 0.0;
    }

    public RiverObject(String name, String effect, int xLoc, double ySize) {
        this.name = name;
        this.effect = effect;
        this.xLoc = xLoc;
        this.ySize = ySize;
    }

    public void draw(Graphics g){} //method should be overwritten by child classes

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

    public int getxSize(){
        return this.xSize;
    }
}
