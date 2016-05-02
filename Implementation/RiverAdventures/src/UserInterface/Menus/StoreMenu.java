package UserInterface.Menus;

import Models.GameModels.MetaModels.Store;
import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Magus on 30.04.2016.
 */
public class StoreMenu extends Menu{
    private static final long serialVersionUID = 1L;
    private RiverFrame frame;
    private BufferedImage img;
    private Store store;

    public StoreMenu(RiverFrame frame, FrameManager frameManager, Store store) {
        super( frame, frameManager);
        this.store = store;
        setLocation(0,0);
        setSize(800,500);
        setLayout(null);


        JButton resumeButton=new JButton("RESUME");
        JButton storeButton=new JButton("STORE");
        JButton settingsButton=new JButton("SETTINGS");
        JButton highscoreButton=new JButton("HIGHSCORES");
        JButton helpButton=new JButton("HELP");


        resumeButton.setSize(330,20);
        resumeButton.setLocation(140,130);

        settingsButton.setSize(300,50);
        settingsButton.setLocation(140,185);

        highscoreButton.setSize(390,50);
        highscoreButton.setLocation(140,240);

        helpButton.setSize(310,50);
        helpButton.setLocation(140,295);

        storeButton.setSize(300,50);
        storeButton.setLocation(140,0);


        resumeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                resumeGame();
            }
        });
        settingsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                settingScreen();
            }
        });
        highscoreButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                highscoreScreen();
            }
        });
        helpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                helpScreen();
            }

        });

        storeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                storeScreen();
            }

        });

        add(resumeButton);
        add(settingsButton);
        add(highscoreButton);
        add(helpButton);
        add(storeButton);

    };



    public void update(){
        //TODO
        paintComponent(super.g);
    }


    public void setFrame(RiverFrame frame) {
        this.frame = frame;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.drawImage(img,0,0,getWidth(),getHeight(),null);
    }
    public void resumeGame(){
        mng.requestUnpause();
    }
    public void highscoreScreen(){
        mng.requestHighscores();
    }
    public void helpScreen(){
        mng.requestHelp();
    }
    public void storeScreen(){
        mng.requestStore();
        System.out.println("STORE");
    }
    public void settingScreen(){
        mng.requestSettings();
    }
}