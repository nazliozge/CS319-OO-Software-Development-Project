package Models.GameModels.RealModels.Obstacle;
import Models.GameModels.Drawable;
import Models.GameModels.RealModels.Obstacle.Obstacle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class Stone extends Obstacle{

    //constructors
    public Stone()
    {
        super();
        this.setHealthDecAmount(40);    //can be changed later!
        this.setName("Stone");
    }

    public void draw(Graphics g){
        Image img = new ImageIcon("image/obstacle/stone.png").getImage();
        g.drawImage(img, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);
    }

}
