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

    long totalTicks = 0;

    static final int TICK_PER_MOVE = 16;
    static final long SPEED_CHANGE_TICK_NO = 3000;

    private long speedMod = 0;
    private int tickCount = 0;

    private River river;
    private Store store;
    private Stream stream;




    private Collectible tempWallet;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public RiverGame(Account account){
        river = new River();
        store = new Store( account );
        stream = new Stream(this);
    }
    public RiverGame(){
        river = new River();
        store = new Store( );
        stream = new Stream(this);
    }

    public RiverGame(River river, Store store) {
        this.river = river;
        this.store = store;
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
        river.move(direction);
    }

    public void update(){
        river.update();
    }

    // TODO: reorganzie to not do stuff for each tick
    // this is for timer ticks
    public void work(){
        totalTicks ++;
        tickCount ++;
        if( TICK_PER_MOVE - speedMod == tickCount || TICK_PER_MOVE - speedMod <= 0 ){
            update();
            tickCount = 0;
        }
        speedMod = totalTicks / SPEED_CHANGE_TICK_NO;
    }

    public void updateWallet (int amount){
        tempWallet.setAmount(amount);
    }

    public int getTempWallet(){
        System.out.println("Coins: RiverGame " + river.getTotalCoins());
        return river.getTotalCoins();
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

    // NEW METHDOS

    public double getScore(){
        //return tempWallet.getAmount();
        return .0;
    }

    //TODO
    public void pause(){
        stream.pause();
    }

    //TODO
    public void goOn(){
        stream.unpause();
    }

    public void start() { stream.start();}

    //TODO
    private Timer makeTimer(){
        return new Timer();
    }

}
