package world;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.game.GameContainer;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;

public class ParalaxBackground extends GameBehaviour {
	
	private BufferedImage images[];
	
	public BackgroundLayer bgl[];
	public int size;
	public Vector2 imageSize;
	
	
	public ParalaxBackground(String path, int size, Vector2 imageSize) {
		this.size = size;
		this.imageSize = imageSize;
		
		
		images = new BufferedImage[7];
		for (int i = 0; i < 6; i++) {
			try {
				String loadingPath = path + "/l" + i + ".png";
				 this.images[i] = ImageIO.read(getClass().getResourceAsStream(loadingPath));
			} catch (IOException e) {
	  			System.err.println("Could not load the sprite with Path: " + path);
			}
		}
	}
	
	public void start() {
		bgl = new BackgroundLayer[size];
		
		for (int i = 0; i < size; i++) {
			BufferedImage[] testarray = {images[i]};
			bgl[i] = new BackgroundLayer(this.d, testarray, i, size);
			bgl[i].calcSpace();
		}
	}
	
	public void update() {
		for (int i = 0; i < size; i++) {
			bgl[i].update();
		}
	}
	
	public void render() {
		for (int i = 0; i < bgl.length; i++) {
			bgl[i].render();
			/*for (int j = 0; j < bgl[i].backgroundsSize; j++) {
				float x = bgl[i].backgrounds[j];
				
				this.d.setColor(Color.WHITE);
				this.d.drawRect(new Vector2(x, 0), new Vector2(384*2, 384*2));
				
				//this.d.drawImage(images[i], new Vector2(x - (bgl[i].backgrounds.size())/2*imageSize.x, -imageSize.y/2), new Vector2(imageSize.x+1, imageSize.y+1));
			}*/
		}
	}

}
