package UserInterface;

import Models.GameModels.MetaModels.RiverGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Magus on 02.05.2016.
 */
public class DrawTimer implements ActionListener

    {

        private Timer timer;
        private boolean pauseIt = false;
        private boolean running = false;
        private GamePanel gp;


        public DrawTimer(){
        timer = new Timer(15, this);
    }

    public void start(){
        timer.start();
        running = true;
    }

    private void stop(){
        timer.stop();
    }

    public void unpause(){
        if( !running )
        {
            System.out.println( " Timer is off!" );
            running = true;
            timer.start();
        }
    }

    public void pause(){
        pauseIt = true;
    }

    public void actionPerformed(ActionEvent e){
        if( pauseIt && running)
        {
            System.out.println( " Timer is on!" );
            pauseIt = false;
            running = false;
            timer.stop();
        }

        else if( running){
            //TODO
            gp.repaint();
        }
    }

    //public boolean isTimeToStop(){
    //    return true;
    //}
}
