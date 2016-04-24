package Models.Account;

import java.io.*;
import java.util.*;
/**
 * Created by Meder on 23/04/16.
 * Updated by nazli on 24/04/16.
 */

public class Account {

    //unchangeable number of objects
    private final int numOfHighscores = 5;
    private final int numOfCharacters = 5;
    private final int numOfBoosts = 5;
    private final int numOfLines = 3;

    //attributes

    /* Each value in the list denotes a character/boost.
     *
     * For charStates; index 0 is the state of the Duck, index 1 is the state of the Beaver,
     *  			index 2 is the state of the Deer, index 3 is the state of the Crocodile and index 4 is the state of the Hippopotamus
     * Character states are: 0->unlock, 1->equip, 2->equipped
     *
     * For boostStates; index 0 is the state of Shield, index 1 is the state of Minimisation, index 2 is the state of Deceleration,
     * 				 index 3 is the state of Invincibility, index 4 is the state of Health Pack,
     * Boost states are: 0->unlock, 1->level1, 2->level2, 3->level3
     */
    private int[] charState;
    private int[] boostStates;
    private CoinWallet wallet;
    private int[] highScores;
    private String saveFile;
    /*Text file contains information regarding high scores, character states and boost states.
     *First line is high scores, second line is character states and the third line is boost states.
     *In each line there are integers, split by " " (blank space).
     *Therefore reading and writing to the text file will be done based on this information
    **/

    //constructor
    public Account(){
        charState = new int[numOfCharacters];
        boostStates = new int[numOfBoosts];
        saveFile = "accountInfo.txt";   //Put text file in the same directory!
        wallet = new CoinWallet();
        highScores = new int[numOfHighscores];
    }


    //methods

    /*Reads each line in the text file and store them in the String array list.
    * Then, from that array list, fills all the regarding arrays
    */
    public void save() throws FileNotFoundException
    {
        int count = 0;

        String[] lines = new String[numOfLines];
        Scanner in = new Scanner(new File(saveFile));
        while(in.hasNextLine()){
            lines[count++] = in.nextLine();
        }

        String[] highscr = lines[0].split(" ");
        String[] characterst = lines[1].split(" ");
        String[] boostst = lines[2].split(" ");

        //fills the arrays of persistent data
        for(int i=0; i<numOfHighscores;i++)
        {
            highScores[i] = Integer.parseInt(highscr[i].trim());
            charState[i] = Integer.parseInt(characterst[i].trim());
            boostStates[i] = Integer.parseInt(boostst[i].trim());
        }

        in.close();
    }

    public void load() throws FileNotFoundException
    {
        //str stores the lines of file that are to be written to saveFile.
        String[] str = new String[numOfLines];

        //fills out str
        for(int i=0; i<numOfHighscores;i++)
        {
            //converts the int of the element of the array list into string, puts " " after it and store it in the first index of str
            str[0] = "" + highScores[i] + " ";
        }

        for(int i=0; i<numOfCharacters;i++)
        {
            //converts the int of the element of the array list into string, puts " " after it and store it in the second index of str
            str[1] = "" + charState[i] + " ";
        }
        for(int i=0; i<numOfBoosts;i++)
        {
            //converts the int of the element of the array list into string, puts " " after it and store it in the third index of str
            str[2] = "" + boostStates[i] + " ";
        }

        //open file to write
        PrintWriter out = new PrintWriter(saveFile);
        for(int i = 0; i < numOfLines; i++){
            out.println(str[i]);
        }
        out.close();
    }


    public void updateWallet(int amount)
    {
        if(amount>0)
            wallet.addCoin(amount);
        else if(amount<0)
            wallet.spendCoin(amount);
    }



    public boolean equip(int index)	//checking the amount of coin is not done!
    {
        //if it is already purchased
        if(charState[index] == 1)
        {
            //it is now equipped
            charState[index] = 2;
            return true;
        }

        return false;
    }

    public boolean purchaseChar(int index)
    {
        //if it is unlock
        if(charState[index] == 0)
        {
            //purchase it. Its state becomes 1.
            charState[index] = 1;
            return true;
        }
        return false;

    }

    //NEW!-- when this method first invoked for a boost, it is purchased. For other times, it updates its level.
    public boolean purchaseBoost(int index)
    {
        //if it is unlock
        if(boostStates[index] == 0)
        {
            //purchase it. Its state becomes 1.
            boostStates[index] = 1;
            return true;
        }
        //if it is level-1
        else if(boostStates[index] == 1)
        {
            //makes its state level-2
            boostStates[index] = 2;
            return true;
        }
        //if it is level-2
        else if(boostStates[index] == 2)
        {
            //makes its state level-3
            boostStates[index] = 3;
            return true;
        }
        //else is only valid if it's level-3. So, no upgrade available.
        return false;

    }


}