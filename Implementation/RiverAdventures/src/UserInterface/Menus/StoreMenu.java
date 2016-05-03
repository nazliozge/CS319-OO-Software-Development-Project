package UserInterface.Menus;

import Models.GameModels.MetaModels.Store;
import UserInterface.FrameManager;
import UserInterface.RiverFrame;
import Models.GameModels.Buyable.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

/**
 * Created by Magus on 30.04.2016.
 */
public class StoreMenu extends Menu{

    private final static  int X = 800;
    private final static  int Y = 600;
    private final static int GAP = 5;

    private static int CHARYSTART = 10;
    private static int CHARXSTART = 10;

    private static int BOOSTYSTART = 310;
    private static int BOOSTXSTART = 310;

    private  int charXsize;
    private int charYsize;

    private static final long serialVersionUID = 1L;
    private RiverFrame frame;
    private BufferedImage img;
    private Store store;
    private int charNo;
    private int boostNo;

    private JButton[] charButtons;
    private JButton[] charEq;
    private JButton[] charUl;

    private JButton[] boostButtons;


    public StoreMenu(RiverFrame frame, FrameManager frameManager, Store store) {
        super( frame, frameManager);

        this.store = store;
        charNo = store.numOfCharacters;
        boostNo = store.numOfBoosts;
        charButtons = new JButton[charNo];
        charEq = new JButton[charNo];
        charUl= new JButton[charNo];


        setLocation(0,0);
        setSize(X,Y);
        setLayout(null);

        charXsize = (X - 2*CHARXSTART - (charNo - 1)*GAP) / charNo;
        charYsize = charXsize;
        for( int i = 0; i < charNo; i++){
            Character character = store.getCharacters()[i];
            charEq[i] = new JButton( "E" ){
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    setText("E" + character.isEquipped());
                    System.out.println("repaiiiint");
                }
            };
            charUl[i] = new JButton( "U" );
            JButton ref = charEq[i];
            JButton ref1 = charUl[i];
            charButtons[i] = new JButton( store.getCharacters()[i].getName());


            charButtons[i].setSize( charXsize, charYsize);
            charEq[i].setSize( charXsize/2, charYsize/2);
            charUl[i].setSize( charXsize/2, charYsize/2);

            charButtons[i].setLocation(CHARXSTART + i*charXsize + i*GAP, CHARYSTART );
            charEq[i].setLocation(CHARXSTART + i*charXsize + i*GAP, CHARYSTART + charYsize );
            charUl[i].setLocation(CHARXSTART + i*charXsize + i*GAP + charXsize/2, CHARYSTART + charYsize );

            charEq[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    store.equip( character);
                    System.out.println(character);
                    System.out.println(ref);
                    System.out.println("character: " + character.isEquipped());
                    ref.setText("E" + character.isEquipped());
                    repaint();
                }
            });

            charUl[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    store.unlock( character);
                }
            });
            add( charButtons[i]);
            add( charEq[i]);
            add( charUl[i]);
        }




        JButton backButton=new JButton("BACK");



        backButton.setSize(100,20);
        backButton.setLocation(GAP,Y-GAP -70);




        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    backScreen();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }

        });




        add(backButton);


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
        for( int i = 0; i < charNo; i++){
            charEq[i].repaint();
            Character character = store.getCharacters()[i];
            System.out.println(i + "" + character.isEquipped());
        }
        //g.drawImage(img,0,0,getWidth(),getHeight(),null);
    }
    public void resumeGame(){
        mng.requestUnpause();
    }
    public void highscoreScreen(){
        mng.requestHighscores();
    }
    public void backScreen() throws FileNotFoundException {
        store.save();
        mng.requestMain();
    }
    public void storeScreen(){
        mng.requestStore();
        System.out.println("STORE");
    }
    public void settingScreen(){
        mng.requestSettings();
    }
}