package scenes;

import java.awt.Color;

import engine.game.GameContainer;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.Bounds;
import engine.gameobjects.gamebehaviour.builtin.ui.Text;
import engine.gameobjects.gamebehaviour.builtin.ui.Text2;
import engine.gameobjects.gamebehaviour.builtin.ui.interactable.Button;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;

public class UITest extends Scene {

	public UITest() {
		super("UITest");
	}

	@Override
	public void instanceGameObjects() {
		GameObject boundsParent = new GameObject(new Vector2(750/2), false);
		Bounds b = new Bounds(new Vector2(100));
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
