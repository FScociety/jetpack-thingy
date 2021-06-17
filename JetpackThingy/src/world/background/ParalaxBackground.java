package world.background;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.game.Window;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.input.listener.ViewListener;
import engine.io.LocalFileLoader;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import tools.worldlayers.MovingLayer;

public class ParalaxBackground extends GameBehaviour implements ViewListener {
	
	public Background[] backgrounds;
	private Background activeBackground;
 	public MovingLayer bgl[];
	public int size;
	public Vector2 imageSize;
	
	public ParalaxBackground(int size) {
		this.size = size;
		
		Background backgrounds[];
		
		Window.viewListener.add(this);
	}
	
	public void start() {
		bgl = new MovingLayer[size];
		
		backgrounds = new Background[5];
		backgrounds[0] = new Background("dune", new Color(205, 227, 255));
		
		this.setBackground(backgrounds[0]);
	
	}
	
	public void setBackground(Background b) {
		this.imageSize = new Vector2(b.images[0].getWidth(), b.images[0].getHeight());
		float aspectRatio = this.imageSize.x / this.imageSize.y;
		this.imageSize.y *= 13;
		this.imageSize.x = this.imageSize.y * aspectRatio;
		
		for (int i = 0; i < size; i++) {
			BackgroundData startingData = new BackgroundData(b.images[i]);
			bgl[i] = new MovingLayer(startingData, imageSize, -1000, ((float)i+1) / (1+size));
			bgl[i].addInstant(2);
			startingData.parent = bgl[i].start;
		}
		
		this.activeBackground = b;
		SceneManager.activeScene.backgroundC = this.activeBackground.backgroundColor;
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
		for (int i = 0; i < this.activeBackground.images.length; i++) {
			//this.images[i] = this.images[i].getScaledInstance((int)this.bgl[i].elementBounds.x+2, (int)this.bgl[i].elementBounds.y+2, Image.SCALE_FAST);
		}
	}
}