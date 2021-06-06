package scenes;

import java.awt.Color;

import engine.gameobjects.GameObject;
import engine.math.Vector2;
import engine.scenes.Scene;
import player.PlayerController;
import world.background.ParalaxBackground;
import world.coins.CoinController;

public class InGameScene extends Scene {
	
	public static GameObject trackingPoint;

	public InGameScene() {
		super("inGame");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void instanceGameObjects() {
		/*GameObject background = new GameObject(new Vector2(0), true);
		background.addComponent(new ParalaxBackground("/paralaxbackgrounds/sunshine", 6));
		this.addGameObject(background);*/
		
		GameObject player = new GameObject(new Vector2(0), true);
		player.addComponent(new PlayerController());
		this.addGameObject(player);
		
		GameObject coins = new GameObject(new Vector2(0), true);
		coins.addComponent(new CoinController());
		this.addGameObject(coins);
	}

}
