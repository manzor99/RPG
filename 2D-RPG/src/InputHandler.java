import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class InputHandler implements KeyListener {

	public InputHandler(JFrame frame){
		
		frame.addKeyListener(this);
		
	}
	
	public class Key{
		
		private boolean pressed = false;
		public void toggle(boolean isPressed){
			
			pressed = isPressed;
			
		}
		
		public boolean isPressed(){
			
			return pressed;
			
		}
	}//end key
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key R = new Key();
	public Key E = new Key();
	
	public void keyPressed(KeyEvent e) {
		
		toggleKey(e.getKeyCode(), true);
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		toggleKey(e.getKeyCode(), false);
		
	}

	
	public void keyTyped(KeyEvent e) {
		
		
		
	}

	public void toggleKey(int keyCode, boolean isPressed){
		
		if(keyCode == KeyEvent.VK_W){
			up.toggle(isPressed);
		}
		
		if(keyCode == KeyEvent.VK_A){
			left.toggle(isPressed);
		}
		
		if(keyCode == KeyEvent.VK_D){
			right.toggle(isPressed);
		}
		
		if(keyCode == KeyEvent.VK_S){
			down.toggle(isPressed);
		}
		
		if(keyCode == KeyEvent.VK_E){
			
			E.toggle(isPressed);
			
		}
		
		if(keyCode == KeyEvent.VK_R){
			
			E.toggle(isPressed);
			
		}
		
	}
	
}