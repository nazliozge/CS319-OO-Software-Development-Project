package Models.GameModels.MetaModels;

import Models.GameModels.Buyable.Character;
import Models.GameModels.Buyable.ExclusiveBoost;

import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class Store {

//    private ArrayList<Character> characters;
//    private ArrayList<ExclusiveBoost> boosts;

    /*These are changed according to Nazli's code on Account*/
    private int[] characters;
    private int[] boosts;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public Store() {
        characters = new int[];
        boosts = new int[];
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - END ===============
    //++++++++++++++++++++++++++++++++++++++++++++++++


    //it supposed to be boolean, but no point to make it boolean.
    public void unlock( Character character){
        character.setUnlock(true);
    }

    public void equip(Character character){
        character.setEquipped(true);
    }

    public void setCharacters(int [] characters){
        this.characters = characters;
    }

    public void setBoosts( int[] boosts){
        this.boosts = boosts;
    }

    //============ !! NEEDS IMPLEMENTATION !! ============

    //in these two methods I need to access to account, but I am not sure how to access,
    // because we don't have them as an object.

    public boolean buy(ExclusiveBoost exclusiveBoost){
        return true;}

    public boolean upgrade(ExclusiveBoost exclusiveBoost){
        return exclusiveBoost.update();
    }

    public void draw (Graphics g){}

}
