package Models.GameModels.RealModels.Obstacle;
import Models.GameModels.Drawable;
import Models.GameModels.RealModels.Obstacle.Obstacle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class ChemicalHazard extends Obstacle{

    //constructors
    public ChemicalHazard()
    {
        super();
        this.setHealthDecAmount(60);    //can be changed later!
        this.setName("ChemicalHazard");
    }

    public void draw(Graphics g){

        Image img = new ImageIcon("image/obstacle/chemicalHazard.png").getImage();
        g.drawImage(img, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);

    }

}
