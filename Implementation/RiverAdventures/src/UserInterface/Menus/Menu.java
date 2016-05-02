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

	protected Graphics g;
	protected FrameManager mng;
	protected RiverFrame frame;
	public Menu(RiverFrame riverFrame, FrameManager mng){
		this.mng = mng;
		this.frame = riverFrame;

	};
	//public void back(){
	//	frameManager.returnToPrev();
	//}

	public void setGraphics( Graphics g ){
		this.g = g;
	}
	public abstract void update();
}
