package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;



public class SettingsMenu extends Menu {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrameManager mng;
	private RiverFrame frame;
	private BufferedImage img;
	public static boolean controls=true;

	public SettingsMenu(RiverFrame riverFrame, FrameManager mng) {
		super(riverFrame, mng);
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);
		this.frame=frame;
		controls=true;
		this.mng = mng;


		JButton backButton = new JButton("BACK");
		backButton.setLocation(20,450);
		backButton.setSize(80,30);
		backButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu();
			}

		});
		add(backButton);

		JButton someButton = new JButton("1");
		someButton.setBounds(171, 360, 65, 19);
		someButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setControls(false);
			}

		});
		add(someButton);

		JButton someButton2 = new JButton("2");
		someButton2.setBounds(342, 360, 55, 19);
		someButton2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setControls(true);
			}

		});
		add(someButton2);
	}

	public boolean getControls() {
		return controls;
	}

	public void setControls(boolean controls) {
		this.controls = controls;
	}

	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
	public void menu(){
		mng.toMain();
	}

	@Override
	public void update() {
		//TODO:
		paintComponent( super.g );
	}
}
