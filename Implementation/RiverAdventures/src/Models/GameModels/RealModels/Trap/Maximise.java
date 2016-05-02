package Models.GameModels.RealModels.Trap;
import Models.GameModels.RealModels.Trap.Trap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class Maximise extends Trap {

    //constructors
    public Maximise()
    {
        super();
        this.setName("Maximise");
    }

    public void draw(Graphics g){
        Image img_lvl1 = new ImageIcon("image/trap/maxic.png").getImage();
        g.drawImage(img_lvl1, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);

    }

}
