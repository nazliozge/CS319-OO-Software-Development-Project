package Models.GameModels.RealModels.Collectible;

import javax.swing.*;
import java.awt.*;


public class Coin extends Collectible {

    public Coin()
    {
        super();
        setAmount(1);
    }

    //overwritten method from RiverObject
    public void draw(Graphics g){
        Image img = new ImageIcon("image/collectible/coin.png").getImage();
        g.drawImage(img, super.getxLoc() , super.getyLoc(), super.getxSize(), super.getySize(), null);
    }



}