package MetaModels;

import Buyable.Character;
import Buyable.ExclusiveBoost;

import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class Store {

    private Character[] characters;
    private ExclusiveBoost[] boosts;

    public Store(Character[] characters, ExclusiveBoost[] boosts) {
        this.characters = characters;
        this.boosts = boosts;
    }

    public boolean buy(ExclusiveBoost exclusiveBoost){return true;}

    public boolean upgrade(ExclusiveBoost exclusiveBoost){return true;}

    public boolean equip(Character character){return true;}

    public boolean unlock( Character character){return true;}

    public void draw (Graphics g){}



    public Character[] getCharacters() {
        return characters;
    }

    public void setCharacters(Character[] characters) {
        this.characters = characters;
    }

    public ExclusiveBoost[] getBoosts() {
        return boosts;
    }

    public void setBoosts(ExclusiveBoost[] boosts) {
        this.boosts = boosts;
    }
}
