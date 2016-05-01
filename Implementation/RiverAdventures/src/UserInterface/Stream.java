package UserInterface;

import Models.GameModels.MetaModels.RiverGame;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Magus on 01.05.2016.
 */
public class Stream{
    Timer timer;
    GamePanel gp;
    RiverGame gm;

    public Stream(int time) {
        timer = new Timer();
        timer.schedule(new Flow(), time);
    }
    class Flow extends TimerTask {
        public void run() {
            System.out.format("Time's up!%n");
            counter ++;
            update(riverGame);
            updateCoins();
            repaint();
        }
    }
