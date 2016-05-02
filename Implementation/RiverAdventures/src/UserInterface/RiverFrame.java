package UserInterface;

import javax.swing.*;
import UserInterface.Menus.Menu;

/**
 * Created by Magus on 29.04.2016.
 */
public class RiverFrame extends JFrame{
    private JPanel currentPanel;
    public RiverFrame( String title ){

        super(title);
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(Menu currentPanel) {
        this.currentPanel = currentPanel;
    }

    public void replacePanel(Menu menu){
        remove(currentPanel);
        currentPanel=menu;
        add(currentPanel);
        repaint();
    }

    public void toGamePanel( GamePanel gp){
        remove(currentPanel);
        currentPanel=gp;
        add(gp);
        repaint();
        gp.requestFocusInWindow();
    }
}
