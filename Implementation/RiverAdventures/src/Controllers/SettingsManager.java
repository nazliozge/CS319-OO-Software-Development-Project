package Controllers;

import Models.Account.Account;
import Models.GameModels.MetaModels.RiverGame;

import java.util.ArrayList;

/**
 * Created by Magus on 23.04.2016.
 */
public class SettingsManager {

    private GameManager ctrl;
    private boolean isMute;
    private String musicFileLoc;
    private double soundLevel;

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++     CONSTRUCTORS    +++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public SettingsManager( String file) {
        musicFileLoc = file;
        load();
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++     METHODS     +++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void load(){
        /*Loads persistent data and updates the isMute and soundLevel attribute.*/
    }

    public void save(){
        /*Saves the current data to persistent data.*/
    }

    public void changeMute(){
        /*Change isMute to the opposite state.*/
    }
    public void adjustSound(boolean up){
        /*It takes a boolean parameter to check if the sound increases or decreases (true for increase, false for decrease) and updates the soundLevel attribute.*/
    }

}
