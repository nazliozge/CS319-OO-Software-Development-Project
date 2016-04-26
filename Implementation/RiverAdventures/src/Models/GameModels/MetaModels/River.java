package Models.GameModels.MetaModels;

import Models.GameModels.RealModels.Collectible;
import Models.GameModels.UserCharacter;
import Models.GameModels.RealModels.RiverObject;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Meder on 23/04/16.
 */
public class

River {

    private UserCharacter character;
    private double speedMode;
    private ArrayList<Line> lines;
    private Collectible totalCoins;

    // THESE VARIABLES' MAGNITUDES SHOULD CHANGE, THEY ARE RANDOMLY SET
    final static int UserCharacter_YLoc = 24;
    final static int UserCharacter_MOVE = 4;
    final static int DISTANCE_BETWEEN_LINES = 4;
    final static int MAX_LINE_NUMBER_ON_SCREEN = 15;


    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public River(){
        character = new UserCharacter();
        speedMode = 2; //just a random number
        lines = new ArrayList<Line>();
        totalCoins = new Collectible();
    }
    public River(UserCharacter character, double speedMode, Collectible totalCoins) {
        this.character = character;
        this.speedMode = speedMode;
        this.totalCoins = totalCoins;
        lines = new ArrayList<Line>();
    }
    public River(UserCharacter character, double speedMode) {
        this.character = character;
        this.speedMode = speedMode;
        this.totalCoins = new Collectible();
        lines = new ArrayList<Line>();
    }


    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - END ===============
    //++++++++++++++++++++++++++++++++++++++++++++++++


    //++++++++++++++++++++++++++++++++++++++++++++++++
    //================ METHODS =======================
    //++++++++++++++++++++++++++++++++++++++++++++++++


    public void move(String direction){
        if(direction == "LEFT"){
            character.setPosition(character.getPosition() - UserCharacter_MOVE);
        }
        if(direction == "RIGHT"){
            character.setPosition(character.getPosition() + UserCharacter_MOVE);
        }
    }


    public void update(){

        for(Line line: lines){
            line.move();
        }
        /*This means the user character alreade passes this line, and should be removed*/
        if(lines.get(0).getyLoc() > UserCharacter_YLoc){
            dropLine();
            generateLine();
        }
    }

    public UserCharacter getUserCharacter(){
        return this.character;
    }

    public boolean checkCollision(){
        Line line = lines.get(0);

        /* check if they are at the same y-location */
        if(line.getyLoc() == UserCharacter_YLoc){

            /*if they are at the same y-location,
            * then check for every object in the line if they collide
            * with the user character*/
            for(RiverObject object: line.getRiverObjects()){

                /*if the object's (xLox + xSize) is greater than the character's
                * position, this means they overlap each other. This checks from both side of the
                * obstacle*/

                if(object.getxLoc() + object.getxSize() > character.getPosition() && character.getPosition() > object.getxLoc()){
                    character.executeEffect(object);
                    return true;
                }

            }
        }
        return false;

    }

    public void dropLine(){
        lines.remove(0);//because it is the oldest one among the lines
    }

    public Line getLine(int index){
        return lines.get(index);
    }


    public void generateLine(){
        Line newLine = new Line();

        if(!lines.isEmpty()){
            double loc = lines.get(lines.size()- 1).getyLoc(); //y-location of the last line on the lines array
            newLine.setyLoc(loc - DISTANCE_BETWEEN_LINES);
        }else{
            newLine.setyLoc(-5); // this number is a just random number, it is gonna change.
            //Negative number because it should not be shown on the screen when created.
        }
        newLine.fillLine(character.getSize());
    }

    public void setSpeedMode (double speedMode){
        this.speedMode = speedMode;
    }

    //============ !! NEEDS IMPLEMENTATION !! ============
    public void draw(Graphics g){}
    public void gainCoin(Collectible c){}
    public void endMe(){}




}
