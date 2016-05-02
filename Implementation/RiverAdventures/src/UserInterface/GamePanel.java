package UserInterface;

import Models.GameModels.MetaModels.River;
import Models.GameModels.MetaModels.RiverGame;
import Models.GameModels.MetaModels.Store;


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
    private River river;
    private Store store;
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
    private int health;
    public KeyListener kl;
    public int stop;
    private int shieldLimit;

    public GamePanel(){

        coins = 0;
        health = 100;
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


    //RIVER LEFT
    private class RiverLeft extends JPanel implements ActionListener{

        private JLabel shieldLimitLabel;

        public RiverLeft(){
            shieldLimit = 0;
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200,500));

            stream = new Timer(15, this);
            stream.start();
            setLayout(new BorderLayout(0,0));

            setLayout(new BorderLayout(0,0));
            JButton pause = new JButton("Pause");
            add(pause, BorderLayout.NORTH);

            shieldLimitLabel = new JLabel("Shield limit: 0");
            add(shieldLimitLabel, BorderLayout.SOUTH);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g)
        {
            Image img = new ImageIcon("image/tree/tree1.png").getImage();
            Image img1 = new ImageIcon("image/tree/tree2.png").getImage();
            int xSize = 100;
            int ySize = 130;
            g.drawImage(img1, 20, 30, xSize, ySize, null);
            g.drawImage(img, 100, 80, xSize, ySize, null);
            g.drawImage(img, 50, 230, xSize, ySize, null);
            g.drawImage(img1, 10, 340, xSize, ySize, null);

            shieldLimitLabel.setText("Shield Limit: " + shieldLimit);

        }
        @Override
        public void actionPerformed(ActionEvent event)
        {
            repaint();//calls paintComponent
        }

    }

    //RIVER RIGHT
    private class RiverRight extends JPanel implements ActionListener{
        private JLabel points;
        private JLabel healthLabel;

        public RiverRight(){
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200,500));

            stream = new Timer(15, this);
            stream.start();
            setLayout(new BorderLayout(0,0));

            points = new JLabel("Coins: 0");
            healthLabel = new JLabel("Health: 100");
            this.add(points, BorderLayout.NORTH);
            this.add(healthLabel, BorderLayout.SOUTH);

        }


        @Override
        public void actionPerformed(ActionEvent event)
        {
            repaint(); //calls paintComponent
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g)
        {
            Image img = new ImageIcon("image/tree/tree1.png").getImage();
            Image img1 = new ImageIcon("image/tree/tree2.png").getImage();
            int xSize = 100;
            int ySize = 130;
            g.drawImage(img1, 20, 30, xSize, ySize, null);
            g.drawImage(img, 100, 80, xSize, ySize, null);
            g.drawImage(img, 50, 230, xSize, ySize, null);
            g.drawImage(img1, 10, 350, xSize, ySize, null);

            points.setText("Coins: " + riverGame.getTempWallet());
            healthLabel.setText("Health: " + health);

        }
    }

    //CENTER RIVER
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

        public void updateHealth(){
            health = riverGame.getRiver().getUserCharacter().getHealth();
        }

        public void updateShieldLimit(){
            shieldLimit = riverGame.getRiver().getUserCharacter().getShieldLimit();
        }
        private class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                counter ++;
                update(riverGame);
                updateCoins();
                updateHealth();
                updateShieldLimit();
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
