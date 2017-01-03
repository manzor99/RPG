import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends Dimension implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		
		this.width = MouseInfo.getPointerInfo().getLocation().x;
		this.height = MouseInfo.getPointerInfo().getLocation().y;
		
	}

	
	public void mouseEntered(MouseEvent e) {
		
		
	}

	
	public void mouseExited(MouseEvent e) {
		
		
	}

	
	public void mousePressed(MouseEvent e) {
		
		
	}

	
	public void mouseReleased(MouseEvent e) {
		
		
	}

	
	
}
