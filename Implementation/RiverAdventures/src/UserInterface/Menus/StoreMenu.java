package UserInterface.Menus;

import Models.GameModels.Buyable.ExclusiveBoost;
import Models.GameModels.MetaModels.Store;
import Models.GameModels.RealModels.Boost.Boost;
import UserInterface.FrameManager;
import UserInterface.RiverFrame;
import Models.GameModels.Buyable.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import static com.sun.javafx.tools.resource.DeployResource.Type.icon;

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

    private  int charXsize = 120;
    private int charYsize = 120;

    private static final long serialVersionUID = 1L;
    private RiverFrame frame;
    private BufferedImage img;
    private Store store;
    private int charNo;
    private int boostNo;

    private JButton[] charButtons;
    private JButton[] charEq;
    private JButton[] charUl;

    private JButton[] boostEq;
    private JButton[] boostUl;


    private JButton[] boostButtons;


    public StoreMenu(RiverFrame frame, FrameManager frameManager, Store store) {
        super( frame, frameManager);

        this.store = store;
        charNo = store.numOfCharacters;
        boostNo = store.numOfBoosts;

        charButtons = new JButton[charNo];
        charEq = new JButton[charNo];
        charUl= new JButton[charNo];


        boostButtons  = new JButton[boostNo];
        boostEq = new JButton[boostNo];
        boostUl = new JButton[boostNo];

        setLocation(0,0);
        setSize(X,Y);
        setLayout(null);

        for( int i = 0; i < charNo; i++){
            Character character = store.getCharacters()[i];
            charEq[i] = new JButton( "E" ){
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    setText("E " + character.isEquipped());
                }
            };
            charUl[i] = new JButton( "U" );
            JButton ref = charEq[i];
            JButton ref1 = charUl[i];

            ImageIcon icon = new ImageIcon("image/userCharacter/" + store.getCharacters()[i].getName() + ".png");
            Image newimg = icon.getImage().getScaledInstance( charXsize, charYsize,  java.awt.Image.SCALE_SMOOTH ) ;;
            icon = new ImageIcon( newimg );
            charButtons[i] = new JButton();

            charButtons[i].setSize( charXsize, charYsize);
            charButtons[i].setIcon(icon);
            charButtons[i].setEnabled(true);

            charEq[i].setSize( charXsize/2, charYsize/2);
            charUl[i].setSize( charXsize/2, charYsize/2);

            charButtons[i].setLocation(CHARXSTART + i*charXsize + i*GAP, CHARYSTART );
            charEq[i].setLocation(CHARXSTART + i*charXsize + i*GAP, CHARYSTART + charYsize );
            charUl[i].setLocation(CHARXSTART + i*charXsize + i*GAP + charXsize/2, CHARYSTART + charYsize );

            charEq[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    store.equip( character);
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




        String[] names = {"shield", "minimise", "slowdown2", "invincibility", "health"};
        int loc =0;
        for( int i = 0; i < 5; i++){
            ExclusiveBoost boost = store.getBoosts()[i];
            boostEq[i] = new JButton( "Lvl: " ){
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
//                    setText("E " + boost.isUnlocked());
                }
            };
            boostUl[i] = new JButton( "U" );
            JButton ref2 = boostEq[i];
            JButton ref1 = boostUl[i];

//
//            ImageIcon icon1 = new ImageIcon("image/boost/shield" +i+ ".png");
//            Image newimg = icon1.getImage().getScaledInstance( charXsize, charYsize,  java.awt.Image.SCALE_SMOOTH ) ;
//
//            ImageIcon icon2 = new ImageIcon("image/boost/health" + i + ".png");
//            Image newimg = icon2.getImage().getScaledInstance( charXsize, charYsize,  java.awt.Image.SCALE_SMOOTH ) ;

            ImageIcon icon = new ImageIcon("image/boost/" + names[i] + "1.png");

            Image newimg = icon.getImage().getScaledInstance( charXsize, charYsize,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            boostButtons[i] = new JButton();

            boostButtons[i].setSize( charXsize, charYsize);
            boostButtons[i].setIcon(icon);
            boostButtons[i].setEnabled(true);

            boostEq[i].setSize( charXsize/2, charYsize/2);
            boostUl[i].setSize( charXsize/2, charYsize/2);

            boostButtons[i].setLocation(CHARXSTART + i*charXsize + i*GAP, CHARYSTART + 2 * charYsize );
            boostEq[i].setLocation(CHARXSTART + i*charXsize + i*GAP, CHARYSTART + 3 * charYsize );
            boostUl[i].setLocation(CHARXSTART + i*charXsize + i*GAP + charXsize/2, CHARYSTART + 3 * charYsize );

            boostEq[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    store.upgrade( boost);

                    ref2.setText("Lvl: " + boost.getLevel());
                    repaint();
                }
            });

            boostUl[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    store.unlock( boost);
                }
            });
            add( boostButtons[i]);
            add( boostEq[i]);
            add( boostUl[i]);
        }


        JButton backButton=new JButton("BACK");

        backButton.setSize(100,20);
        backButton.setLocation(GAP,Y-GAP - 150);

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
        }
        for( int i = 0; i < boostNo; i++){
            boostEq[i].repaint();
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