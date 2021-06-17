package world.background;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.io.LocalFileLoader;

public class Background {
	
	public BufferedImage[] images;
	public Color backgroundColor;
	
	public Background(String backgroundName, Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		
		//File directory = new File("/backgrounds/" + backgroundName);
		File directory = new File(getClass().getResource("/backgrounds/dune").getPath());
		int size = directory.list().length;
		
		images = new BufferedImage[size];
		for (int i = 0; i < size; i++) {
			try {
				String loadingPath = "/backgrounds/" + backgroundName + "/l" + i + ".png";
				
				System.out.println(loadingPath);
				
				 this.images[i] = ImageIO.read(getClass().getResourceAsStream(loadingPath));
				 this.images[i] = LocalFileLoader.toCompatibleImage(this.images[i]);
			} catch (IOException e) {
	  			System.err.println("Could not load '/" + backgroundName + "' Background");
			}
		}
	}
}