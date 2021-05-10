package scenes;

import java.awt.Color;

import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import player.PlayerController;
import world.ParallaxBackground;

public class InGameScene extends Scene {

	public InGameScene() {
		super("inGame");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void instanceGameObjects() {
		GameObject border = new GameObject(new Vector2(0), true);
		border.addComponent(new ParallaxBackground("/paralaxbackgrounds/sunshine", 7));
		this.addGameObject(border);
		
		GameObject player = new GameObject(new Vector2(0), true);
		player.addComponent(new PlayerController());
		this.addGameObject(player);
	}

}
