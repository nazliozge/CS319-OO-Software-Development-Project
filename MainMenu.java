package userInterface.menus;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

class MainMenu extends Menu{
	
	public void update(){
		//TODO
	}
	
	ArrayList<JButton> buttonList = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private BufferedImage img;
	public MenuPanel(){
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);
		
				
	JButton newGameButton=new JButton("PLAY GAME");
	JButton settingsButton=new JButton("SETTINGS");
	JButton highscoreButton=new JButton("HIGHSCORES");
	JButton helpButton=new JButton("HELP");
	JButton creditButton=new JButton("CREDITS");
	

	
	newGameButton.setSize(330,50);
	newGameButton.setLocation(140,130);
								
	settingsButton.setSize(300,50);
	settingsButton.setLocation(140,185);
								
	highscoreButton.setSize(390,50);
	highscoreButton.setLocation(140,240);
							
	helpButton.setSize(310,50);
	helpButton.setLocation(140,295);
	
	creditButton.setSize(300,50);
	creditButton.setLocation(140,355);
	
	buttonList.add(newGameButton);
	buttonList.add(settingsButton);
	buttonList.add(highscoreButton);
	buttonList.add(helpButton);
	buttonList.add(creditButton);
	
	
	newGameButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			startGame();
		}
	};
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
			helpScreen();
		}

	});
	creditButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			creditScreen();
		}

	});
	add(newGameButton);
	add(settingsButton);
	add(highscoreButton);
	add(helpButton);
	add(creditButton);
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
	public void startGame(){
		frame.startGame();
	}
	public void highscoreScreen(){
		frame.highscores();
	}
	public void tutorialScreen(){
		frame.help();
	}
	public void creditScreen(){
		frame.credits();
	}
	public void settingScreen(){
		frame.settings();
	}
}
	
		
}
	
	
	
	
	
	
	