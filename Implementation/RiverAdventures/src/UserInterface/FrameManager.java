package UserInterface;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UserInterface.Menus.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrameManager {
	

	private GameDynamicsEngine gde; // TODO keylistener
	private RiverFrame frame;
	
	public FrameManager(Menu currentPanel, String title){
		frame = new RiverFrame(title);
		frame.setLocation(50,50);
		frame.setSize(1000,600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setCurrentPanel( currentPanel );
		frame.add(currentPanel);
		frame.setVisible(true);
	}
	
	public void startGame(){
		MainMenu a = new MainMenu( frame ); // TODO: add const to Main Menu
		frame.replacePanel( a );
	}

	public void highscores(){
		GameOverPanel a = new GameOverPanel(frame);
		frame.replacePanel( a );
	}
	
	//TODO: transform others according to top methods, by using replace()
	public void help(){			
		remove(currentPanel);
		currentPanel=new HelpMenu(this);
		add(currentPanel);
		repaint();
		
	}
	
	public void credits(){
		remove(currentPanel);
		currentPanel=new CreditPanel(this);
		add(currentPanel);
		repaint();
		
	}
	public void settings(){
		remove(currentPanel);
		currentPanel=new SettingsMenu(this);
		add(currentPanel);
		repaint();
		
	}
	public void returnToPrev(){
		
			removeKeyListener(gde);
			remove(currentPanel);
			currentPanel=new MainMenu();/////////prev olarak main menuye d�ner
			((MainMenu)currentPanel).setFrame(this);
			add(currentPanel);
			repaint();
		
	}
	public void toGame(/******/){
		
		remove(currentPanel);
		currentPanel=new ////(this);
		
		gde=new GameDynamicsEngine(this,(/*****/)currentPanel);
		
		addKeyListener((KeyListener)(gde));
		this.requestFocusInWindow();
		add(currentPanel);
		gde.start();
		repaint();
	}
	public void gameOver(int score){/////Gameover Paneli laz�m
		removeKeyListener(gde);
		remove(currentPanel);
		currentPanel=new GameOverPanel(this,score);
		add(currentPanel);
		repaint();
	
	}
	///////////////TODO storeEvent
	
}
