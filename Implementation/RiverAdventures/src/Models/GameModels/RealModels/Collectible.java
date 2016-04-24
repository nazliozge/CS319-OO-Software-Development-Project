package Models.GameModels.RealModels;
import java.awt.*;


/**
 * Created by Meder on 23/04/16.
 * Updated by Nazli on 24/04/16.
 */

public class Collectible extends RiverObject{

    //attributes
    private int amount;

    //constructors
    public Collectible()
    {
        amount = 0;
    }

    //overwritten method from RiverObject
    public void draw(Graphics g){
        //TODO
    }

    //setters & getters
    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public double getAmount()
    {
        return amount;
    }
}
