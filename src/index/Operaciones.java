package index;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Operaciones {
	
	public ImageIcon resized_img(ImageIcon img, int width, int height) {
		Image image = img.getImage(); // transform it 
		Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon newimg2 = new ImageIcon(newimg);  // transform it back
		
		return newimg2;
	}

}
