package Controllers;

import Models.Account.Account;
import Models.GameModels.MetaModels.RiverGame;
import UserInterface.FrameManager;

import java.util.ArrayList;

import static Controllers.GameManager.state;


/**
 * Created by Magus on 23.04.2016.
 *
 */
public class GameManager {

    // INIT, MENU, SETTINGS_M, SETTINGS_P, PAUSE, END_GAME, STORE, GAME, HELP

    public enum state { INIT, MENU, SETTINGS_M, SETTINGS_P, PAUSE, END_GAME, STORE, GAME, HELP };

    private SettingsManager settingsManager;
    private FrameManager frameManager;
    private RiverGame riverGame;
    private state gameState; // change in docs
    private Account account;
    private double time;
    private int[] highscores; // change in docs

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++     CONSTRUCTORS    +++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public GameManager(){
        settingsManager = new SettingsManager("sadas");
        gameState = state.MENU;
        System.out.println( "game satte : " + gameState);
        account = new Account();
        time = 0;
        highscores = account.getHighScores();
        //TODO
    }

    //test:

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++     METHODS     +++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void addFrameManager(FrameManager fm){
        this.frameManager = fm;
    }

    public boolean initializeGame(){
        /*It creates a new RiverGame object, connects the riverGame attribute to it,
        calls the riverGame object’s related methods and calls the FrameManager’s toGame() method.*/
        System.out.println( gameState);
        if( gameState == state.MENU){
            riverGame = new RiverGame();
            //TODO: set frame manager = RESOLVED?
            frameManager.toGame(riverGame);
            startGameLoop();
            gameState = state.GAME;
            return true;
        }
        return false;
    }

    public boolean startGameLoop(){
        /* It starts the timer. */
        riverGame.goOn();
        return true;
    }

    public boolean pauseGame(){
        /* Stops the timer and updates the UI by calling the FrameManager’s toPause() method */
        if( gameState == state.GAME){
            riverGame.pause();
            //TODO: set frame manager= RESOLVED?
            frameManager.toPause();
            gameState = state.PAUSE;
            return true;
        }
        return false;
    }

    public boolean unpauseGame(){
        /* Restarts the timer and updates the UI */
        if( gameState == state.PAUSE){
            riverGame.goOn();
            //TODO: set frame manager= RESOLVED?
            frameManager.toGame( riverGame );
            gameState = state.GAME;
            return true;
        }
        return false;
    }

    public boolean endGame(){
        /* Stops the timer and updates the UI */
        double score = riverGame.getScore();
        account.addHighScore( (int)score );
        riverGame.pause();
        gameState = state.END_GAME;
        //...
        toHighscores( (int) score );
        return true;}

    //TODO: is it needed?
    public boolean updateAccount(){
        /* Updates UI by calling the FrameManager’s toStore() method. */
        return true;}

    //TODO
    public boolean accessToStore(){
        /* Updates UI by calling the FrameManager’s toStore() method. */
        // gameState = state.STORE;
        return true;
    }

    public boolean toHighscores( int a){
        /* Starts the process of screening scores at the end of the game. */
        //TODO: set frame manager
        frameManager.toHighscores( a );
        return true;
    }

    public boolean toMenu(){
        if( gameState == state.PAUSE){
            endGame();
            return true;
        }
        else if( gameState == state.SETTINGS_M){
            //TODO
            return true;
        }
        else if( gameState == state.HELP){
            gameState = state.MENU;
            frameManager.requestMain();
        }
        //TODO: for each change
        return false;
    }

    public boolean toHelp(){
        /* Updates UI by calling the FrameManager’s toHelp() method */
        if( gameState == state.MENU){
            //TODO: set frame manager= RESOLVED?
            gameState = state.HELP;
            return true;
        }
        return false;
    }

    //TODO:
    public boolean toSettings(){
        /* Updates the UI by calling the FrameManager’s toSettings(settingsManager: Object) method */
        if( gameState == state.PAUSE)
            gameState = state.SETTINGS_P;
        else
            gameState = state.SETTINGS_M;
        //TODO: set frame manager
        return true;}

    public void move( String direction){
        /*  Parameter direction could be either “left” or “right”. Calls move method of the RiverGame object. */
        riverGame.move(direction);
    }

}
