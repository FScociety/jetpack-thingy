package world;

import java.util.ArrayList;

import engine.game.Drawing;
import engine.game.GameContainer;
import engine.io.Logger;
import engine.scenes.SceneManager;

public class BackgroundLayer {
	
	public String prefix = "BackgroundLayer";
	
	public BackgroundElement start;
	public Drawing d;
	public int backgroundsSize;
	
	private float imageSize;
	private float maxSpace;
	
	public BackgroundLayer(Drawing d, float imageSize) {
		this.imageSize = imageSize;
		this.d = d;
	}
	
	public void calcSpace() {
		this.backgroundsSize = (int)Math.ceil(GameContainer.windowSize.x / imageSize / SceneManager.activeScene.defaultCamera.zoom)+3;
		Logger.println(prefix, "Generated BackgroundLayer with size of " + this.backgroundsSize, 1);
		start = new BackgroundElement(this, this.d, -this.backgroundsSize / 2 * this.imageSize, (int) this.imageSize, this.backgroundsSize-1);
		
		this.maxSpace = GameContainer.windowSize.x + this.imageSize/2;
		this.maxSpace /= imageSize;
		this.maxSpace = (float) Math.ceil(maxSpace);
		this.maxSpace *= imageSize;
	}
	
	public void update() {
		this.start.move((float)GameContainer.dt*1000);
	}
	
	public void render() {
		this.start.render();
	}
}