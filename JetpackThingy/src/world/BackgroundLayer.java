package world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.game.Drawing;
import engine.game.GameContainer;
import engine.io.Logger;
import engine.math.Vector2;
import engine.scenes.SceneManager;

public class BackgroundLayer {
	
	public String prefix = "BackgroundLayer";
	
	public BackgroundElement start;
	public Drawing d;
	public int backgroundsSize;
	
	public Vector2 imageSize;
	private float maxSpace;
	private BufferedImage images[];
	
	public float depth;
	
	public BackgroundLayer(Drawing d, BufferedImage images[], int depth, int depthSize) {
		this.images = images;
		this.imageSize = new Vector2(this.images[0].getWidth(), this.images[0].getHeight());
		this.d = d;
		
		this.depth = (float)(depth+1) / (depthSize+1);

	}
	
	public void calcSpace() {
		this.backgroundsSize = (int)Math.ceil(GameContainer.windowSize.x / imageSize.x / SceneManager.activeScene.defaultCamera.zoom)+3;
		Logger.println(prefix, "Generated BackgroundLayer with size of " + this.backgroundsSize, 1);
		start = new BackgroundElement(this, -this.backgroundsSize / 2 * this.imageSize.x, this.backgroundsSize-1);
		
		this.maxSpace = GameContainer.windowSize.x + this.imageSize.x/2;
		this.maxSpace /= imageSize.x;
		this.maxSpace = (float) Math.ceil(maxSpace);
		this.maxSpace *= imageSize.x;
	}
	
	public BufferedImage getNewImage() {
		/*int imagesCount = this.images.length;
		float randomNumber = (float) Math.random();
		randomNumber *= imagesCount;
		System.out.println(imagesCount);
		return this.images[(int) randomNumber];*/
		
		return this.images[0];
	}
	
	public void update() {
		System.out.println(this.depth);
		this.start.move((float)GameContainer.dt*1000 * this.depth);
	}
	
	public void render() {
		this.start.render();
	}
}