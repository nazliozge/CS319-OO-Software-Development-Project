package Models.GameModels.Buyable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nazli on 24/04/16.
 */


public class Deceleration extends ExclusiveBoost{

    //constructors
    public Deceleration()
    {
        super();
        this.setDuration(5);
        this.setName("Deceleration");
        this.setPrice(30);	//initial price to unlock
    }

    public void draw(Graphics g){
        Image img_lvl1 = new ImageIcon("image/boost/slowdown21.png").getImage();
        Image img_lvl2 = new ImageIcon("image/boost/slowdown22.png").getImage();
        Image img_lvl3 = new ImageIcon("image/boost/slowdown23.png").getImage();

        if(this.getLevel() == 1)
            g.drawImage(img_lvl1, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);
        else if(this.getLevel() == 2)
            g.drawImage(img_lvl2, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);
        else
            g.drawImage(img_lvl3, super.getxLoc(), super.getyLoc(), super.getxSize(), super.getySize(), null);
    }


    //when it is unlocked, its level becomes automatically 1.
    public void unlock()
    {
        setIsUnlocked(true);
        setLevel(1);
        setPrice(35);	//price when it is level-1 for it to be level-2
    }


    public boolean upgrade()
    {
        //increment the current level if it is unlocked
        if(this.getLevel() == 1 && isUnlocked())
        {
            setDuration(7);
            setLevel(2);
            setPrice(40);	//price for upgrade from level-2 to level-3
            return true;
        }
        else if(this.getLevel() == 2 && isUnlocked())
        {
            //no price req'd. It is already in the maximum level.
            setDuration(10);
            setLevel(3);
            return true;
        }
        return false;

    }

}
