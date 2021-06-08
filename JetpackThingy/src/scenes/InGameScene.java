package scenes;

import java.awt.Color;

import engine.game.GameContainer;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import player.PlayerController;
import world.CameraController;
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
		this.defaultCameraObject.addComponent(new CameraController(this.defaultCamera));
		
		GameObject background = new GameObject(new Vector2(0), true);
		background.addComponent(new ParalaxBackground("/backgrounds/sunshine", 6));
		this.addGameObject(background);
		
		GameObject coins = new GameObject(new Vector2(0), true);
		CoinController cc = new CoinController();
		coins.addComponent(cc);
		this.addGameObject(coins);
		
		GameObject player = new GameObject(new Vector2(0), true);
		player.addComponent(new PlayerController(cc));
		this.addGameObject(player);
	}

}
