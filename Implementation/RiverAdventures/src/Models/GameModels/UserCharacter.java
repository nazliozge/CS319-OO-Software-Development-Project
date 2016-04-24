package Models.GameModels;

import Models.GameModels.Buyable.Character;
import Models.GameModels.RealModels.RiverObject;

import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class UserCharacter {
    private double health;
    private double size;
    private double activeEffects[][];
    private int shield;
    private Character character;
    private double position;

    //CONSTRUCTOR

    public UserCharacter(double health, double size, double[][] activeEffects, int shield, Character character, double position) {
        this.health = health;
        this.size = size;
        this.activeEffects = activeEffects;
        this.shield = shield;
        this.character = character;
        this.position = position;
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

    }


    //ACCESSORS AND MUTATORS

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double[][] getActiveEffects() {
        return activeEffects;
    }

    public void setActiveEffects(double[][] activeEffects) {
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

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }
}
