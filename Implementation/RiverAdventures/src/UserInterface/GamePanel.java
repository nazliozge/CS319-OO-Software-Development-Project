package UserInterface;

import Models.GameModels.MetaModels.River;
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

        BorderLayout layout = new BorderLayout(0,0);
        setLayout(layout);

        RiverLeft left = new RiverLeft();
        this.add(left, BorderLayout.BEFORE_LINE_BEGINS);

        RiverCenter center = new RiverCenter();
        this.add(center, BorderLayout.CENTER);

        RiverRight right = new RiverRight();
        this.add(right, BorderLayout.LINE_END);
    }


    public void draw(Graphics g){
        Image img = new ImageIcon("image/tree/tree1.png").getImage();
        Image img1 = new ImageIcon("image/tree/tree2.png").getImage();
        int xSize = 100;
        int ySize = 130;
        g.drawImage(img1, 20, 10, xSize, ySize, null);
        g.drawImage(img, 100, 80, xSize, ySize, null);
        g.drawImage(img, 50, 230, xSize, ySize, null);
        g.drawImage(img1, 10, 380, xSize, ySize, null);

    }

    private class RiverLeft extends JPanel{

        public RiverLeft(){
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200,500));

        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g);
        }

    }

    private class RiverRight extends JPanel{

        public RiverRight(){
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200,500));
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g);
        }

    }

    private class RiverCenter extends JPanel{

        public RiverCenter(){
            Color newColor = new Color(64, 55, 255);
            setBackground(newColor);
            setPreferredSize(new Dimension(300,500));

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
}
