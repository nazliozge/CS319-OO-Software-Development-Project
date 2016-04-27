package Models.GameModels.RealModels.Boost;
import Models.GameModels.RealModels.RiverObject;

import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */

public class RareBoost extends RiverObject {

    //attributes
    private double rarity;

    //constructors
    public RareBoost()
    {
        rarity = 0.0;
    }

    //overwritten method from RiverObject
    public void draw(Graphics g){
        //TODO
    }

    //setters & getters
    public void setRarity(double rare)
    {
        rarity = rare;
    }

    public double getRarity()
    {
        return rarity;
    }

}
