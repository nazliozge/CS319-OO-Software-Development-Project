package UserInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Magus on 02.05.2016.
 */
public class RiverKey implements KeyListener {

    private FrameManager fm;
    private boolean isPaused;

    public RiverKey( FrameManager f){
        fm = f;
        isPaused = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            fm.move("RIGHT");
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            fm.move("LEFT");

    }
    /** Handle the key-pressed event from the text field. */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            fm.move("RIGHT");
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            fm.move("LEFT");
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            if (!isPaused){
                fm.requestPause();;
            }
            else{
                fm.requestGame();
            }
        }
    }

    /** Handle the key-released event from the text field. */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void pSuccess(){
        isPaused = true;
    }
    public void unpSuccess(){
        isPaused = false;
    }
}
