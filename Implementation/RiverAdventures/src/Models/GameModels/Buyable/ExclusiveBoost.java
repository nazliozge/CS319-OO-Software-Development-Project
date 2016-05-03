package Models.GameModels.Buyable;
import java.awt.*;
import Models.GameModels.RealModels.Boost.Boost;

/**
 * Created by Meder on 23/04/16.
 * Updated by Nazli on 24/04/16.
 */

public class ExclusiveBoost extends Boost implements Buyable{

    //ATTRIBUTES
    private int duration; 	//for others
    private int limit;	//for shield
    private int price;
    private static int level;
    private static boolean isUnlocked;
    private int healthIncAmount;


    //CONSTRUCTOR
    public ExclusiveBoost()
    {
        duration = 0;
        limit = 0;
        price = 0;
        level = 0;
        isUnlocked = false;
        healthIncAmount = 0;

    }

    //from Buyable interface
    public int getPrice() {
        return price;
    }

    //Overwritten method from RiverObject
    public void draw(Graphics g)
    {
        //TODO
    }

    public boolean upgrade()
    {
        //increment the current level if it is unlocked
        if(level == 1 && isUnlocked)
        {
            level = 2;
            return true;
        }
        else if(level == 2 && isUnlocked)
        {
            level = 3;
            return true;
        }
        return false;

    }

    //when it is unlocked, its level becomes automatically 1.
    public void unlock()
    {
        isUnlocked = true;
        level = 1;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void setIsUnlocked(boolean b)
    {
        isUnlocked = b;
    }


    public boolean getIsUnlocked()
    {
        return isUnlocked;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public boolean isUnlocked()
    {
        return isUnlocked;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getLimit()
    {
        return limit;
    }


    public void setHealthIncAmount(int amount)
    {
        healthIncAmount = amount;
    }

    public int getHealthIncAmount()
    {
        return healthIncAmount;
    }


}
