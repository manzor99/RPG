import java.io.File;

public class Test {

	public static void main(String[] args) {
		
		int dmg;
		double atkProb, strMult, defMult;
		
		
		strMult = .9/(1 + Math.exp(-0.1*(1 - 40)))+.1;//can make the rng do full dmg (rng is from 0-10 so at 99 str you'd hit up to 10)
			System.out.println(strMult);
		defMult = 1.003 - (.4/(1 + Math.pow(Math.E, -0.1*(1 - 50))));//can reduce dmg by up to half at lv 99
			System.out.println(defMult);
		double rng = Math.random();
			System.out.println(rng);
		dmg = (int) Math.ceil((rng*10*strMult));
			System.out.println(dmg);
		
		
	}
	
	
}
