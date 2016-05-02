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
	private RiverKey key;


	public FrameManager( RiverFrame rf, GameManager ctrl){
		frame = rf;
		this.ctrl = ctrl;
		MainMenu a = new MainMenu(frame,this);
		System.out.println( a);
		frame.setCurrentPanel(a );
		frame.add(frame.getCurrentPanel());
		toMain();
		key = new RiverKey(this);
		frame.addKeyListener(key);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
	}


	public void requestMain(){
		ctrl.toMenu();
	}
	public void toMain(){
		MainMenu a = new MainMenu( frame, this ); // TODO: add const to Main Menu
		frame.replacePanel( a );
	}
	public void requestHighscores(){
		ctrl.endGame();
	}
	public void toHighscores( int score){
		GameOverPanel a = new GameOverPanel(frame, this, score);
		frame.replacePanel( a );
	}
	public void requestHelp() {
		ctrl.toHelp();
	}

	public void help(){
		HelpMenu a = new HelpMenu(frame, this);
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
		HelpMenu a = new HelpMenu(frame, this);
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
		System.out.println(ctrl.initializeGame());
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
		key.unpSuccess();
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
		PauseMenu a = new PauseMenu(frame, this);
		frame.replacePanel(a);
		key.pSuccess();
	}
	public void requestUnpause(){
		ctrl.unpauseGame();
	}

	public void requestStore(){
		ctrl.accessToStore();
	}

	public void toStore( Store store){
		StoreMenu a = new StoreMenu(frame, this, store);
		frame.replacePanel(a);
	}

	public void move(String direction){
			ctrl.move(direction);
	}
	///////////////TODO storeEvent

}
