package Models.GameModels.MetaModels;

import UserInterface.RiverFrame;

import javax.swing.*;

/**
 * Created by Meder on 26/04/16.
 */
public class Main_Test {

    private static JFrame frame;

    public static void main( String[] args){

        frame = new JFrame("Line");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        RiverFrame test = new RiverFrame();

        frame.getContentPane().add(test);
        frame.pack();
        frame.setVisible(true);
    }
}

