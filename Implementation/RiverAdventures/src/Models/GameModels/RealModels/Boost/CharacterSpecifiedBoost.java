package Models.GameModels.RealModels.Boost;
import Models.GameModels.RealModels.RiverObject;

import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */



public class CharacterSpecifiedBoost extends Boost {

    //attributes

    //source could be either the Beaver, the Deer, the Crocodile or the Hippopotamus
    private String source;

    //constructors
    public CharacterSpecifiedBoost()
    {
        source = "";
    }

    //overwritten method from RiverObject
    public void draw(Graphics g){
        //TODO
    }

    //getter&setter
    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }


}
