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
		start = new BackgroundElement(this.d, -this.backgroundsSize / 2 * this.imageSize, (int) this.imageSize, this.backgroundsSize-1);
		
		this.maxSpace = GameContainer.windowSize.x + this.imageSize/2;
		this.maxSpace /= imageSize;
		this.maxSpace = (float) Math.ceil(maxSpace);
		this.maxSpace *= imageSize;
	}
	
	public void update() {
		this.start.move((float)GameContainer.dt);
		
		/*if (backgrounds.size() < backgroundCount) {
			for (int i = backgrounds.size(); i < backgroundCount; i++) {
				backgrounds.add(i * imageSize);
			}
		} else if (backgroundCount < backgrounds.size()) {
			for (int i = backgroundCount; i < backgrounds.size(); i++) {
				backgrounds.remove(i * imageSize);
			}
		}
		
		for (int i = 0; i < backgrounds.size(); i++) {
			this.backgrounds.set(i, (float) (this.backgrounds.get(i) - GameContainer.dt * 1000));
		}*/
	}
	
	public void render() {
		this.start.render();
	}
}