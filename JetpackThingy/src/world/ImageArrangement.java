package world;

import engine.game.GameContainer;
import engine.scenes.SceneManager;

public class ImageArrangement {
	
	private float imageSize;
	private float images;
	
	public ImageArrangement(float imageSize) {
		this.imageSize = imageSize;
	}
	
	public void update() {
		int backgroundCount = (int)Math.ceil(GameContainer.windowSize.x / imageSize / SceneManager.activeScene.defaultCamera.zoom);
		
		
	}
}