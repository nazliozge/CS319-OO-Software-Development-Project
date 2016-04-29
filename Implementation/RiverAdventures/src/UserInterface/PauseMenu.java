package userInterface.menus;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

class PauseMenu extends Menu{
	
	public void update(){
		//TODO
	}
	
	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private BufferedImage img;
	public PauseMenu(){
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);
		
				
	JButton resumeButton=new JButton("RESUME");
	JButton storeButton=new JButton("STORE");
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
	
	storeButton.setSize(300,50);
	storeButton.setLocation(140,355);

	
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
	
	storeButton.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		storeScreen();
	}

	});

	};
	add(newGameButton);
	add(settingsButton);
	add(highscoreButton);
	add(helpButton);
	add(storeButton);
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
	public void helpScreen(){
		frame.help();
	}
	public void storeScreen(){
		frame.store();
	}
	public void settingScreen(){
		frame.settings();
	}
}
	
		

	
	
	
	
	
	
	
	
	
	
	
		

	
	
	
	
	
	
	
