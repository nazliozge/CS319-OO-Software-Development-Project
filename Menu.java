package userInterface.menus;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

abstract class Menu extends FrameManager{
	
	public void back(){
		returnToPrev();
	}
	
	public abstract void update();
}
