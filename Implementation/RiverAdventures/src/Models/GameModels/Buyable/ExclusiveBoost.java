package Models.GameModels.Buyable;
import java.awt.*;


/**
 * Created by Meder on 23/04/16.
 * Updated by Nazli on 24/04/16.
 */

public class ExclusiveBoost extends Boost implements Buyable{

    //ATTRIBUTES
    private int duration;
    private int limit;
    private int price;
    private int level;
    private boolean isUnlocked;

    //CONSTRUCTOR
    public ExclusiveBoost()
    {
        duration = 0;
        limit = 0;
        price = 0;
        level = 0;
        isUnlocked = false;
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

    //Setters and getters
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

}
