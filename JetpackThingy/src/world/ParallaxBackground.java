package world;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.game.GameContainer;
import engine.game.Window;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.io.LocalFileLoader;
import engine.math.Vector2;

public class ParallaxBackground extends GameBehaviour {
	
	private BufferedImage images[];
	
	private float offsetX[];
	
	private float aimX;
	
	public ParallaxBackground(String path, int size) {
		
		images = new BufferedImage[size];
		offsetX = new float[size];
		
		for (int i = 0; i < size; i++) {
			try {
				String loadingPath = path + "/l" + i + ".png";
				 this.images[i] = ImageIO.read(getClass().getResourceAsStream(loadingPath));
			} catch (IOException e) {
	  			System.err.println("Could not load the sprite with Path: " + path);
			}
		}
	}
	
	public void update() {
		
		for (int i = 0; i < offsetX.length; i++) {
			offsetX[i] = aimX * (((float)i+1)/offsetX.length);
		}
		
		aimX = GameContainer.input.getMousePos(true).x;
	} 
	
	public void render() {
		for (int i = 0; i < images.length; i++) {
			this.d.drawImage(images[i], new Vector2(-384*3 + offsetX[i], -216*3), new Vector2(384*6, 216*6));
		}
	}

}