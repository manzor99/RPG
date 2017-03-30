import javax.swing.JLabel;
public class Mob {
	
	protected byte maxHitpoints, hitpoints;//maxhp, currenthp
	protected byte strength;//byte holds 225
	protected byte attack;
	protected byte defense;
	protected double xpos, ypos, xvel, yvel;
	protected byte id;
	protected byte range;
	protected String name;
	protected int atkSpeed;//how many miliseconds between attacks
	protected int lastAttack;//time since last attack
	protected boolean retaliate;//auto retaliate??
	protected byte spriteCounter = 0;
	protected int animate = 3;//makes it so it only animates every other tick
	protected String direction = "left";//what direction is the player facing? can only be up right down left.
	protected boolean alive = true; //is the mob alive??
	protected JLabel label;
	//make the label belong to the mob
	//make the progressbar belong to the mob********************************************
	
	public Mob(byte id, String name){//make changes to both constructors
		
		this.id = id;
		this.name = name;
		hitpoints = 10;
		strength = 1;
		attack = 1;
		defense = 1;
		range = 40;//change based on wepon
		atkSpeed = 100;
		lastAttack = atkSpeed;
		this.xpos = xpos;
		this.ypos = ypos;
		
	}
	
	public Mob(byte id, String name, byte hitpoints){

		this(id, name);
		this.hitpoints = hitpoints;
		
	}
	
	public boolean isAlive(){//calculates if the mob is alive
		
		if(this.getHitpoints()<= 0)
			return false;
		return true;
	}
	
	public void moveRight(){
		
		this.setXpos(this.getXpos()+this.getXvel());
		
	}
	
	public int getDistance(Mob m){
		
		double x = (this.getXpos() - m.getXpos());
		double y = (this.getYpos() - m.getYpos());
		double total = Math.sqrt((x*x) + (y*y));
		int d = (int)total;//make it work without variables
		return d;
		
	}
	
	public boolean canAttack(Mob m){
		
		if(this.getDistance(m)<= this.range && lastAttack >= atkSpeed && this.hitpoints > 0)
			return true;
		else
			return false;
	}
	
	public void moveLeft(){
		
		this.setXpos(this.getXpos()-this.getXvel());
		
	}
	
	public void moveUp(){
		
		this.setYpos(this.getYpos()-this.getYvel());
		
	}
	
	public void moveDown(){
		
		this.setYpos(this.getYpos()+this.getYvel());
		
	}
		
	public void getAttacked(Mob m){
		
		//this is getting attacked m is attacking

		if(m.canAttack(this)){//always hits 1 idk y
			int dmg;
			double atkProb, strMult, defMult;
			atkProb = 99;//(70/(1 + Math.pow(Math.E, (-0.1*(m.getAttack() - 50)))))+30;//number from 30-100 
			strMult = .9/(1 + Math.exp(-0.1*(m.getStrength() - 40)))+.1;//can make the rng do full dmg (rng is from 0-10 so at 99 str you'd hit up to 10)
			defMult = 1.003 - (.4/(1 + Math.pow(Math.E, -0.1*(this.getDefense() - 50))));//can reduce dmg by up to half at lv 99
			dmg = (int) (defMult*Math.ceil((Math.random()*10*strMult)));
			this.setHitpoints((byte) (this.getHitpoints() - dmg));//need to factor in attack
		}
			
		else
			System.out.println("Target out of range.");
		
	}
	
	public void attack(Mob m){
		
		m.getAttacked(this);
		
	}
	
	public void setHitpoints(byte hitpoints) {

		this.hitpoints = hitpoints;
	}
	
	public void setStrength(byte strength) {
		this.strength = strength;
	}
	
	public void setAttack(byte attack) {
		this.attack = attack;
	}
	
	public void setDefense(byte defense) {
		this.defense = defense;
	}
	
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	
	public void setXvel(double xvel){
		this.xvel = xvel;
	}
	
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
	public void setYvel(double yvel){
		this.yvel = yvel;
	}
	
	public void setAtkSpeed(int atkSpeed) {
		this.atkSpeed = atkSpeed;
	}
	
	public void setLastAttack(int lastAttack) {
		this.lastAttack = lastAttack;
	}
	
	public void setAnimate(int animate) {
		this.animate = animate;
	}
	
	public void setSpriteCounter(byte x){
		
		this.spriteCounter = x;
		
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public byte getHitpoints() {
		return hitpoints;
	}
	
	public byte getStrength() {
		return strength;
	}
	
	public byte getAttack() {
		return attack;
	}
	
	public byte getDefense() {
		return defense;
	}
	
	public byte getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}

	public double getXpos() {
		return this.xpos;
	}
	
	public double getYpos() {
		return this.ypos;
	}

	public double getYvel() {
		return this.yvel;
	}
	
	public double getXvel() {
		return this.xvel;
	}
	
	public int getAtkSpeed() {
		return atkSpeed;
	}
	
	public int getLastAttack() {
		return lastAttack;
	}
	
	public int getAnimate(){
		
		return this.animate;
		
	}
	
	public String getDirection() {
		return direction;
	}
}
