package MetaModels;

import Buyable.Buyable;
import RealModels.Collectible;
import Account.Account;

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

    public RiverGame(River river, Store store, Timer stream, Collectible tempWallet) {
        this.river = river;
        this.store = store;
        this.stream = stream;
        this.tempWallet = tempWallet;
    }

    public void increaseGold(Collectible collectible){}

    public void updateUserCharacter(UserCharacter character){}

    public void loadStore(Account account){}

    public void move(String direction){}

    public void updateSpeedMode( double rate){}

    public void updateWallet (int amount){}

    public int storeEvent(Buyable source, int type){return -1;}

    public void draw(Graphics g){}



    public River getRiver() {
        return river;
    }

    public void setRiver(River river) {
        this.river = river;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Timer getStream() {
        return stream;
    }

    public void setStream(Timer stream) {
        this.stream = stream;
    }

    public Collectible getTempWallet() {
        return tempWallet;
    }

    public void setTempWallet(Collectible tempWallet) {
        this.tempWallet = tempWallet;
    }
}
