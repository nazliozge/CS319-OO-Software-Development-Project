package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends Menu{

	ArrayList<JButton> buttonList = new ArrayList<>();

	private static final long serialVersionUID = 1L;
	private BufferedImage img;

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++Constructor+++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public MainMenu(RiverFrame frame, FrameManager frameManager) {
		super( frame, frameManager);
		setLocation(0,0);
		setSize(1000,800);
		setLayout(null);



		JButton newGameButton=new JButton("PLAY GAME");
		JButton settingsButton=new JButton("SETTINGS");
		JButton highscoreButton=new JButton("HIGHSCORES");
		JButton tutorialButton=new JButton("HELP");
		JButton creditButton=new JButton("CREDITS");
		JButton storeButton=new JButton("STORE");


		newGameButton.setSize(330,50);
		newGameButton.setLocation(140,130);

		settingsButton.setSize(300,50);
		settingsButton.setLocation(140,185);

		highscoreButton.setSize(390,50);
		highscoreButton.setLocation(140,240);

		tutorialButton.setSize(310,50);
		tutorialButton.setLocation(140,295);

		creditButton.setSize(300,50);
		creditButton.setLocation(140,355);

		storeButton.setSize(300,50);
		storeButton.setLocation(140,400);

		buttonList.add(newGameButton);
		buttonList.add(settingsButton);
		buttonList.add(highscoreButton);
		buttonList.add(tutorialButton);
		buttonList.add(creditButton);
		buttonList.add(storeButton);


		newGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				startGame();
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
		tutorialButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tutorialScreen();
			}

		});
		storeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				storeScreen();
			}

		});
		/*creditButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				creditScreen();
			}

		});*/
		add(newGameButton);
		add(settingsButton);
		add(highscoreButton);
		add(tutorialButton);
		add(creditButton);
		add( storeButton);
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++METHODS+++++++++++++++++++++++++++++++++++++++++++++
	public void update(){
		//TODO
		paintComponent(super.g);
	}

	public void setFrame(RiverFrame frame) {
		super.frame = frame;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}

	public void startGame(){
		System.out.println(mng);
		mng.requestGame();
	}
	public void highscoreScreen(){
		mng.requestHighscores();
	}
	public void tutorialScreen(){
		mng.requestHelp();
	}
	public void creditScreen(){
	//	frame.credits();
	}
	public void storeScreen(){
		mng.requestStore();
		System.out.println("STORE");
	}
	public void settingScreen(){
		mng.requestSettings();
	}
}
	
		

	
	
	
	
	
	
	
