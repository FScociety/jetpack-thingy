package world;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;

public class ParalaxBackground2 extends GameBehaviour {
	
	private BufferedImage images[];
	
	public BackgroundLayer bgl[];
	public int size;
	public Vector2 imageSize;
	
	
	public ParalaxBackground2(String path, int size, Vector2 imageSize) {
		this.size = size;
		this.imageSize = imageSize;
		
		
		images = new BufferedImage[5];
		for (int i = 0; i < 4; i++) {
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
			bgl[i] = new BackgroundLayer(imageSize.x);
			bgl[i].start();
		}
	}
	
	public void update() {
		for (int i = 0; i < size; i++) {
			bgl[i].update();
		}
	}
	
	public void render() {
		for (int i = 0; i < bgl.length; i++) {
			//System.out.println(bgl[i].backgrounds.size());
			
			for (int j = 0; j < bgl[i].backgrounds.size(); j++) {
				float x = bgl[i].backgrounds.get(j);
				
				System.out.println(x);
				
				//this.d.setColor(new Color(172, 255, 255));
				//this.d.fillRect(new Vector2(x - ((float)bgl[i].backgrounds.size())/2*imageSize, -imageSize/2), new Vector2(imageSize+1));
				this.d.drawImage(images[i],new Vector2(x - (bgl[i].backgrounds.size())/2*imageSize.x, -imageSize.y/2), new Vector2(imageSize.x+1, imageSize.y+1));
			}
		}
	}

}
