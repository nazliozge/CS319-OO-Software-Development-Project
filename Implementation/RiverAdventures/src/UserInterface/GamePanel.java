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
    boolean killTimer = false;
    boolean restartTimer = false;
    private boolean isTimerOn = true;//for pausing
    private final static int DELAY_DECREMENT = 1;
    private int counter = 0;
    private int speedLimit = 200;
    private int speedIncrement = 50;
    public RiverCenter center;
    private int coins;
    public KeyListener kl;

    public GamePanel(){

        coins = 0;

        BorderLayout layout = new BorderLayout(0,0);
        setLayout(layout);

        RiverLeft left = new RiverLeft();
        this.add(left, BorderLayout.BEFORE_LINE_BEGINS);

        center = new RiverCenter();
        this.add(center, BorderLayout.CENTER);

        RiverRight right = new RiverRight();
        this.add(right, BorderLayout.LINE_END);
    }

    public GamePanel(RiverGame gm) {
    }


    public void draw(Graphics g){
        Image img = new ImageIcon("image/tree/tree1.png").getImage();
        Image img1 = new ImageIcon("image/tree/tree2.png").getImage();
        int xSize = 100;
        int ySize = 130;
        g.drawImage(img1, 20, 30, xSize, ySize, null);
        g.drawImage(img, 100, 80, xSize, ySize, null);
        g.drawImage(img, 50, 230, xSize, ySize, null);
        g.drawImage(img1, 10, 380, xSize, ySize, null);

    }

    private class RiverLeft extends JPanel{

        public RiverLeft(){
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200,500));

            setLayout(new BorderLayout(0,0));
            JButton pause = new JButton("Pause");
            add(pause, BorderLayout.NORTH);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g);
        }

    }

    private class RiverRight extends JPanel implements ActionListener{

        public RiverRight(){
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200,500));

            stream = new Timer(15, this);
            setLayout(new BorderLayout(0,0));
            JLabel points = new JLabel("Points: " + coins);
            add(points, BorderLayout.NORTH);

        }

        @Override
        public void actionPerformed(ActionEvent event)
        {
            repaint();
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g);
        }

    }

    public class RiverCenter extends JPanel{

        public RiverCenter(){
            Color newColor = new Color(64, 55, 255);
            setBackground(newColor);
            setPreferredSize(new Dimension(300,500));

            riverGame = new RiverGame();
            stream = new Timer(15, new TimerListener());
            stream.start();

            kl = new MyKeyListener();
            this.addKeyListener(kl);
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

        public void updateCoins(){
            coins = riverGame.getTempWallet();
        }

        private class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                counter ++;
                update(riverGame);
                updateCoins();
                repaint();

                if (counter > speedLimit){
                    stream.setDelay((stream.getDelay() - DELAY_DECREMENT));
                    counter = 0;
                    speedLimit += speedIncrement;
                }
                if( killTimer && isTimerOn)
                {
                    System.out.println( " Timer is on!" );
                    stream.stop();
                    killTimer = false;
                    isTimerOn = false;
                }

                if( restartTimer && !isTimerOn)
                {
                    System.out.println( " Timer is off!" );
                    stream.start();
                    restartTimer = false;
                    isTimerOn = true;
                }
            }
        }

        public class MyKeyListener implements KeyListener{

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
                        killTimer = true;
                    }
                    else{
                        restartTimer = true;
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
