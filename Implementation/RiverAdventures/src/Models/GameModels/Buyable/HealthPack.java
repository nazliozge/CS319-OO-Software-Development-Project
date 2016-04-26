package Models.GameModels.Buyable;
import java.awt.Graphics;

/**
 * Created by Nazli on 24/04/16.
 */


public class HealthPack extends ExclusiveBoost{

    //constructors
    public HealthPack()
    {
        super();
        this.setName("HealthPack");
        this.setHealthIncAmount(10);
        this.setPrice(15);	//initial price to unlock
    }

    public void draw(Graphics g){
        //TODO-- different picture for each level of shield!
    }


    //when it is unlocked, its level becomes automatically 1.
    public void unlock()
    {
        setIsUnlocked(true);
        setLevel(1);
        setPrice(20);	//price when it is level-1 for it to be level-2
    }


    public boolean upgrade()
    {
        //increment the current level if it is unlocked
        if(this.getLevel() == 1 && isUnlocked())
        {
            setLimit(5);
            setLevel(2);
            setHealthIncAmount(20);
            setPrice(35);	//price for upgrade from level-2 to level-3
            return true;
        }
        else if(this.getLevel() == 2 && isUnlocked())
        {
            //no price req'd. It is already in the maximum level.
            setLimit(7);
            setLevel(3);
            setHealthIncAmount(30);
            return true;
        }
        return false;

    }

}
