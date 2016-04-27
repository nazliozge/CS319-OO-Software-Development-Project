package Models.GameModels.RealModels.Collectible;

import Models.GameModels.Drawable;

import java.awt.Graphics;


public class CoinBag extends Collectible implements Drawable {

    public CoinBag()
    {
        super();
        setAmount(10);
    }

    //overwritten method from RiverObject
    public void draw(Graphics g){
        //TODO
    }



}