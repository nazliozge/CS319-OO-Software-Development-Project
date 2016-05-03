package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by Magus on 03.05.2016.
 */
public class CreditsMenu extends Menu {
        private static final long serialVersionUID = 1L;
        private RiverFrame frame;


        public CreditsMenu(RiverFrame frame, FrameManager frameManager) {
            super( frame, frameManager);
            setLocation(0,0);
            setSize(800,500);
            setLayout(null);
            this.frame=frame;

            JLabel theName = new JLabel("RiverAdventures:");
            theName.setLocation(20,20);
            theName.setSize(100,200);
            JButton backButton = new JButton("BACK");
            backButton.setLocation(20,465);
            backButton.setSize(80,30);
            backButton.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        menu();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            });
            add(backButton);
            add(theName);

        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //g.drawImage(img,0,0,getWidth(),getHeight(),null);
        }
        public void menu() throws FileNotFoundException {
            mng.requestMain();
        }

        @Override
        public void update() {
            paintComponent( super.g);
        }
}
