package Models.GameModels.RealModels.Collectible;

import Models.GameModels.Drawable;

import javax.swing.*;
import java.awt.*;


public class CoinBag extends Collectible implements Drawable {

    public CoinBag()
    {
        super();
        setAmount(10);
    }

    //overwritten method from RiverObject
    public void draw(Graphics g){
        Image img = new ImageIcon("image/collectible/coinBag.png").getImage();
        g.drawImage(img, super.getxLoc() , super.getyLoc(), super.getxSize(), super.getySize(), null);
    }



}