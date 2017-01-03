import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class Background extends JComponent {

	private Image image;
	
	public Background(Image image){
		
		this.image = image;
		
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		
	}
	
}
