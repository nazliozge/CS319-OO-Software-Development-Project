package userInterface;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameManager extends JFrame {
	
	private JPanel currentPanel;
	private GameDynamicsEngine gde;
	
	public MainFrame(JPanel currentPanel,String title){
		super(title);
		setLocation(50,50);
		setSize(1000,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.currentPanel=currentPanel;
		add(currentPanel);
		setVisible(true);
	}
	
	public void startGame(){
		remove(currentPanel);
		currentPanel=new SelectModePanel(this);
		add(currentPanel);
		repaint();
		
	}

	public void highscores(){
		//TODO	
	}
	
	
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
			currentPanel=new MainMenu();/////////prev olarak main menuye döner
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
	public void gameOver(int score){/////Gameover Paneli lazým
		removeKeyListener(gde);
		remove(currentPanel);
		currentPanel=new GameOverPanel(this,score);
		add(currentPanel);
		repaint();
	
	}
	///////////////TODO storeEvent
	
}
