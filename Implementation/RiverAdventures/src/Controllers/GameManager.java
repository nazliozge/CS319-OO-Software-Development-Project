package Controllers;

import Models.Account.Account;
import Models.GameModels.MetaModels.RiverGame;
import UserInterface.FrameManager;

import java.util.ArrayList;

/**
 * Created by Magus on 23.04.2016.
 *
 */
public class GameManager {

    private SettingsManager settingsManager;
    private FrameManager frameManager;
    private RiverGame riverGame;
    private int gameState;
    private Account account;
    private double time;
    private ArrayList< Integer > highscores;

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++     CONSTRUCTORS    +++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public GameManager( FrameManager frameManager, SettingsManager settingsManager ){
        this.frameManager = frameManager;
        this.settingsManager = settingsManager;
        //TODO
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++     METHODS     +++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public boolean initializeGame(){
        /*It creates a new RiverGame object, connects the riverGame attribute to it,
        calls the riverGame object’s related methods and calls the FrameManager’s toGame() method.*/
        return true;}

    public boolean startGameLoop(){
        /* It starts the timer. */
        return true;}

    public boolean pauseGame(){
        /* Stops the timer and updates the UI by calling the FrameManager’s toPause() method */
        return true;}

    public boolean unpauseGame(){
        /* Restarts the timer and updates the UI */
        return true;}

    public boolean endGame(){
        /* Stops the timer and updates the UI */
        return true;}

    public boolean updateAccount(){
        /* Updates UI by calling the FrameManager’s toStore() method. */
        return true;}

    public boolean accessToStore(){
        /* Updates UI by calling the FrameManager’s toStore() method. */
        return true;}

    public boolean toHighscores(){
        /* Starts the process of screening scores at the end of the game. */
        return true;}

    public boolean toMenu(){
        /* Updates UI by calling the FrameManager’s toMain() method. */
        return true;}

    public boolean toHelp(){
        /* Updates UI by calling the FrameManager’s toHelp() method */
        return true;}

    public boolean toSettings(){
        /* Updates the UI by calling the FrameManager’s toSettings(settingsManager: Object) method */
        return true;}

    public void move( String direction){
        /*  Parameter direction could be either “left” or “right”. Calls move method of the RiverGame object. */
        }

}
