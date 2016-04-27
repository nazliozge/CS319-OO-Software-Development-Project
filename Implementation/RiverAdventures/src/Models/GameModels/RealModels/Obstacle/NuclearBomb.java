package Models.GameModels.RealModels.Obstacle;
import Models.GameModels.Drawable;
import Models.GameModels.RealModels.Obstacle.Obstacle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class NuclearBomb extends Obstacle {

    //constructors
    public NuclearBomb()
    {
        super();
        this.setHealthDecAmount(90);    //can be changed later!
        this.setName("NuclearBomb");
    }

    public void draw(Graphics g){
        Image img = new ImageIcon("image/obstacle/nuclearBomb.png").getImage();
        g.drawImage(img, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);
    }

}
