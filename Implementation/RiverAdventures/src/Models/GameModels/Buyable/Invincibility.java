package Models.GameModels.Buyable;
import java.awt.Graphics;

/**
 * Created by Nazli on 24/04/16.
 */


public class Invincibility extends ExclusiveBoost{

    //constructors
    public Invincibility()
    {
        super();
        this.setDuration(5);
        this.setName("Invincibility");
        this.setPrice(40);	//initial price to unlock
    }

    public void draw(Graphics g){
        //TODO-- for
    }


    //when it is unlocked, its level becomes automatically 1.
    public void unlock()
    {
        setIsUnlocked(true);
        setLevel(1);
        setPrice(45);	//price when it is level-1 for it to be level-2
    }


    public boolean upgrade()
    {
        //increment the current level if it is unlocked
        if(this.getLevel() == 1 && isUnlocked())
        {
            setDuration(7);
            setLevel(2);
            setPrice(50);	//price for upgrade from level-2 to level-3
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
