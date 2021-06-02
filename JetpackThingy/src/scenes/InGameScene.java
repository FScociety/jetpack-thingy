package scenes;

import java.awt.Color;

import engine.game.GameContainer;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.builtin.ui.ColorLabel;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import player.PlayerController;
import world.ParalaxBackground2;
import world.ParallaxBackground;
import world.TrackingPoint;

public class InGameScene extends Scene {
	
	public static GameObject trackingPoint;

	public InGameScene() {
		super("inGame");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void instanceGameObjects() {
		GameObject background = new GameObject(new Vector2(0, 0), true);
		//background.addComponent(new ParallaxBackground("/paralaxbackgrounds/sunshine", 7));
		background.addComponent(new ParalaxBackground2("/paralaxbackgrounds/sunshine", 1, new Vector2(384*2, 216*2)));
		this.addGameObject(background);
		
		trackingPoint = new GameObject(new Vector2(0), true);
		trackingPoint.updatesOutOfView = true;
		trackingPoint.addComponent(new TrackingPoint());
		this.addGameObject(trackingPoint);
		
		GameObject player = new GameObject(new Vector2(0), true);
		player.addComponent(new PlayerController());
		this.addGameObject(player);
		
		GameObject ceilBorder = new GameObject(new Vector2(0, -PlayerController.borders - 25), trackingPoint);
		ceilBorder.addComponent(new GameBehaviour() {
			public void render() {
				this.d.setColor(Color.PINK);
				this.d.fillRect(new Vector2(5000, 50));
			}
		});
		ceilBorder.viewRange = 5000;
		this.addGameObject(ceilBorder);
		
		GameObject floorBorder = new GameObject(new Vector2(0, PlayerController.borders + 25), trackingPoint);
		floorBorder.addComponent(new GameBehaviour() {
			public void render() {
				this.d.setColor(Color.PINK);
				this.d.fillRect(new Vector2(5000, 50));
			}
		});
		floorBorder.viewRange = 5000;
		this.addGameObject(floorBorder);
	}

}
