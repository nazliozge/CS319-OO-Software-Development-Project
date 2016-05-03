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
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
		//JButton highscoreButton=new JButton("HIGHSCORES");
		JButton helpButton=new JButton("HELP");
>>>>>>> origin/master

		Color newColor = new Color(74, 192, 195);
		setBackground(newColor);



<<<<<<< Updated upstream
		//highscoreButton.setSize(390,50);
		//highscoreButton.setLocation(140,240);
=======
<<<<<<< HEAD
		resumeButton.setSize(XSize,YSize);
		resumeButton.setLocation(XLocation,130);
=======
		//highscoreButton.setSize(390,50);
		//highscoreButton.setLocation(140,240);
>>>>>>> origin/master
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
		//highscoreButton.addActionListener(new ActionListener(){
		//	public void actionPerformed(ActionEvent e){
			//	highscoreScreen();
			//}
		//});
		helpButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				helpScreen();
			}
>>>>>>> origin/master


		mainButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainScreen();
			}

		});

		add(resumeButton);
		add(settingsButton);
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
		//add(highscoreButton);
		add(helpButton);
>>>>>>> origin/master
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
<<<<<<< Updated upstream
=======
<<<<<<< HEAD

=======
>>>>>>> Stashed changes
	//public void highscoreScreen(){
		//mng.requestHighscores();
	//}
	public void helpScreen(){
		mng.requestHelp();
	}
>>>>>>> origin/master
	public void mainScreen(){
		mng.requestMain();
	}
	public void settingScreen(){
		mng.requestSettings();
	}
}
	
		

	
	
	
	
	
	
	
	
	
	
	
		

	
	
	
	
	
	
	
