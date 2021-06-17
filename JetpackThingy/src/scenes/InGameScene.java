package scenes;

import java.awt.Color;

import engine.game.GameContainer;
import engine.game.Window;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
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

		GameObject background = new GameObject("background", new Vector2(0), true);
		background.addComponent(new ParalaxBackground(3));
		this.addGameObject(background);
		
		GameObject coins = new GameObject("coins", new Vector2(0), true);
		CoinController cc = new CoinController();
		coins.addComponent(cc);
		this.addGameObject(coins);
		
		GameObject player = new GameObject("player", new Vector2(0), true);
		player.addComponent(new PlayerController(cc));
		this.addGameObject(player);
		
		GameObject debugger = new GameObject("debugger", new Vector2(0), false);
		debugger.addComponent(new GameBehaviour() {
			public void start() {
				this.d.g.setFont(Window.standartFont_bold.deriveFont(20));
			}
			
			public void render() {
				float size = SceneManager.activeScene.getGameObjectsInScene().size();
				for (int i = 0; i < size; i++) {
					this.d.g.setColor(Color.BLACK);
					GameObject obj = SceneManager.activeScene.getGameObject(i);
					this.d.g.drawString(obj.getName() + ": " + obj._debugFrameTime_ + "", 0, i*20);
				}
			}
		});
		//this.addGameObject(debugger);
	}

}
