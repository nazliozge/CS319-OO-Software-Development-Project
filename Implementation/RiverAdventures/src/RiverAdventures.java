import Controllers.GameManager;
import UserInterface.FrameManager;
import UserInterface.Menus.MainMenu;
import UserInterface.RiverFrame;

import java.awt.*;
import java.io.FileNotFoundException;

/**
 * Created by Magus on 27.04.2016.
 */
public class RiverAdventures {

    //TODO: NOT COMPETIBLE ATM
    public static void main(String[] args) throws FileNotFoundException {
        FrameManager mng;
        GameManager ctrl = new GameManager();
        mng = new FrameManager(ctrl);
        ctrl.addFrameManager(mng);

        RiverFrame rf = new RiverFrame("hello", mng);
        mng.setRiverFrame(rf);




        //mainMenu = new MainMenu( riverFrame );


        //riverFrame.setUndecorated(true);
       // riverFrame.setContentPane(mainMenu);
        //riverFrame.revalidate();
        //frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize( new Dimension());
       // riverFrame.setSize( Toolkit.getDefaultToolkit().getScreenSize());
        //frame.setResizable( false );
       // riverFrame.setVisible(true);
    }

}
