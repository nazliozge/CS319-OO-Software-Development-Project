package UserInterface;

import Models.GameModels.MetaModels.RiverGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Meder on 27/04/16.
 */
public class GamePanel extends JPanel {

    private RiverGame riverGame;
    private Timer stream;
    private boolean isTimerOn = true;//for pausing

    public GamePanel(){

        Color newColor = new Color(155, 205, 255);
        setBackground(newColor);
        setPreferredSize(new Dimension(500,500));

        riverGame = new RiverGame();
        stream = new Timer(20, new TimerListener());
        stream.start();

        this.addKeyListener(new MyKeyListener());
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        riverGame.draw(g);
    }


    public void update(RiverGame riverGame){
        riverGame.update();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            update(riverGame);
            repaint();
        }
    }

    private class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                riverGame.move("RIGHT");
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                riverGame.move("LEFT");

        }

        /** Handle the key-pressed event from the text field. */
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                riverGame.move("RIGHT");
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                riverGame.move("LEFT");
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                if (isTimerOn){
                    stream.stop();
                    isTimerOn = !isTimerOn;
                }
                else{
                    stream.start();
                    isTimerOn = !isTimerOn;
                }

            }
        }

        /** Handle the key-released event from the text field. */
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
