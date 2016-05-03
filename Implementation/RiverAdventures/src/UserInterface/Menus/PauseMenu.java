package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PauseMenu extends Menu{

	private static final long serialVersionUID = 1L;
	private RiverFrame frame;
	private BufferedImage img;
	private final static int XLocation = 140;
	private final static int XSize = 380;
	private final static int YSize = 50;

	public PauseMenu(RiverFrame frame, FrameManager frameManager) {
		super( frame, frameManager);
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);


		JButton resumeButton=new JButton("RESUME");
		JButton mainButton=new JButton("EXIT");
		JButton settingsButton=new JButton("SETTINGS");

		Color newColor = new Color(74, 192, 195);
		setBackground(newColor);



		resumeButton.setSize(XSize,YSize);
		resumeButton.setLocation(XLocation,130);

		settingsButton.setSize(XSize,YSize);
		settingsButton.setLocation(XLocation,180);


		mainButton.setSize(XSize,YSize);
		mainButton.setLocation(XLocation,230);



		resumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resumeGame();
			}
		});
		settingsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				settingScreen();
			}
		});


		mainButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainScreen();
			}

		});

		add(resumeButton);
		add(settingsButton);
		add(mainButton);

	};



	public void update(){
		//TODO
		paintComponent(super.g);
	}


	public void setFrame(RiverFrame frame) {
		this.frame = frame;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
	public void resumeGame(){
		mng.requestUnpause();
	}

	public void mainScreen(){
		mng.requestMain();
	}
	public void settingScreen(){
		mng.requestSettings();
	}
}
	
		

	
	
	
	
	
	
	
	
	
	
	
		

	
	
	
	
	
	
	
