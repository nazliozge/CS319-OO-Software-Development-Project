package Models.GameModels.MetaModels;

import Models.GameModels.Buyable.Buyable;
import Models.GameModels.RealModels.Collectible;
import Models.Account.Account;
import Models.GameModels.UserCharacter;

import java.awt.*;
import java.util.Timer;

/**
 * Created by Meder on 23/04/16.
 */
public class RiverGame {

    private River river;
    private Store store;
    private Timer stream;
    private Collectible tempWallet;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public RiverGame(){
        river = new River();
        store = new Store();
        tempWallet = new Collectible();
        stream = new Timer();
    }

    public RiverGame(River river, Store store, Timer stream, Collectible tempWallet) {
        this.river = river;
        this.store = store;
        this.stream = stream;
        this.tempWallet = tempWallet;
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - END ===============
    //++++++++++++++++++++++++++++++++++++++++++++++++



    //++++++++++++++++++++++++++++++++++++++++++++++++
    //=================== METHODS ====================
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public void increaseGold(Collectible collectible){
        updateWallet(collectible.getAmount());
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

    //============ !! NEEDS IMPLEMENTATION !! ============

    public void draw(Graphics g){}

    public int storeEvent(Buyable source, int type){return -1;}


}
