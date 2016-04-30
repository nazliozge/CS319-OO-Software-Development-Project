package UserInterface;

import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.GameManager;
import Models.GameModels.MetaModels.RiverGame;
import Models.GameModels.MetaModels.Store;
import UserInterface.Menus.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrameManager {
	

	//private Stack<Menu> menuStack; // not all menus are stackable
	private GameManager ctrl;
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
		toMain();
	}
	public void requestMain(){
		ctrl.toMenu();
	}
	public void toMain(){
		MainMenu a = new MainMenu( frame ); // TODO: add const to Main Menu
		frame.replacePanel( a );
	}
	public void requestHighscores{
		ctrl.toHighscores();
	}
	public void toHighscores(){
		GameOverPanel a = new GameOverPanel(frame);
		frame.replacePanel( a );
	}
	public void requestHelp() {
		ctrl.toHelp();
	}

	public void help(){
		HelpMenu a = new HelpMenu(frame);
		frame.replacePanel( a );
	}
/*
	public void credits(){
		remove(currentPanel);
		currentPanel=new CreditPanel(this);
		add(currentPanel);
		repaint();
		
	}
*/
	public void requestSettings(){
		ctrl.toSettings();
	}
	public void toSettings(){
		HelpMenu a = new HelpMenu(frame);
		frame.replacePanel( a );
	}
/*	Was related to stack
	public void returnToPrev(){
		
			removeKeyListener(gde);
			remove(currentPanel);
			currentPanel=new MainMenu();/////////prev olarak main menuye d�ner
			((MainMenu)currentPanel).setFrame(this);
			add(currentPanel);
			repaint();
		
	}
*/
	public void requestGame(){
		ctrl.initializeGame();
	}

	public void toGame( RiverGame gm ){

		GamePanel a = new GamePanel(gm);
		frame.toGamePanel(a);
		//remove(currentPanel);
		//currentPanel=new ////(this);
		
		//gde=new GameDynamicsEngine(this,(/*****/)currentPanel);
		
		//addKeyListener((KeyListener)(gde));
		//this.requestFocusInWindow();
		//add(currentPanel);
		//gde.start();
		//repaint();
		ctrl.startGameLoop();
	}
/*
	public void gameOver(int score){/////Gameover Paneli laz�m
		removeKeyListener(gde);
		remove(currentPanel);
		currentPanel=new GameOverPanel(this,score);
		add(currentPanel);
		repaint();
	
	}
*/
	public void requestPause(){
		ctrl.pauseGame();
	}

	public void toPause(){
		PauseMenu a = new PauseMenu(frame);
		frame.replacePanel(a);
	}

	public void requestStore(){
		ctrl.accessToStore();
	}

	public void toStore( Store store){
		StoreMenu a = new StoreMenu(frame, Store);
		frame.replacePanel(a);
	}
	///////////////TODO storeEvent
	
}
