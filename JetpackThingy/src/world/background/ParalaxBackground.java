package world.background;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.game.Window;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.input.listener.ViewListener;
import engine.io.LocalFileLoader;
import engine.math.Vector2;
import tools.worldlayers.MovingLayer;

public class ParalaxBackground extends GameBehaviour implements ViewListener {
	
	private BufferedImage images[];
	
	public MovingLayer bgl[];
	public int size;
	public Vector2 imageSize;
	
	
	public ParalaxBackground(String path, int size) {
		this.size = size;
		
		images = new BufferedImage[7];
		for (int i = 0; i < 6; i++) {
			try {
				String loadingPath = "/backgrounds/" + path + "/" + path + "" + i + ".png";
				
				boolean lol = new File(loadingPath).exists();
				
				
				 this.images[i] = ImageIO.read(getClass().getResourceAsStream(loadingPath));
				 this.images[i] = LocalFileLoader.toCompatibleImage(this.images[i]);
			} catch (IOException e) {
	  			System.err.println("Could not load the sprite with Path: " + path);
			}
		}
		
		Window.viewListener.add(this);
	}
	
	public void start() {
		bgl = new MovingLayer[size];
		
		this.imageSize = new Vector2(this.images[0].getWidth(), this.images[0].getHeight());
		float aspectRatio = this.imageSize.x / this.imageSize.y;
		this.imageSize.y *= 4;
		this.imageSize.x = this.imageSize.y * aspectRatio;
		
		for (int i = 0; i < size; i++) {
			BackgroundData startingData = new BackgroundData(images[i]);
			bgl[i] = new MovingLayer(startingData, imageSize, -1000, ((float)i+1) / (1+size));
			bgl[i].addInstant(3);
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

	@Override
	public void rezise() {
		System.out.println("Rezise");
		for (int i = 0; i < this.images.length; i++) {
			//this.images[i] = this.images[i].getScaledInstance((int)this.bgl[i].elementBounds.x+2, (int)this.bgl[i].elementBounds.y+2, Image.SCALE_FAST);
		}
	}
}