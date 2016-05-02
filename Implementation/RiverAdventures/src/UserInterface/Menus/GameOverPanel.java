package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Magus on 29.04.2016.
 */
public class GameOverPanel extends Menu {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private RiverFrame frame;
    private int[] scores;


    public GameOverPanel(RiverFrame frame, FrameManager frameManager, int scores) {
        super( frame, frameManager);
        setLocation(0,0);
        setSize(800,500);
        setLayout(null);
        this.frame=frame;


        JButton backButton = new JButton("BACK");
        backButton.setLocation(20,465);
        backButton.setSize(80,30);
        backButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                menu();
            }

        });
        add(backButton);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.drawImage(img,0,0,getWidth(),getHeight(),null);
    }
    public void menu(){
        mng.requestMain();
    }

    @Override
    public void update() {
        paintComponent( super.g);
    }
}

