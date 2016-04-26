package Models.GameModels.RealModels;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class Trap extends RiverObject{


    //attributes
    private double duration;

    //constructors
    public Trap()
    {
        duration = 5.0;
    }   //duration time is initially 5 seconds

    //overwritten method from RiverObject
    public void draw(Graphics g){
        //TODO
    }

    //setters & getters
    public void setDuration(double time)
    {
        duration = time;
    }

    public double getDuration()
    {
        return duration;
    }

}
