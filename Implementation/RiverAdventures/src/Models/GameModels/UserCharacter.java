package Models.GameModels;

import Models.GameModels.Buyable.Character;
import Models.GameModels.RealModels.RiverObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class UserCharacter {
    private double health;
    private int ySize;//these are added, while drawing the characters, we need the both x and y locations
    private int xSize;
    private int activeEffects[][];
    private int shield;
    private Character character;
    private int xPosition;


    private final static int yPosition = 400;
    private final static int DEFAULT_CHARACTER_YSIZE = 60;
    private final static int DEFAULT_CHARACTER_XSIZE = 80;
    private final static int DEFAULT_CHARACTER_SHIELD = 10;
    private final static int DEFAULT_CHARACTER_XPOSITION = 50;

    //CONSTRUCTOR

    public UserCharacter(){
        this.health = 100;
        this.ySize = DEFAULT_CHARACTER_YSIZE;
        this.xSize = DEFAULT_CHARACTER_XSIZE;
        this.shield = DEFAULT_CHARACTER_SHIELD;
        this.xPosition = DEFAULT_CHARACTER_XPOSITION;
        this.activeEffects = new int[0][0];
        this.character = new Character();
        character.setName("duck");
    }

    public UserCharacter(double health, int xSize, int ySize, int[][] activeEffects, int shield, Character character, int xPosition) {
        this.health = health;
        this.ySize = ySize;
        this.xSize = xSize;
        this.activeEffects = activeEffects;
        this.shield = shield;
        this.character = character;
        this.xPosition = xPosition;
    }

    public boolean hasShield(){
        return true;
    }

    private void isDead(){

    }

    public void receiveDamage(int reduce){

    }

    public void executeEffect(RiverObject object){

    }

    public void draw(Graphics g){
        character.draw(g, xPosition, yPosition, xSize, ySize);
    }


    //ACCESSORS AND MUTATORS

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
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

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
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
}
