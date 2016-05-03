package UserInterface.Menus;

import UserInterface.FrameManager;
import UserInterface.RiverFrame;

import java.awt.*;
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
	private final static int XLocation = 140;
	private final static int XSize = 380;
	private final static int YSize = 50;

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++Constructor+++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public MainMenu(RiverFrame frame, FrameManager frameManager) {
		super( frame, frameManager);
		setLocation(0,0);
		setSize(1000,800);
		setLayout(null);

		Color newColor = new Color(74, 192, 195);
		setBackground(newColor);

		JButton newGameButton=new JButton("PLAY GAME");
		JButton settingsButton=new JButton("SETTINGS");
		JButton tutorialButton=new JButton("HELP");
		JButton creditButton=new JButton("CREDITS");
		JButton storeButton=new JButton("STORE");


		newGameButton.setSize(XSize,YSize);
		newGameButton.setLocation(XLocation,130);

		settingsButton.setSize(XSize,YSize);
		settingsButton.setLocation(XLocation,180);


		tutorialButton.setSize(XSize,YSize);
		tutorialButton.setLocation(XLocation,230);

		creditButton.setSize(XSize,YSize);
		creditButton.setLocation(XLocation,280);

		storeButton.setSize(XSize,YSize);
		storeButton.setLocation(XLocation,330);

		buttonList.add(newGameButton);
		buttonList.add(settingsButton);
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
	
		

	
	
	
	
	
	
	
