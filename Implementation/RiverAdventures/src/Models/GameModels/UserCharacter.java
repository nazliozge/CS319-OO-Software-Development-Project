package Models.GameModels;

import Models.GameModels.Buyable.*;
import Models.GameModels.Buyable.Character;
import Models.GameModels.RealModels.Collectible.Collectible;
import Models.GameModels.RealModels.Obstacle.Obstacle;
import Models.GameModels.RealModels.RiverObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

/**
 * Created by Meder on 23/04/16.
 */
public class UserCharacter {
    private int health;
    private int ySize;//these are added, while drawing the characters, we need the both x and y locations
    private int xSize;
    private int activeEffects[][];
    private int shieldLimit;
    private Character character;
    private int xPosition;
    private Timer timerMinimisation;
    private Timer timerInvincibility;
    private int invincibilityCheck;

    private final static int yPosition = 400;
    private final static int DEFAULT_CHARACTER_YSIZE = 80;
    private final static int DEFAULT_CHARACTER_XSIZE = 80;
    private final static int DEFAULT_CHARACTER_XPOSITION = 50;
    private final static int DEFAULT_CHARACTER_SMALL_YSIZE = 50;
    private final static int DEFAULT_CHARACTER_SMALL_XSIZE = 50;

    //CONSTRUCTOR

    public UserCharacter(){
        this.health = 100;
        this.ySize = DEFAULT_CHARACTER_YSIZE;
        this.xSize = DEFAULT_CHARACTER_XSIZE;
        this.xPosition = DEFAULT_CHARACTER_XPOSITION;
        this.activeEffects = new int[0][0];
        this.character = new Character();
        character.setName("duck");
        shieldLimit = 0;
        invincibilityCheck = 0;
    }

    public UserCharacter(int health, int xSize, int ySize, int[][] activeEffects, Character character, int xPosition) {
        this.health = health;
        this.ySize = ySize;
        this.xSize = xSize;
        this.activeEffects = activeEffects;
        this.character = character;
        this.xPosition = xPosition;
    }

    public boolean hasShield(){

        return true;
    }

    private void isDead(){

    }

    public void receiveDamage(int reduce){
        this.health -= reduce;
    }

    public void executeEffect(RiverObject object){
        System.out.println("executeEffect, before " + getHealth());
        if (object instanceof Shield){
            if (shieldLimit == -1){
                invincibilityCheck += ((Shield) object).getLimit();
            }else{
                shieldLimit += ((Shield) object).getLimit();
            }
        }
        else if (object instanceof Obstacle){
            if( shieldLimit > 0){
                shieldLimit--;
            }
            else if (shieldLimit == -1){

            }

            else {
                receiveDamage(((Obstacle) object).getHealthDecAmount());
            }
        }
        else if (object instanceof MinimisationPower){
            setxSize(DEFAULT_CHARACTER_SMALL_XSIZE);
            setySize(DEFAULT_CHARACTER_SMALL_YSIZE);
            timerMinimisation = new Timer(((MinimisationPower) object).getDuration() * 2000, new MyActionListenerMinimisation());
            timerMinimisation.start();
        }
        else if (object instanceof Deceleration){

        }
        else if (object instanceof Invincibility){
            invincibilityCheck = shieldLimit;
            shieldLimit = -1;

            timerInvincibility = new Timer(((Invincibility) object).getDuration() * 2000, new MyActionListenerInvincibility());
            timerInvincibility.start();
        }
        else if (object instanceof HealthPack){
            health += ((HealthPack) object).getHealthIncAmount();
        }

        System.out.println("executeEffect, after " + getHealth());
    }

    public void draw(Graphics g){
        character.draw(g, xPosition, yPosition, xSize, ySize);
    }


    //ACCESSORS AND MUTATORS

    public int getHealth() {
        return health;
    }

    public int getShieldLimit(){
        return shieldLimit;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int[][] getActiveEffects() {
        return activeEffects;
    }

    public void setActiveEffects(int[][] activeEffects) {
        this.activeEffects = activeEffects;
    }


    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition(){
        return yPosition;
    }

    private class MyActionListenerMinimisation implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event)
        {
            setySize(DEFAULT_CHARACTER_YSIZE);
            setxSize(DEFAULT_CHARACTER_XSIZE);
        }

    }

    private class MyActionListenerInvincibility implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event)
        {
            shieldLimit = invincibilityCheck;
        }

    }
}
