package scenes;

import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.builtin.ui.RectTransform;
import engine.math.Vector2;
import engine.scenes.Scene;

public class UITest extends Scene {

	public UITest() {
		super("UITest");
	}

	@Override
	public void instanceGameObjects() {
		GameObject child1 = new GameObject("boundsChil1", new Vector2(0, 0), this.canvasGameObject);
		RectTransform b = new RectTransform(new Vector2(-100, -100), new Vector2(100, 100));
		//RectTransform b = new RectTransform(new Vector2(25));
		child1.addComponent(b);
		this.addGameObject(child1);
		
		GameObject child2 = new GameObject("boundsChild2", new Vector2(0, 0), this.canvasGameObject);
		RectTransform b2 = new RectTransform(new Vector2(-50, -50), new Vector2(50, 50));
		//RectTransform b = new RectTransform(new Vector2(25));
		child2.addComponent(b2);
		this.addGameObject(child2);
		
		/*GameObject boundsChild1 = new GameObject(new Vector2(-750/2), boundsParent);
		Bounds b2 = new Bounds(new Vector2(10));
		boundsChild1.addComponent(b2);
		this.addGameObject(boundsChild1);
		
		GameObject boundsChild2 = new GameObject(new Vector2(750/2), boundsParent);
		Bounds b3 = new Bounds(new Vector2(10));
		boundsChild2.addComponent(b3);
		this.addGameObject(boundsChild2);*/
		
		
	}

}

/* TESTEN IN UNITY
 * Wie machen die Das mit dem Parenten von UI Objekten
 * Wenn man die Position verändert, verändert sich dann auhc die Bounds
 * Wie geht es mit nicht UI Objekten um die Childern von UI Objekten sind?
 */