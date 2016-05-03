package Models.GameModels.RealModels.Trap;
import Models.GameModels.RealModels.RiverObject;

import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class Trap extends RiverObject {


    //attributes
    private int duration;

    //constructors
    public Trap()
    {
        duration = 5;
    }   //duration time is initially 5 seconds

    //overwritten method from RiverObject
    public void draw(Graphics g){
        //TODO
    }

    //setters & getters
    public void setDuration(int time)
    {
        duration = time;
    }

    public int getDuration()
    {
        return duration;
    }

}
