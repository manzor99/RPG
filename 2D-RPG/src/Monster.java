import javax.swing.ImageIcon;
import java.lang.Math;

public class Monster extends Mob{
	
	private static byte hitpoints;//byte holds 225
	private static byte strength;
	private static byte attack;
	private static byte defense;
	private static int xp;//how much xp it grants when killed
	private static byte id;
	private static String name;
	private static int agroRange = 125;
	private boolean hasTarget = false;//does the monster have a target?
	
	public Monster(byte id, String name, byte hitpoints, byte strength, byte attack, byte defense, int xp, int xpos, int ypos){//might need to fix this
		
		this(id, name);//calls the mob constructor
		this.xpos = xpos;
		this.ypos = ypos;
		this.strength = strength;
		this.attack = attack;
		this.defense = defense;
		this.xp = xp;
		retaliate = true;
		this.range = 30;
		this.atkSpeed = 270;
		this.alive = true;
		
	}
	
	public Monster(byte id, String name){
		
		super(id, name);
		this.hitpoints = 10;
		this.strength = 10;
		this.attack = 10;
		this.defense = 10;
		this.name = name;
		this.xpos = Math.random()*1500;
		this.ypos = Math.random()*750;
		retaliate = true;
		this.xvel = .5;
		this.yvel = .5;
		this.atkSpeed = 150;
		this.range = 50;
		
	}
	
	public ImageIcon getImageLeft(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonL1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonL1.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonL3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonL4.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/DemonL1.png");
		}
	}
	
	public ImageIcon getImageRight(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonR1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonR1.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonR3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonR4.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/DemonR1.png");
		}
	}
	
	public ImageIcon getImageUp(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonU1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonU1.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonU3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonU4.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/DemonU1.png");
		}
		
		
		
	}
	
	public ImageIcon getImageDown(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonD1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonD1.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonD3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/DemonD4.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/DemonD1.png");
		}
		
		
		
	}
	
	public void changeYvel(Mob m){//changed the Y velocity to catch the player
		
		if(m.getYpos()>this.getYpos())
			this.yvel = Math.abs(this.getYvel());			
		else
			this.yvel = Math.abs(this.getYvel()) * -1;
		
		
	}
	
	public void changeXvel(Mob m){//changed the X velocity to catch the player
				
		if(m.getXpos() + 20 >this.getXpos())
			this.setXvel(Math.abs(this.getXvel()));
		else
			this.setXvel(Math.abs(this.getXvel()) * -1);
			
			}
	
	public void Agro(Mob m){
		
		if(this.getDistance(m) <= agroRange){
			this.hasTarget = true;
			this.changeXvel(m);
			this.changeYvel(m);
			
		}
		else
			hasTarget = false;
		
	}
	
	public void act(Mob m){
		
		this.Agro(m);
		
		if(hasTarget){//&& this.getDistance(m)>= this.range
			
		this.xpos += this.xvel;
		this.ypos += this.yvel;
			
		}
	}

	public int getXp(){
		
		return this.xp;
		
	}
		
}
