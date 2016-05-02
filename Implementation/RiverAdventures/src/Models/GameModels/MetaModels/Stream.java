package Models.GameModels.MetaModels;

import Models.GameModels.MetaModels.RiverGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Magus on 01.05.2016.
 */
public class Stream implements ActionListener {

        private Timer timer;
        private boolean pauseIt;
        private boolean restartIt;
        private boolean running;
        private RiverGame rg;


        public Stream(){
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
                rg.update();
            }
        }

        //public boolean isTimeToStop(){
        //    return true;
        //}
}
