package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PauseMenu extends Menu{

	private static final long serialVersionUID = 1L;
	private RiverFrame frame;
	private BufferedImage img;

	public PauseMenu(RiverFrame frame, FrameManager frameManager) {
		super( frame, frameManager);
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);


		JButton resumeButton=new JButton("RESUME");
		JButton mainButton=new JButton("EXIT");
		JButton settingsButton=new JButton("SETTINGS");
		JButton highscoreButton=new JButton("HIGHSCORES");
		JButton helpButton=new JButton("HELP");


		resumeButton.setSize(330,50);
		resumeButton.setLocation(140,130);

		settingsButton.setSize(300,50);
		settingsButton.setLocation(140,185);

		highscoreButton.setSize(390,50);
		highscoreButton.setLocation(140,240);

		helpButton.setSize(310,50);
		helpButton.setLocation(140,295);

		mainButton.setSize(300,50);
		mainButton.setLocation(140,355);


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
		highscoreButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				highscoreScreen();
			}
		});
		helpButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				helpScreen();
			}

		});

		mainButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainScreen();
			}

		});

		add(resumeButton);
		add(settingsButton);
		add(highscoreButton);
		add(helpButton);
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
	public void highscoreScreen(){
		mng.requestHighscores();
	}
	public void helpScreen(){
		mng.requestHelp();
	}
	public void mainScreen(){
		mng.requestMain();
	}
	public void settingScreen(){
		mng.requestSettings();
	}
}
	
		

	
	
	
	
	
	
	
	
	
	
	
		

	
	
	
	
	
	
	
