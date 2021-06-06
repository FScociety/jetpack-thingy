package world.background;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.game.GameContainer;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.io.Logger;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import tools.worldlayers.MovingLayer;

public class ParalaxBackground extends GameBehaviour {
	
	private BufferedImage images[];
	
	public MovingLayer bgl[];
	public int size;
	public Vector2 imageSize;
	
	
	public ParalaxBackground(String path, int size) {
		this.size = size;
		
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
		bgl = new MovingLayer[size];
		
		this.imageSize = new Vector2(this.images[0].getWidth(), this.images[0].getHeight());
		float aspectRatio = this.imageSize.x / this.imageSize.y;
		this.imageSize.y = GameContainer.windowSize.y;
		this.imageSize.x = this.imageSize.y * aspectRatio;
		
		System.out.println(this.imageSize);
		
		for (int i = 0; i < size; i++) {
			
			BackgroundData startingData = new BackgroundData(images[i]);
			bgl[i] = new MovingLayer(startingData, imageSize, -250, ((float)i+1) / (1+size));
			bgl[i].add(bgl[i].getAmoutOverScreen());
			startingData.parent = bgl[i].start;
		}
	}
	
	public void update() {
		for (int i = 0; i < this.bgl.length; i++) {
			bgl[i].update();
		}
	}
	
	public void render() {
		for (int i = 0; i < this.bgl.length; i++) {
			bgl[i].render();
		}
	}
}