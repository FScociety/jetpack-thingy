package scenes;

import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.builtin.ui.Alignment;
import engine.gameobjects.gamebehaviour.builtin.ui.RectTransform;
import engine.gameobjects.gamebehaviour.builtin.ui.text.SimpleText;
import engine.gameobjects.gamebehaviour.builtin.ui.text.TextNew;
import engine.math.Vector2;
import engine.scenes.Scene;

public class UITest extends Scene {

	public UITest() {
		super("UITest");
	}

	@Override
	public void instanceGameObjects() {
		GameObject right_bottom = new GameObject("right_bottom", new Vector2(0, 0), this.canvasGameObject);
		RectTransform b = new RectTransform(new Vector2(200, 200), new Vector2(240, 240), new Vector2(1,1));
		right_bottom.addComponent(b);	
		
		GameObject left_bottom = new GameObject("left_bottom", new Vector2(0, 0), this.canvasGameObject);
		RectTransform b1 = new RectTransform(new Vector2(-240, 200), new Vector2(-200, 240), new Vector2(-1,1));
		left_bottom.addComponent(b1);	
		
		GameObject right_top = new GameObject("right_top", new Vector2(0, 0), this.canvasGameObject);
		RectTransform b2 = new RectTransform(new Vector2(200, -240), new Vector2(240, -200), new Vector2(1,-1));
		right_top.addComponent(b2);	
		
		GameObject left_top = new GameObject("left_top", new Vector2(0, 0), this.canvasGameObject);
		RectTransform b3 = new RectTransform(new Vector2(-240, -240), new Vector2(-200, -200), new Vector2(-1,-1));
		left_top.addComponent(b3);
		
		GameObject scaling_left = new GameObject("scaling_left", new Vector2(0, 0), this.canvasGameObject);
		RectTransform b4 = new RectTransform(new Vector2(-240, -100), new Vector2(-140, 100), new Vector2(2,2));
		scaling_left.addComponent(b4);
		scaling_left.addComponent(new SimpleText("Hallo, lol"));
	}
}

/* TESTEN IN UNITY
 * Wie machen die Das mit dem Parenten von UI Objekten
 * Wenn man die Position verändert, verändert sich dann auhc die Bounds
 * Wie geht es mit nicht UI Objekten um die Childern von UI Objekten sind?
 */