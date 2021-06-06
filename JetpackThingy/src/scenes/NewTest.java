package scenes;

import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import tools.worldlayers.MovingData;
import tools.worldlayers.MovingLayer;
import tools.worldlayers.TestData;
import world.background.ParalaxBackground;

public class NewTest extends Scene {

	public NewTest() {
		super("NewTest");
	}

	@Override
	public void instanceGameObjects() {
		GameObject movingArrayTest = new GameObject(new Vector2(0), true);
		
		ParalaxBackground background = new ParalaxBackground();
		
		
		movingArrayTest.addComponent(background);
		
		/*movingArrayTest.addComponent(new GameBehaviour() {
			public MovingLayer ml = new MovingLayer(lol, new Vector2(100, 300), -250, 1);
			
			public void start() {
				lol.parent = ml.start;
				this.ml.add(5);
			}
			
			public void update() {
				ml.update();
			}
			
			public void render() {
				ml.render();
			}
		});*/
		this.addGameObject(movingArrayTest);
	}

}
