package Models.GameModels.MetaModels;

import Models.GameModels.RealModels.Collectible.Collectible;
import Models.GameModels.UserCharacter;
import Models.GameModels.RealModels.RiverObject;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Meder on 23/04/16.
 */
public class River {

    private UserCharacter character;
    private double speedMode;
    private ArrayList<Line> lines;
    private Collectible totalCoins;

    // THESE VARIABLES' MAGNITUDES SHOULD CHANGE, THEY ARE RANDOMLY SET
    private final static int UserCharacter_MOVE = 5;
    private final static int DISTANCE_BETWEEN_LINES = 150;
    private final static int MAX_LINE_NUMBER_ON_SCREEN = 15;
    private final static int SCREEN_HEIGHT = 500;
    private final static int DEFAULT_LINE_STARTING_YPOSITION = -10;

    //++++++++++++++++++++++++++++++++++++++++++++++++
    //============== CONSTRUCTOR - START =============
    //++++++++++++++++++++++++++++++++++++++++++++++++

    public River(){
        character = new UserCharacter();
        speedMode = 5; //just a random number
        lines = new ArrayList<Line>();

//        Line line = new Line();
//        line.fillLine(15);
//        lines.add(line);

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
            character.setxPosition(character.getxPosition() - UserCharacter_MOVE);
        }
        if(direction == "RIGHT"){
            character.setxPosition(character.getxPosition() + UserCharacter_MOVE);
        }
    }


    public void update(){



        for(Line line: lines){
            line.move();
        }

        if(lines.size() < MAX_LINE_NUMBER_ON_SCREEN)
            generateLine();

        /*This means the user character alreade passes this line, and should be removed*/
        if(lines.get(0).getyLoc() > SCREEN_HEIGHT){
            dropLine();
            generateLine();
        }
        checkCollision();
    }

    public UserCharacter getUserCharacter(){
        return this.character;
    }

    public boolean checkCollision(){

        Rectangle userCharacter = new Rectangle(character.getxPosition(), character.getyPosition(), character.getxSize(), character.getyPosition());

            Line line = lines.get(0);

            for (RiverObject riverObject: line.getRiverObjects()){
                Rectangle object = new Rectangle(riverObject.getxLoc(), riverObject.getyLoc(), riverObject.getxSize(), riverObject.getySize());

                if(userCharacter.intersects(object)){
                    //collision
                    return true;
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
            int loc = lines.get(lines.size()- 1).getyLoc(); //y-location of the last line on the lines array
            newLine.setyLoc(loc - DISTANCE_BETWEEN_LINES);
        }else{
            newLine.setyLoc(DEFAULT_LINE_STARTING_YPOSITION); // this number is a just random number, it is gonna change.
            //Negative number because it should not be shown on the screen when created.
        }
        newLine.fillLine(character.getxSize());
        lines.add(newLine);
    }

    public void setSpeedMode (double speedMode){
        this.speedMode = speedMode;
    }

    public void draw(Graphics g){
        character.draw(g);

        for(Line line: lines)
            line.draw(g);
    }

    //============ !! NEEDS IMPLEMENTATION !! ============
    public void gainCoin(Collectible c){}
    public void endMe(){}




}
