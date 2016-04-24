package Models.GameModels.RealModels;
import java.awt.*;


/**
 * Created by Nazli on 24/04/16.
 */


public class Obstacle extends RiverObject{
    //attributes
    private int healthDecAmount;

    //constructors
    public Obstacle()
    {
        healthDecAmount = 0;
    }

    //overwritten method from RiverObject
    public void draw(Graphics g){
        //TODO
    }

    //setters & getters
    public void setHealthDecAmount(int amount)
    {
        healthDecAmount = amount;
    }

    public double getHealthDecAmount()
    {
        return healthDecAmount;
    }


}
