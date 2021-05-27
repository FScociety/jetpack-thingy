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
		GameObject boundsParent = new GameObject("boundsChild", new Vector2(100, 0), this.canvasGameObject);
		System.out.println(this.defaultCameraObject);
		RectTransform b = new RectTransform(new Vector2(400, 0), new Vector2(500,500));
		boundsParent.addComponent(b);
		this.addGameObject(boundsParent);
		
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