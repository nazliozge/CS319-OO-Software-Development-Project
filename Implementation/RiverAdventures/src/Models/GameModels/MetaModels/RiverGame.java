package Models.GameModels.MetaModels;

import Models.GameModels.Buyable.Buyable;
import Models.GameModels.RealModels.Collectible.Collectible;
import Models.Account.Account;
import Models.GameModels.Buyable.Character;

import java.awt.*;
import java.util.Timer;

/**
 * Created by Meder on 23/04/16.
 */
public class RiverGame {

    private River river;
    private Store store;
    //private Timer stream; We don't need this attribute
    private Collectible tempWallet;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public RiverGame(){
        river = new River();
        store = new Store();
        tempWallet = new Collectible();
    }

    public RiverGame(River river, Store store, Collectible tempWallet) {
        this.river = river;
        this.store = store;
        this.tempWallet = tempWallet;
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - END ===============
    //++++++++++++++++++++++++++++++++++++++++++++++++



    //++++++++++++++++++++++++++++++++++++++++++++++++
    //=================== METHODS ====================
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public void increaseGold(Collectible collectible){
        updateWallet((int)collectible.getAmount());
    }

    public void updateUserCharacter(Character character){
        river.getUserCharacter().setCharacter(character);
    }



    public void move(String direction){
        if(direction == "LEFT")
            river.move("LEFT");
        if(direction == "RIGHT")
            river.move("RIGHT");
    }

    public void update(){
        river.update();
    }

    public void updateWallet (int amount){
        tempWallet.setAmount(amount);
    }


    public void updateSpeedMode( double rate){
        river.setSpeedMode(rate);
    }

    public void loadStore(Account account){
        store.setCharacters(account.getCharStates());
        store.setBoosts(account.getBoostStates());
    }

    public void draw(Graphics g){
        river.draw(g);
    }

    //============ !! NEEDS IMPLEMENTATION !! ============

    public int storeEvent(Buyable source, int type){return -1;}


}
