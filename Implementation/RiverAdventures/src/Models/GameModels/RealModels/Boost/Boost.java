package Models.GameModels.RealModels.Boost;

import Models.GameModels.RealModels.RiverObject;

/**
 * Created by Meder on 23/04/16.
 * Updated by Nazli on 24/04/16.
 */

public abstract class Boost extends RiverObject {

    public Boost(String name, String effect, int xLoc, int yLoc, int ySize) {
        super(name, effect, xLoc, yLoc, ySize);
    }

    //default constructor
    public Boost(){

    }



}
