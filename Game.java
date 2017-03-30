import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Game{
	
	boolean running;
	ArrayList<Player> playArray;
	ArrayList<Monster> monArray;
	ArrayList<JLabel> playerLbl;//all arrays will be used to convert to multiplayer
	ArrayList<JLabel> monsterLbl;
	JFrame window;
	JPanel panel;
	Player rocco;
	Monster jt;
	JProgressBar roccohp;
	ArrayList<JProgressBar> monsterHpBars;
	boolean firstTime; //is this the first time the game is being set up? used to make the loop not cearte 100 mobs when the player dies.
	InputHandler input;
	byte floor;//what floor are they on? 0=above ground floor 1-9 1 being dung 1 floor 1 9 being dung 3 floor 9
	
	//menu**
	
	JMenu game;
	JMenuItem save;
	JMenuItem load;
	JMenuItem respawn;
	JMenuItem exit;
	
	JMenu dung1;
	JMenu dung2;
	JMenu dung3;
	
	JMenuItem controls;
	
	JMenuItem d1f1;//dung 1 floor 1
	JMenuItem d1f2;
	JMenuItem d1f3;
	
	JMenuItem d2f1;
	JMenuItem d2f2;
	JMenuItem d2f3;
	
	JMenuItem d3f1;
	JMenuItem d3f2;
	JMenuItem d3f3;
	//end menu**
	
	public void initMobs(){
		
		running = true;
		playArray = new ArrayList<Player>();
		monArray = new ArrayList<Monster>();
		playerLbl = new ArrayList<JLabel>();//all arrays will be used to convert to multiplayer
		monsterLbl = new ArrayList<JLabel>();
		window = makeWindow();
		rocco = new Player((byte)1, "Rocco");
		jt = new Monster((byte)1, "jt");
		roccohp = makeHpBar(rocco);
		monsterHpBars = new ArrayList<JProgressBar>();
		firstTime = true; //is this the first time the game is being set up? used to make the loop not cearte 100 mobs when the player dies.
		floor = 0;
		
	}
	
	public void initMenu(){
		
		game = new JMenu("Game");
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");//probably wont use cuz cheating
		respawn = new JMenuItem("Respawn");
		exit = new JMenuItem("Exit");
		
		dung1 = new JMenu("Dungeon 1");
		dung2 = new JMenu("Dungeon 2");
		dung3 = new JMenu("Dungeon 3");
		
		controls = new JMenuItem("Controls");
		
		d1f1 = new JMenuItem("Floor 1");//dung 1 floor 1
		d1f2 = new JMenuItem("Floor 2");
		d1f3 = new JMenuItem("Floor 3");
		
		d2f1 = new JMenuItem("Floor 1");
		d2f2 = new JMenuItem("Floor 2");
		d2f3 = new JMenuItem("Floor 3");
		
		d3f1 = new JMenuItem("Floor 1");
		d3f2 = new JMenuItem("Floor 2");
		d3f3 = new JMenuItem("Floor 3");
		
	}
	
	public Game(){
		
		this.panel = new JPanel();
		//menu
		this.initMenu();
		//menu
		this.initMobs();
		panel.setSize(window.getSize());
		this.window.add(panel);
		
		input = new InputHandler(window);
		
	}
	
	public void setupFrame(){
		//Menu bar
		
		MenuBarListener menuListener = new MenuBarListener();
		
		
		JMenuBar menuBar = new JMenuBar();
			dung1.addActionListener(menuListener);
				d1f1.addActionListener(menuListener);
				d1f2.addActionListener(menuListener);
				d1f3.addActionListener(menuListener);
			dung2.addActionListener(menuListener);
				d2f1.addActionListener(menuListener);
				d2f2.addActionListener(menuListener);
				d2f3.addActionListener(menuListener);
			dung3.addActionListener(menuListener);
				d3f1.addActionListener(menuListener);
				d3f2.addActionListener(menuListener);
				d3f3.addActionListener(menuListener);
			exit.addActionListener(menuListener);
			save.addActionListener(menuListener);
			load.addActionListener(menuListener);
			controls.addActionListener(menuListener);
			respawn.addActionListener(menuListener);
			
		JMenu travel = new JMenu("Travel");
			
			travel.add(dung1);
				dung1.add(d1f1);
				dung1.add(d1f2);
				dung1.add(d1f3);
			travel.add(dung2);
				dung2.add(d2f1);
				dung2.add(d2f2);
				dung2.add(d2f3);
			travel.add(dung3);
				dung3.add(d3f1);
				dung3.add(d3f2);
				dung3.add(d3f3);
			
		JMenu help = new JMenu("Help");
			
			help.add(controls);
			
			window.setJMenuBar(menuBar);
			
			game.add(save);
			game.add(load);
			game.add(respawn);
			game.add(exit);
			
			menuBar.add(game);
			menuBar.add(travel);
			menuBar.add(help);
			window.add(menuBar);
		//end menu bar********
		
		//adding monsters***
			
		monArray.add(jt);
			monsterLbl.add(makeMob(monArray.get(0)));
			monsterHpBars.add(makeHpBar(monArray.get(0)));
		
		monArray.add(new Monster((byte) 2, "Ryan"));
			monsterLbl.add(makeMob(monArray.get(1)));
			monsterHpBars.add(makeHpBar(monArray.get(1)));
		
		monArray.add(new Monster((byte) 3, "Rachel"));
			monsterLbl.add(makeMob(monArray.get(2)));
			monsterHpBars.add(makeHpBar(monArray.get(2)));
			
			
			
			
			
			
			
			
			
			for (int i = 0; i < monsterLbl.size(); i++) {
				
				//monsterLbl.add(makeMob(monArray.get(i)));
				//monsterHpBars.add(makeHpBar(monArray.get(i)));
				
				monsterHpBars.get(i).setSize(64, 5);
				monsterLbl.get(i).setSize(64,64);
				
				panel.add(monsterHpBars.get(i));
				panel.add(monsterLbl.get(i));
				monsterLbl.get(i).setLocation((int)monArray.get(i).getXpos(), (int)monArray.get(i).getYpos());//change monsterLbl.get(0) to monsterLbl.get(0)
				monsterLbl.get(i).setIcon(new ImageIcon("src/sprites/DemonD1.png"));
				
			}
			//end adding monsters***
			
			//adding player***
			playerLbl.add(makeMob(rocco));
			
			
			
			playerLbl.get(0).setIcon(rocco.getImageLeft());
			
			panel.add(playerLbl.get(0));
			
			panel.add(roccohp);
			
			window.setVisible(true);
			//end adding player***
			
	}
	
	public void moveAndAnimate(){
		
		if(input != null){
			if(input.right.isPressed()){
				rocco.moveRight();
				rocco.setDirection("right");
				if(rocco.getAnimate()>3){
					playerLbl.get(0).setIcon(rocco.getImageRight());
					rocco.setAnimate(0);
				}
				else
					rocco.setAnimate(rocco.getAnimate()+1);
			}
			else if(input.left.isPressed()){
				rocco.moveLeft();
				rocco.setDirection("left");
				if(rocco.getAnimate()>3){
					playerLbl.get(0).setIcon(rocco.getImageLeft());
					rocco.setAnimate(0);
				}
				else
					rocco.setAnimate(rocco.getAnimate()+1);
			}
			else if(input.down.isPressed()){
				rocco.moveDown();
				rocco.setDirection("down");
			if(rocco.getAnimate()>3){
				playerLbl.get(0).setIcon(rocco.getImageDown());
				rocco.setAnimate(0);
			}
			else
				rocco.setAnimate(rocco.getAnimate()+1);
			}
			else if(input.up.isPressed()){
				rocco.moveUp();
				rocco.setDirection("up");
				if(rocco.getAnimate()>3){
					playerLbl.get(0).setIcon(rocco.getImageUp());
					rocco.setAnimate(0);
				}
				else
					rocco.setAnimate(rocco.getAnimate()+1);
			}
			else if(input.E.isPressed() ){
				
				if(rocco.getAnimate()>3){
					
					if(rocco.getDirection() == "down"){
						playerLbl.get(0).setIcon(rocco.getImageAttackD());
						rocco.setAnimate(0);
						}
					else if(rocco.getDirection() == "up"){
						playerLbl.get(0).setIcon(rocco.getImageAttackU());
						rocco.setAnimate(0);
					}
					
					else if(rocco.getDirection() == "right"){
						playerLbl.get(0).setIcon(rocco.getImageAttackR());
						rocco.setAnimate(0);
					}
					
					else{
						playerLbl.get(0).setIcon(rocco.getImageAttackL());
						rocco.setAnimate(0);
					}//default to left
						
				}
				else
					rocco.setAnimate(rocco.getAnimate()+1);
				
			for (int i = 0; i < monArray.size(); i++) {
				
			
				if(rocco.canAttack(monArray.get(i))){//need loop
					
					
					
					monsterHpBars.get(i).setValue((int)(monArray.get(i).getHitpoints()*100/10));
					monsterLbl.get(i).setToolTipText("hp: " + monArray.get(i).getHitpoints() + " atk: " + monArray.get(i).getAttack() + " str: " + monArray.get(i).getStrength() + " def: " + monArray.get(i).getDefense());
					
					//this if statement makes sure youre facing your target 
					if(rocco.getDirection() == "right" && monArray.get(i).getXpos() >= rocco.getXpos()){
						rocco.attack(monArray.get(i));
						rocco.setLastAttack(0);
					}
					else if(rocco.getDirection() == "left" && monArray.get(i).getXpos()<= rocco.getXpos()){
						rocco.attack(monArray.get(i));
						rocco.setLastAttack(0);
					}
					else if(rocco.getDirection() == "up" && monArray.get(i).getYpos() <= rocco.getYpos()){
						rocco.attack(monArray.get(i));
						rocco.setLastAttack(0);
					}
					else if(rocco.getDirection() == "down" && monArray.get(i).getYpos() >= monArray.get(i).getYpos()){
						rocco.attack(monArray.get(i));
						rocco.setLastAttack(0);
					}
					
					
				}
				}//end for
			}
			else{
				
				if(rocco.getDirection() == "up"){
					playerLbl.get(0).setIcon(new ImageIcon("src/sprites/Up1.png"));
				}
				
				else if(rocco.getDirection() == "down"){
					playerLbl.get(0).setIcon(new ImageIcon("src/sprites/Down1.png"));
				}
				
				else if(rocco.getDirection() == "left"){
					playerLbl.get(0).setIcon(new ImageIcon("src/sprites/Left1.png"));
				}
				
				else if(rocco.getDirection() == "right"){
					playerLbl.get(0).setIcon(new ImageIcon("src/sprites/Right1.png"));
				}
				
			}
		}
		
		rocco.setLastAttack(rocco.getLastAttack()+1);
		
	}
	
	public void monsterActions(){
		
		for (int i = 0; i < monArray.size(); i++) {
			
			monsterLbl.get(i).setLocation((int)monArray.get(i).getXpos(), (int)monArray.get(i).getYpos());
			playerLbl.get(0).setLocation((int)rocco.getXpos(),(int)rocco.getYpos());
			roccohp.setLocation((int)rocco.getXpos(), (int)rocco.getYpos()-10);
			monsterHpBars.get(i).setLocation((int)monArray.get(i).getXpos(), (int) monArray.get(i).getYpos()-10);
			
			if(monArray.get(i).canAttack(rocco)){//monsters attacking player
				
				monArray.get(i).attack(rocco);
				monArray.get(i).setLastAttack(0);
				roccohp.setValue((int)(rocco.getHitpoints()*100/10));
				monsterLbl.get(i).setToolTipText("hp: " + monArray.get(i).getHitpoints() + " atk: " + monArray.get(i).getAttack() + " str: " + monArray.get(i).getStrength() + " def: " + monArray.get(i).getDefense());
			}
			else
				monArray.get(i).setLastAttack(monArray.get(i).getLastAttack()+1);
			if(!(monArray.get(i).isAlive())){
					window.remove(monsterLbl.get(i));
					window.remove(monsterHpBars.get(i));//hp bar array
			}
			else 
				monArray.get(i).act(rocco);
			if(!(rocco.isAlive())){
				playerLbl.get(0).setIcon(new ImageIcon("src/sprites/Dead.png"));
				running = false;
			}
			}//end for
		
	}
	
	public void run(){
	
	if(firstTime){
		this.setupFrame();
		firstTime = false;
	}
	
	
		while(running) {
			
			this.moveAndAnimate();
			
			
			
			this.monsterActions();
			
			playerLbl.get(0).setToolTipText("hp: " + rocco.getHitpoints() + " atk: " + rocco.getAttack() + " str: " + rocco.getStrength() + " def: " + rocco.getDefense());
			monsterLbl.get(1).setLocation((int)monArray.get(1).getXpos(), (int)monArray.get(1).getYpos());

			try {//need a better way to manage fps use system time
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		
		
	}
			
	public void addMonster(Monster m){
		
		monArray.add(m);
		
	}
	
	public void addPlayer(Player p){
		
		JLabel lbl = new JLabel();
		lbl.setLocation((int)p.getXpos(),(int)p.getYpos());
		lbl.setSize(20, 20);
		playArray.add(p);
		playerLbl.add(lbl);
		
	}
			
	
	public JLabel makeMob(Mob m){//returns a label with the loc of the given mob and creates the tool tip
		
		JLabel lbl = new JLabel();
		lbl.setToolTipText("hp: " + m.getHitpoints() + " atk: " + m.getAttack() + " str: " + m.getStrength() + " def: " + m.getDefense());
		lbl.setForeground(Color.YELLOW);
		lbl.setLocation((int)m.getXpos(), (int)m.getYpos());		
		lbl.setSize(30, 30);
		lbl.setLocation((int)m.getXpos(),(int)m.getYpos());
		
		return lbl;
	}
	
	public JFrame makeWindow(){
		
		JFrame window = new JFrame("2D RPG");
		
		window.setPreferredSize(new Dimension(1600,850));
		window.setSize(new Dimension(1600,850));//setting up the window
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.GREEN);	
		window.pack();
		
		return window;
		
	}
	
	public JProgressBar makeHpBar(Mob m){
		
		JProgressBar prg = new JProgressBar(0,100);
		prg.setVisible(true);
		prg.setPreferredSize(new Dimension(18, 4));
		prg.setValue(100);
		prg.setStringPainted(true);
		prg.setBackground(Color.RED);
		prg.setForeground(Color.GREEN);
		return prg;
		
	}
	
	
	
	
}
