package Models.GameModels.MetaModels;

import Models.Account.Account;
import Models.GameModels.Buyable.Character;
import Models.GameModels.Buyable.ExclusiveBoost;

import java.awt.*;
import java.io.FileNotFoundException;

/**
 * Created by Meder on 23/04/16.
 */
public class Store {



//    private ArrayList<Character> characters;
//    private ArrayList<ExclusiveBoost> boosts;

    /*These are changed according to Nazli's code on Account*/
    private final int DUCK_PRICE = 0;
    private final int BEAVER_PRICE = 300;
    private final int DEER_PRICE = 600 ;
    private final int CROC_PRICE = 1200;
    private final int HIPPO_PRICE = 2400;


    private int[] characterStates;
    private Character[] characters;
    private int[] boosts;
    private Account account;

    //public final int numOfHighscores = 5;
    public final int numOfCharacters = 5;
    public final int numOfBoosts = 5;
    public final int numOfLines = 2;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public Store( Account account ) {
        characterStates = account.getCharStates();
        characters = new Character[numOfCharacters];
        boosts = new int[numOfBoosts];
        this.account = account;

        //DUCK
        boolean duckEquip = false;
        boolean duckUnlock = false;
        if( characterStates[0] == 0  ){
            duckEquip = false;
            duckUnlock = false;
        }
        else if ( characterStates[0] == 1 ){
            duckEquip = false;
            duckUnlock = true;
        }
        else if ( characterStates[0] == 2 ){
            duckEquip = true;
            duckUnlock = true;
        }
        else
            System.out.println( "undefined store-char state: DUCK" );
        duckEquip = true;
        duckUnlock = true;
        characters[0] = new Character( DUCK_PRICE,"Duck","nothing",duckEquip, duckUnlock);

        //BEAVER
        boolean beaverEquip = false;
        boolean beaverUnlock = false;
        if( characterStates[1] == 0  ){
            beaverEquip = false;
            beaverUnlock = false;
        }
        else if ( characterStates[1] == 1 ){
            beaverEquip = false;
            beaverUnlock = true;
        }
        else if ( characterStates[1] == 2 ){
            beaverEquip = true;
            beaverUnlock = true;
        }
        else
            System.out.println( "undefined store-char state: beaver" );
        characters[1] = new Character( BEAVER_PRICE,"Beaver","nothing",beaverEquip, beaverUnlock);

        //DEER
        boolean deerEquip = false;
        boolean deerUnlock = false;
        if( characterStates[2] == 0  ){
            deerEquip = false;
            deerUnlock = false;
        }
        else if ( characterStates[2] == 1 ){
            deerEquip = false;
            deerUnlock = true;
        }
        else if ( characterStates[2] == 2 ){
            deerEquip = true;
            deerUnlock = true;
        }
        else
            System.out.println( "undefined store-char state: deer" );
        characters[2] = new Character( DEER_PRICE,"deer","nothing",deerEquip, deerUnlock);

        //GATOR
        boolean crocEquip = false;
        boolean crocUnlock = false;
        if( characterStates[3] == 0  ){
            crocEquip = false;
            crocUnlock = false;
        }
        else if ( characterStates[3] == 1 ){
            crocEquip = false;
            crocUnlock = true;
        }
        else if ( characterStates[3] == 2 ){
            crocEquip = true;
            crocUnlock = true;
        }
        else
            System.out.println( "undefined store-char state: croc" );
        characters[3] = new Character( CROC_PRICE,"croc","nothing",crocEquip, crocUnlock);

        //HIPPO
        boolean hippoEquip = false;
        boolean hippoUnlock = false;
        if( characterStates[4] == 0  ){
            hippoEquip = false;
            hippoUnlock = false;
        }
        else if ( characterStates[4] == 1 ){
            hippoEquip = false;
            hippoUnlock = true;
        }
        else if ( characterStates[4] == 2 ){
            hippoEquip = true;
            hippoUnlock = true;
        }
        else
            System.out.println( "undefined store-char state: hippo" );
        characters[4] = new Character( HIPPO_PRICE,"hippo","nothing",hippoEquip, hippoUnlock);

        //BOOOOOOOOSSSSTTTSSSSS


    }

    public Store() {

    }

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - END ===============
    //++++++++++++++++++++++++++++++++++++++++++++++++


    //it supposed to be boolean, but no point to make it boolean.
    public void unlock( Character character){
        if( !character.isUnlocked()){
            if( character.getPrice() <= account.getWallet().getCoinAmount()){
                character.setUnlocked(true);
                account.getWallet().spendCoin(character.getPrice());
            }
        }
    }

    public void equip(Character character){
        if( character.isUnlocked()){
            for ( int i = 0; i < numOfCharacters; i++ ){
                characters[i].setEquipped(false);
            }
            character.setEquipped(true);
        }
    }

    public Character[] getCharacters(){
        return characters;
    }
    public void setCharacters(int [] characters){
        this.characterStates = characters;
    }

    public void setBoosts( int[] boosts){
        this.boosts = boosts;
    }

    //============ !! NEEDS IMPLEMENTATION !! ============

    //in these two methods I need to access to account, but I am not sure how to access,
    // because we don't have them as an object.

    public boolean buy(ExclusiveBoost exclusiveBoost){
        return true;}

    public boolean dumBuy(){
        return true;
    }

    public boolean upgrade(ExclusiveBoost exclusiveBoost){
        return exclusiveBoost.upgrade();
    }

    public void draw (Graphics g){}

    public void save() throws FileNotFoundException {
        for( int i = 0; i < numOfCharacters; i++){
            if( characters[i].isUnlocked() ){
                if(characters[i].isEquipped())
                    account.equip(i);
                else
                    account.purchaseChar(i);
            }
            else{
                if(characters[i].isEquipped())
                    account.equip(i);
                else
                    account.purchaseChar(i);
            }
        }
        //TODO
        //account.save();
    }

}
