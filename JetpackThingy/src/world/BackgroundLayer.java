package world;

import java.util.ArrayList;

import engine.game.GameContainer;
import engine.scenes.SceneManager;

public class BackgroundLayer {
	
	public ArrayList<Float> backgrounds = new ArrayList<>();
	
	public float imageSize;
	
	public BackgroundLayer(float imageSize) {
		this.imageSize = imageSize;
	}
	
	public void start() {
		int backgroundCount = (int)Math.ceil(GameContainer.windowSize.x / imageSize / SceneManager.activeScene.defaultCamera.zoom);
		
//		System.out.println(backgroundCount + " " + backgrounds.size());
		
		if (backgrounds.size() < backgroundCount) {
			for (int i = backgrounds.size(); i < backgroundCount; i++) {
				backgrounds.add(i * imageSize);
			}
		} else if (backgroundCount < backgrounds.size()) {
			for (int i = backgroundCount; i < backgrounds.size(); i++) {
				backgrounds.remove(i * imageSize);
			}
		}
	}
	
	public void update() {
		start();
		
		/*for (int i = 0; i < this.backgrounds.size(); i++) {
			backgrounds.set(i, (float) (backgrounds.get(i)-GameContainer.dt*1000));
		}*/
	}
}