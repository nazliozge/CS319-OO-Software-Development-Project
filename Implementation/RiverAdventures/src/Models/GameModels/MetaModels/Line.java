package Models.GameModels.MetaModels;

import Models.GameModels.Buyable.*;
import Models.GameModels.Drawable;
import Models.GameModels.RealModels.Collectible.Coin;
import Models.GameModels.RealModels.Collectible.CoinBag;
import Models.GameModels.RealModels.Obstacle.ChemicalHazard;
import Models.GameModels.RealModels.Obstacle.Log;
import Models.GameModels.RealModels.Obstacle.NuclearBomb;
import Models.GameModels.RealModels.Obstacle.Stone;
import Models.GameModels.RealModels.RiverObject;
import Models.GameModels.RealModels.Trap.Accelerate;
import Models.GameModels.RealModels.Trap.Maximise;
import Models.GameModels.RealModels.Trap.Trap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;
/**
 * Created by Meder on 23/04/16.
 */



public class Line implements Drawable {

    //THESE VARIABLES' MAGNITUDES SHOULD CHANGE LATER.z
    final static int MOVE_BY = 1;
    final static int LINE_WIDTH = 200;

    private int yLoc;
    private ArrayList<RiverObject> objects;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public Line(int yLoc) {
        this.yLoc = yLoc;
        objects = new ArrayList<RiverObject>();
    }

    public Line(){
        this.yLoc = 10;
        objects = new ArrayList<RiverObject>();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - END ===============
    //++++++++++++++++++++++++++++++++++++++++++++++++


    //++++++++++++++++++++++++++++++++++++++++++++++++
    //=================== METHODS ====================
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public int getyLoc(){
        return yLoc;
    }

    public void setyLoc(int newLoc){
        this.yLoc = newLoc;
    }

    public void removeObject(int index){
        objects.remove(index);
    }
    public void removeObject(RiverObject object){
        objects.remove(object);
    }

    public void addObject(RiverObject object){
        objects.add(object);
    }


    /* EVERYTIME WHEN IT IS CALLED, IT UPDATES THE POSITION OF THE LINE*/
    public void move(){

        for(int i = 0; i < objects.size(); i ++){
            objects.get(i).setyLoc(yLoc + MOVE_BY);
        }

        yLoc += MOVE_BY;
    }

    public ArrayList<RiverObject> getRiverObjects(){
        return objects;
    }

    //=============== !! NEW METHOD(s) !! ================

    /* IT JUST FILLS THE LINE WITH PROPER RIVER OBJECTS
    *  ACCORDING TO THE SIZE OF THE USER CHARACTER AND LINE*/

    public void fillLine(double userCharacterWidth){

        //THE CODE UNDER THE COMMENT IS MORE ADVANCED WAY OF ADDING OBJECTS TO THE LINE
        //BUT FOR THE SAKE OF SIMPLICITY, I AM ADDING ONLY ONE OBSTACLE TO THE LINE.
        //========================================================================
        /*int start = 0;
        int end = LINE_WIDTH;
        do{
            int range = (end - start) + 1;
            int location = (int)Math.random() * range + start;
            RiverObject object = new RiverObject();
            object.setxLoc(location);
            objects.add(object);

            //Objective of setting these to 'start' is to make sure to have enough space
            * between obstacles for user character to pass through.

            start = location + object.getxSize() + (int)userCharacterWidth;

        }while(end - start > userCharacterWidth);
    */
        //========================================================================

        int start = 0;
        int end = LINE_WIDTH;
        int range = (end - start) + 1;
        int Xlocation = (int)(Math.random() * range) + start;

        int random = (int)(Math.random() * 12) + 1;

        //all exclusive boosts
        ExclusiveBoost shield = new Shield();
        ExclusiveBoost mini = new MinimisationPower();
        ExclusiveBoost deceleration = new Deceleration();
        ExclusiveBoost invic = new Invincibility();
        ExclusiveBoost healthp = new HealthPack();



        if(random == 0){
            ChemicalHazard chemical = new ChemicalHazard();
            chemical.setxLoc(Xlocation);
            chemical.setyLoc(yLoc);
            objects.add(chemical);
        }
        if(random == 1){
            Log log = new Log();
            log.setxLoc(Xlocation);
            log.setyLoc(yLoc);
            objects.add(log);
        }
        if (random == 2){
            Stone stone = new Stone();
            stone.setxLoc(Xlocation);
            stone.setyLoc(yLoc);
            objects.add(stone);
        }
        if (random == 3){
            NuclearBomb nuclearBomb = new NuclearBomb();
            nuclearBomb.setxLoc(Xlocation);
            nuclearBomb.setyLoc(yLoc);
            objects.add(nuclearBomb);
        }
        if (random == 4){
            Coin coin = new Coin();
            coin.setxLoc(Xlocation);
            coin.setyLoc(yLoc);
            objects.add(coin);
        }
        if (random == 5){
            CoinBag coinbag = new CoinBag();
            coinbag.setxLoc(Xlocation);
            coinbag.setyLoc(yLoc);
            objects.add(coinbag);
        }
        if (random == 6 ){
            if(shield.isUnlocked())
            {
                shield.setyLoc(Xlocation);
                shield.setyLoc(yLoc);
                objects.add(shield);
            }
            else
            {
                this.fillLine(userCharacterWidth);
            }
        }

        if(random == 7)
        {
            if(mini.isUnlocked())
            {
                mini.setyLoc(Xlocation);
                mini.setyLoc(yLoc);
                objects.add(mini);
            }
            else
            {
                this.fillLine(userCharacterWidth);
            }
        }
        if(random == 8)
        {
            if(deceleration.isUnlocked())
            {
                deceleration.setyLoc(Xlocation);
                deceleration.setyLoc(yLoc);
                objects.add(deceleration);
            }
            else
            {
                this.fillLine(userCharacterWidth);
            }

        }
        if(random == 9)
        {
            if(invic.isUnlocked())
            {
                invic.setyLoc(Xlocation);
                invic.setyLoc(yLoc);
                objects.add(invic);
            }
            else
            {
                this.fillLine(userCharacterWidth);
            }

        }
        if(random == 10)
        {
            if(healthp.isUnlocked())
            {
                healthp.setyLoc(Xlocation);
                healthp.setyLoc(yLoc);
                objects.add(healthp);
            }
            else
            {
                this.fillLine(userCharacterWidth);
            }

        }
        if(random == 11)
        {
            Trap max = new Maximise();
            max.setyLoc(Xlocation);
            max.setyLoc(yLoc);
            objects.add(max);
        }
        if(random == 12)
        {
            Trap acc = new Accelerate();
            acc.setyLoc(Xlocation);
            acc.setyLoc(yLoc);
            objects.add(acc);
        }
        /*
        This continues...
        * */



    }

    //=============== !! NEW METHOD(s) !! ================


    //============ !! NEEDS IMPLEMENTATION !! ============
    public void draw(Graphics g){

        for(int i = 0; i < objects.size(); i ++){
            objects.get(i).draw(g);
        }

    }
}
