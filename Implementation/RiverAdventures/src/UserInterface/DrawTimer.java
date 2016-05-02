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
        private boolean pauseIt;
        private boolean restartIt;
        private boolean running;
        private GamePanel gp;


        public DrawTimer(){
        timer = new Timer(15, this);
    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    public void actionPerformed(ActionEvent e){
        if( pauseIt && running)
        {
            System.out.println( " Timer is on!" );
            stop();
            pauseIt = false;
            running = false;
        }
        else if( restartIt && !running)
        {
            System.out.println( " Timer is off!" );
            start();
            pauseIt = false;
            running = true;
        }

        if( running){
            //TODO
        }
    }

    //public boolean isTimeToStop(){
    //    return true;
    //}
}
