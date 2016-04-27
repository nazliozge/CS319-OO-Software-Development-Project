package Models.GameModels.RealModels.Collectible;
import Models.GameModels.RealModels.RiverObject;

import java.awt.*;


/**
 * Created by Meder on 23/04/16.
 * Updated by Nazli on 24/04/16.
 */

public class Collectible extends RiverObject {

    //attributes
    private int amount;

    //constructors
    public Collectible()
    {
        amount = 0;
    }


    //setters & getters
    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public int getAmount()
    {
        return amount;
    }
}
