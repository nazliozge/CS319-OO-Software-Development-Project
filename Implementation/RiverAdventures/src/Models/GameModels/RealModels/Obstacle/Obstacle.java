package Models.GameModels.RealModels.Obstacle;
import Models.GameModels.RealModels.RiverObject;

import java.awt.*;


/**
 * Created by Nazli on 24/04/16.
 */


public class Obstacle extends RiverObject {
    //attributes
    private int healthDecAmount;

    //constructors
    public Obstacle()
    {
        super();
        healthDecAmount = 0;
    }


    //setters & getters


    //I DONT NEED BELOW ARE NECESSARY SINCE WE CREATED THE CHILD CLASSES!!!
    public void setHealthDecAmount(int amount)
    {
        healthDecAmount = amount;
    }

    public double getHealthDecAmount()
    {
        return healthDecAmount;
    }


}
