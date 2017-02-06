import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenuBarListener extends Game implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Run.game.save){//make this work without the game being static
			try{
				
			    PrintWriter writer = new PrintWriter("src/Player.txt");
			    writer.println(Run.game.rocco.getId());
			    writer.println(Run.game.rocco.getName());
			    writer.println(Run.game.rocco.getHitpoints());
			    writer.println(Run.game.rocco.maxHitpoints);
			    writer.println(Run.game.rocco.getHitpointsXp());
			    writer.println(Run.game.rocco.getHpXpTillLv());
			    writer.println(Run.game.rocco.attack);
			    writer.println(Run.game.rocco.getAttackXp());
			    writer.println(Run.game.rocco.getAtkXpTillLv());
			    writer.println(Run.game.rocco.getStrength());
			    writer.println(Run.game.rocco.getStrengthXp());
			    writer.println(Run.game.rocco.getStrXpTillLv());
			    writer.println(Run.game.rocco.getDefense());
			    writer.println(Run.game.rocco.getDefenseXp());
			    writer.println(Run.game.rocco.getDefXpTillLv());
			    writer.println((int)Run.game.rocco.getXpos());
			    writer.println((int)Run.game.rocco.getYpos());

			    writer.close();
			    System.out.println("File saved!");
			    
			} catch (IOException e1) {
			   System.out.println("Failed to save file.");
			}
			
		}
		else if(e.getSource() == Run.game.exit){
			
				try{
				
					PrintWriter writer = new PrintWriter("src/Player.txt");
					writer.println(Run.game.rocco.getId());
					writer.println(Run.game.rocco.getName());
					writer.println(Run.game.rocco.getHitpoints());
					writer.println(Run.game.rocco.maxHitpoints);
					writer.println(Run.game.rocco.getHitpointsXp());
					writer.println(Run.game.rocco.getHpXpTillLv());
					writer.println(Run.game.rocco.attack);
					writer.println(Run.game.rocco.getAttackXp());
					writer.println(Run.game.rocco.getAtkXpTillLv());
					writer.println(Run.game.rocco.getStrength());
					writer.println(Run.game.rocco.getStrengthXp());
					writer.println(Run.game.rocco.getStrXpTillLv());
					writer.println(Run.game.rocco.getDefense());
					writer.println(Run.game.rocco.getDefenseXp());
					writer.println(Run.game.rocco.getDefXpTillLv());
					writer.println((int)Run.game.rocco.getXpos());
					writer.println((int)Run.game.rocco.getYpos());
					
					writer.close();
					System.out.println("File saved!");
			    
			} catch (IOException e1) {
			   System.out.println("Failed to save file.");
			}
			
				System.exit(0);
				
		}
		else if (e.getSource() == Run.game.load){
			try {
				Scanner input = new Scanner(new File("src/Player.txt"));
				
				Run.game.rocco.id = (byte)Integer.parseInt(input.next());//why can i access this?? its protected
				Run.game.rocco.name = input.next();
				Run.game.rocco.setHitpoints((byte)Integer.parseInt(input.next()));
				Run.game.rocco.maxHitpoints = (byte) Integer.parseInt(input.next());
				Run.game.rocco.setHitpointsXp(Integer.parseInt(input.next()));
				Run.game.rocco.setHpXpTillLv(Integer.parseInt(input.next()));
				Run.game.rocco.setAttack((byte) Integer.parseInt(input.next()));
				Run.game.rocco.setAttackXp(Integer.parseInt(input.next()));
				Run.game.rocco.setAtkXpTillLv(Integer.parseInt(input.next()));
				Run.game.rocco.setStrength((byte) Integer.parseInt(input.next()));
				Run.game.rocco.setStrengthXp(Integer.parseInt(input.next()));
				Run.game.rocco.setStrXpTillLv(Integer.parseInt(input.next()));
				Run.game.rocco.setDefense((byte) Integer.parseInt(input.next()));
				Run.game.rocco.setDefenseXp(Integer.parseInt(input.next()));
				Run.game.rocco.setDefXpTillLv(Integer.parseInt(input.next()));
				Run.game.rocco.setXpos(Integer.parseInt(input.next()));
				Run.game.rocco.setYpos(Integer.parseInt(input.next()));
				
				input.close();
				
			} catch (FileNotFoundException e1) {
				System.out.println("Could not load game.");
			}
			System.out.println("Game Loaded Successfully!!");
		}
	
		else if(e.getSource() == Run.game.controls){
			System.out.println("controls");
		}
		
		else if(e.getSource() == Run.game.respawn){
			Run.game.rocco.setHitpoints((byte) rocco.maxHitpoints);
			Run.game.rocco.setXpos(150);
			Run.game.rocco.setYpos(100);
			Run.game.running = true;//doesnt work if the player is dead
		}
	}
	

	
}
