package Models.GameModels.Buyable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Meder on 23/04/16.
 * Updated by Nazli on 24/04/16.
 */

public class Character implements Buyable {
    private int price;
    private String name;
    private String specialty;
    private boolean isEquipped;
    private boolean isUnlocked;

    //CONSTRUCTORS
    public Character(){
        price = 0;
        name = "";
        specialty = "";
        isEquipped = false;
        isUnlocked = false;
    }

    public Character(int price, String name, String specialty, boolean isEquipped, boolean isUnlocked){
        this.price = price;
        this.name = name;
        this.specialty = specialty;
        this.isEquipped = isEquipped;
        this.isUnlocked = isUnlocked;
    }


    //PUBLIC METHODS
    /*This method parameters are changed, because in order to draw a character, the locations are needed where to draw them.
    * so, the UserCharacter draw method passes these parameters as this method does not have x and y locations of the character.*/
    public void draw(Graphics g, int xLoc, int yLoc, int xSize, int ySize){
        Image img = new ImageIcon("image/userCharacter/" + getName() + ".png").getImage();
        g.drawImage(img, xLoc, yLoc, xSize, ySize, null);
    }



    /*
    MUTATORS AND ACCESSORS
     */
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }
}
