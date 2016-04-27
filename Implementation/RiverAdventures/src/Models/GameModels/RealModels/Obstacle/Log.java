package Models.GameModels.RealModels.Obstacle;
import Models.GameModels.Drawable;
import Models.GameModels.RealModels.Obstacle.Obstacle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class Log extends Obstacle{

    //constructors
    public Log()
    {
        super();
        this.setHealthDecAmount(20);    //can be changed later!
        this.setName("Log");
    }

    public void draw(Graphics g){
        Image img = new ImageIcon("image/obstacle/log.png").getImage();
        g.drawImage(img, super.getxLoc() , super.getyLoc(), super.getxSize(), super.getySize(), null);
    }

}
