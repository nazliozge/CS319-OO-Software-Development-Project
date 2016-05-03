package Models.GameModels.MetaModels;

import Models.GameModels.MetaModels.RiverGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Magus on 01.05.2016.
 */
public class Stream implements ActionListener

{

    private Timer timer;
    private boolean pauseIt = false;
    private boolean running = false;
    private RiverGame gm;


    public Stream(RiverGame g){
        timer = new Timer(2, this);
        gm = g;
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
            //System.out.println( " Timer is off!" );
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
            System.out.println( " Timer is offf!" );
            pauseIt = false;
            running = false;
            timer.stop();
        }

        else if( running){
            //TODO
            gm.work();
            System.out.println( " Timer is on!" );
        }
        //System.out.println( " Timer is on!" );
    }

    //public boolean isTimeToStop(){
    //    return true;
    //}
}
