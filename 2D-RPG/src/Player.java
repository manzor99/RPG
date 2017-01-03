import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Mob {
	
	private int hitpointsXp, strengthXp, attackXp, defenseXp;
	private int hpXpTillLv = 185, strXpTillLv = 83, atkXpTillLv = 83, defXpTillLv = 83;
	
	public Player(byte id, String name){
		
		super(id, name);
		maxHitpoints = 10;
		xpos = 150;
		ypos = 100;
		xvel = 1;
		yvel = 1;
		retaliate = false;
		
	}
	
	public Player(byte id, String name, byte hitpointsXp, byte hitpoints, byte strengthXp, byte attackXp, byte defenseXp){
		
		super(id, name, hitpoints);
		this.hitpointsXp = hitpointsXp;
		this.strengthXp = strengthXp;
		this.attackXp = attackXp;
		this.defenseXp = defenseXp;
		retaliate = false;
		
	}
		
	public int getHpXpTillLv() {
		return hpXpTillLv;
	}
	
	public int getStrXpTillLv() {
		return strXpTillLv;
	}
	
	public int getAtkXpTillLv() {
		return atkXpTillLv;
	}
	
	public int getDefXpTillLv() {
		return defXpTillLv;
	}
	
	public void attack(Mob m){
		
		m.getAttacked(this);
		this.attackXp += this.attack * 10;
		this.strengthXp += this.attack * 10;
		this.hpXpTillLv += this.attack*10;
		
		if(this.attackXp >= this.atkXpTillLv){
			this.attack+=1;
			this.atkXpTillLv *= 1.1;
			this.attackXp -= this.atkXpTillLv;
		}
		
		if(this.hitpointsXp >= this.hpXpTillLv){
			this.hitpoints+=1;
			this.maxHitpoints+=1;//need to add regen and lifesteal maybe??
			this.hpXpTillLv *= 1.1;
			this.hitpointsXp -= this.hpXpTillLv;
		}
		
		if(this.strengthXp >= this.strXpTillLv){
			this.strength+=1;
			this.strXpTillLv *= 1.1;
			this.strengthXp -= this.strXpTillLv;
		}
		
	}
	
	private void setId(byte id) {
		this.id = id;

	}
	
	public void setHpXpTillLv(int hpXpTillLv) {
		this.hpXpTillLv = hpXpTillLv;
	}
	
	public void setAtkXpTillLv(int atkXpTillLv) {
		this.atkXpTillLv = atkXpTillLv;
	}
	
	public void setStrXpTillLv(int strXpTillLv) {
		this.strXpTillLv = strXpTillLv;
	}
	
	public void setDefXpTillLv(int defXpTillLv) {
		this.defXpTillLv = defXpTillLv;
	}
	
	public void setHitpointsXp(int hitpointsXp) {
		this.hitpointsXp = hitpointsXp;
	}
	
	public void setStrengthXp(int strengthXp) {
		this.strengthXp = strengthXp;
	}
	
	public void setAttackXp(int attackXp) {
		this.attackXp = attackXp;
	}
	
	public void setDefenseXp(int defenseXp) {
		this.defenseXp = defenseXp;
	}
	
	public int getHitpointsXp() {
		return hitpointsXp;
	}
	
	public int getStrengthXp() {
		return strengthXp;
	}
	
	public int getAttackXp() {
		return attackXp;
	}
	
	public int getDefenseXp() {
		return defenseXp;
	}
	
	public byte getRange() {
		
		return this.range;

	}
	
	public ImageIcon getImageAttackL(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackL1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackL2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackL3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackL4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackL5.png");
		case 5:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Left1.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Left1.png");
		}
		
	}
	
	public ImageIcon getImageAttackR(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackR1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackR2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackR3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackR4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackR5.png");
		case 5:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Right1.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Right1.png");
		}
		
	}
	
	public ImageIcon getImageAttackU(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackU1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackU2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackU3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackU4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackU5.png");
		case 5:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Up1.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Up1.png");
		}
		
	}
	
	public ImageIcon getImageAttackD(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackD1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackD2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackD3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackD4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackD5.png");
		case 5:
			spriteCounter++;
			return new ImageIcon("src/sprites/AttackD6.png");
		case 6: 
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Down1.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Down1.png");
		}
		
		
	}
	
	public ImageIcon getImageDown(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/Down1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/Down2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/Down3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/Down4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/Down5.png");
		case 5:
			spriteCounter++;
			return new ImageIcon("src/sprites/Down6.png");
		case 6:
			spriteCounter++;
			return new ImageIcon("src/sprites/Down7.png");
		case 7:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Down8.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Down1.png");
		}
		
		
	}
	
	public ImageIcon getImageUp(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/Up1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/Up2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/Up3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/Up4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/Up5.png");
		case 5:
			spriteCounter++;
			return new ImageIcon("src/sprites/Up6.png");
		case 6:
			spriteCounter++;
			return new ImageIcon("src/sprites/Up7.png");
		case 7:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Up8.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Up1.png");
		}
		
		
	}
	
	public ImageIcon getImageRight(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/Right1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/Right2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/Right3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/Right4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/Right5.png");
		case 5:
			spriteCounter++;
			return new ImageIcon("src/sprites/Right6.png");
		case 6:
			spriteCounter++;
			return new ImageIcon("src/sprites/Right7.png");
		case 7:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Right8.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/Right1.png");
		}
		
		
	}
	
	public ImageIcon getImageLeft(){
		
		switch (this.spriteCounter) {
		case 0:
			spriteCounter++;
			return new ImageIcon("src/sprites/left1.png");
		case 1:
			spriteCounter++;
			return new ImageIcon("src/sprites/left2.png");
		case 2:
			spriteCounter++;
			return new ImageIcon("src/sprites/left3.png");
		case 3:
			spriteCounter++;
			return new ImageIcon("src/sprites/left4.png");
		case 4:
			spriteCounter++;
			return new ImageIcon("src/sprites/left5.png");
		case 5:
			spriteCounter++;
			return new ImageIcon("src/sprites/left6.png");
		case 6:
			spriteCounter++;
			return new ImageIcon("src/sprites/left7.png");
		case 7:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/left8.png");
		default:
			spriteCounter = 0;
			return new ImageIcon("src/sprites/left1.png");
		}
		
		
	}
	
	public byte getSpriteCounter(){
		
		return this.spriteCounter;
		
	}
		
}
