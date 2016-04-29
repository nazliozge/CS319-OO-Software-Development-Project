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
    public GameManager( FrameManager frameManager, SettingsManager settingsManager ){
        this.frameManager = frameManager;
        this.settingsManager = settingsManager;
        gameState = state.MENU;
        account = new Account();
        time = 0;
        highscores = account.getHighScores();
        //TODO
    }
    //test:
    public GameManager(){

    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++     METHODS     +++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public boolean initializeGame(){
        /*It creates a new RiverGame object, connects the riverGame attribute to it,
        calls the riverGame object’s related methods and calls the FrameManager’s toGame() method.*/
        riverGame = new RiverGame();
        //TODO: set frame manager
        startGameLoop();
        return true;}

    public boolean startGameLoop(){
        /* It starts the timer. */
        gameState = state.GAME;
        riverGame.goOn();
        return true;}

    public boolean pauseGame(){
        /* Stops the timer and updates the UI by calling the FrameManager’s toPause() method */
        riverGame.pause();
        //TODO: set frame manager
        gameState = state.PAUSE;
        return true;}

    public boolean unpauseGame(){
        /* Restarts the timer and updates the UI */
        riverGame.goOn();
        //TODO: set frame manager
        gameState = state.GAME;
        return true;}

    public boolean endGame(){
        /* Stops the timer and updates the UI */
        double score = riverGame.getScore();
        account.addHighScore( (int)score );
        gameState = state.END_GAME;
        //...
        toHighscores();
        return true;}

    public boolean updateAccount(){
        /* Updates UI by calling the FrameManager’s toStore() method. */
        return true;}

    public boolean accessToStore(){
        /* Updates UI by calling the FrameManager’s toStore() method. */
        gameState = state.STORE;
        return true;}

    public boolean toHighscores(){
        /* Starts the process of screening scores at the end of the game. */
        //TODO: set frame manager
        return true;}

    public boolean toMenu(){
        /* Updates UI by calling the FrameManager’s toMain() method. */
        gameState = state.MENU;
        //TODO: set frame manager
        return true;}

    public boolean toHelp(){
        /* Updates UI by calling the FrameManager’s toHelp() method */
        gameState = state.HELP;
        //TODO: set frame manager
        return true;}

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
