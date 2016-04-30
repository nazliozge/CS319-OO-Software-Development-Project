package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Menu extends JPanel{

	public FrameManager frameManager;
	public Menu(RiverFrame riverFrame){};
	public void back(){
		frameManager.returnToPrev();
	}
	
	public abstract void update();
}
