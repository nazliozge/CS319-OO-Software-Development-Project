package UserInterface;

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
            if(isTimeToStop()){
                stop();
            }
        }

        public boolean isTimeToStop(){
            return true;
        }

}
