package Models.GameModels.RealModels.Trap;
import Models.GameModels.RealModels.Trap.Trap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class Accelerate extends Trap {

    //constructors
    public Accelerate()
    {
        super();
        this.setName("Accelerate");
    }

    public void draw(Graphics g){
        Image img_lvl1 = new ImageIcon("image/trap/speedup.png").getImage();
        g.drawImage(img_lvl1, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);
    }

}
