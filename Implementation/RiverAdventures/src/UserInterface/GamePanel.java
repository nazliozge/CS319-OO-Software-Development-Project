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

    private Frame frame;
    private RiverGame riverGame;

    private RiverCenter center;

    private KeyListener kl;

    private int shieldLimit;

    private RiverLeft left;
    private RiverRight right;

    private int coins;
    private int health;

    public GamePanel() {
        BorderLayout layout = new BorderLayout(0, 0);
        setLayout(layout);

        left = new RiverLeft();
        this.add(left, BorderLayout.BEFORE_LINE_BEGINS);

        center = new RiverCenter();
        this.add(center, BorderLayout.CENTER);

        right = new RiverRight();
        this.add(right, BorderLayout.LINE_END);
    }

    public GamePanel(RiverGame gm, RiverKey key, Frame f) {

        riverGame = gm;
        frame = f;
        setSize(new Dimension(700, 500));
        BorderLayout layout = new BorderLayout(0, 0);
        setLayout(layout);

        left = new RiverLeft();
        this.add(left, BorderLayout.BEFORE_LINE_BEGINS);

        center = new RiverCenter();
        this.add(center, BorderLayout.CENTER);

        right = new RiverRight();
        this.add(right, BorderLayout.LINE_END);

        kl = key;
    }


    //RIVER LEFT
    private class RiverLeft extends JPanel {

        private JLabel shieldLimitLabel;

        public RiverLeft() {

            shieldLimit = 0;
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200, 500));

            //stream = new Timer(DEFAULT_DELAY, this);
            //stream.start();
            setLayout(new BorderLayout(0, 0));

            setLayout(new BorderLayout(0, 0));
            JButton pause = new JButton("Pause");
            add(pause, BorderLayout.NORTH);

            shieldLimitLabel = new JLabel("Shield limit:" + riverGame.getShield());
            add(shieldLimitLabel, BorderLayout.SOUTH);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {
            Image img = new ImageIcon("image/tree/tree1.png").getImage();
            Image img1 = new ImageIcon("image/tree/tree2.png").getImage();
            int xSize = 100;
            int ySize = 130;
            g.drawImage(img1, 20, 30, xSize, ySize, null);
            g.drawImage(img, 100, 80, xSize, ySize, null);
            g.drawImage(img, 50, 230, xSize, ySize, null);
            g.drawImage(img1, 10, 340, xSize, ySize, null);

            if (shieldLimit == -1) {
                shieldLimitLabel.setText("Shield Limit: INFINITY");
            } else {
                shieldLimitLabel.setText("Shield Limit: " + shieldLimit);
            }

        }


    }

    //RIVER RIGHT
    private class RiverRight extends JPanel  {
        private JLabel points;
        private JLabel healthLabel;

        public RiverRight() {
            Color newColor = new Color(34, 195, 114);
            setBackground(newColor);
            setPreferredSize(new Dimension(200, 500));

            setLayout(new BorderLayout(0, 0));

            points = new JLabel("Coins: 0");
            healthLabel = new JLabel("Health:" + riverGame.getShield());
            this.add(points, BorderLayout.NORTH);
            this.add(healthLabel, BorderLayout.SOUTH);

        }


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {
            Image img = new ImageIcon("image/tree/tree1.png").getImage();
            Image img1 = new ImageIcon("image/tree/tree2.png").getImage();
            int xSize = 100;
            int ySize = 130;
            g.drawImage(img1, 20, 30, xSize, ySize, null);
            g.drawImage(img, 100, 80, xSize, ySize, null);
            g.drawImage(img, 50, 230, xSize, ySize, null);
            g.drawImage(img1, 10, 350, xSize, ySize, null);

            points.setText("Coins: " + riverGame.getCoin());
            healthLabel.setText("Health: " + riverGame.getHp());
        }
    }

    //CENTER RIVER
    public class RiverCenter extends JPanel {

        public RiverCenter() {
            Color newColor = new Color(64, 55, 255);
            setBackground(newColor);
            setPreferredSize(new Dimension(300, 500));

            this.addKeyListener(kl);
            this.setFocusable(true);
            this.requestFocusInWindow();
        }


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("repaint CENTER");
            updateCoins();
            updateHealth();
            updateShieldLimit();
            riverGame.draw(g);
        }


        public void updateCoins() {
            coins = riverGame.getCoin();
        }

        public void updateHealth() {
            health = riverGame.getHp();
        }

        public void updateShieldLimit() {
            shieldLimit = riverGame.getShield();
        }



    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        center.paintComponent(g);
        left.paintComponent(g);
        right.paintComponent(g);
        System.out.println("i repaint");
        System.out.println(riverGame.getRiver().getUserCharacter().getxPosition());
    }

    public void update() {
        System.out.println("repaint");
        repaint();
    }
}
