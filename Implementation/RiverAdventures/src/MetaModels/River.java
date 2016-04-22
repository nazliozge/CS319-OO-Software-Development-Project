package MetaModels;

import RealModels.Collectible;

import javax.jws.soap.SOAPBinding;
import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 */
public class River {
    private UserCharacter character;
    private double speedMode;
    private Line lines[];
    private Collectible totalCoins;

    public River(UserCharacter character, double speedMode, Line[] lines, Collectible totalCoins) {
        this.character = character;
        this.speedMode = speedMode;
        this.lines = lines;
        this.totalCoins = totalCoins;
    }

    public void work(){}

    public void move(String direction){}

    public void generateLine(){}

    public void update(){}

    public void endMe(){}

    public void gainCoin(Collectible c){}

    public boolean checkCollision(){return true;}

    public void dropLine(){}

    public void draw(Graphics g){}



    public UserCharacter getCharacter() {
        return character;
    }

    public void setCharacter(UserCharacter character) {
        this.character = character;
    }

    public double getSpeedMode() {
        return speedMode;
    }

    public void setSpeedMode(double speedMode) {
        this.speedMode = speedMode;
    }

    public Line[] getLines() {
        return lines;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    public Collectible getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(Collectible totalCoins) {
        this.totalCoins = totalCoins;
    }
}
