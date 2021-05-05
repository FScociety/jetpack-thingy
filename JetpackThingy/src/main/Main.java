package main;

import java.awt.Color;
import java.awt.event.KeyEvent;

import engine.game.AbstractGame;
import engine.game.GameContainer;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.builtin.animation.SpriteAnimator;
import engine.gameobjects.gamebehaviour.builtin.animation.SpriteAnimationSheet;
import engine.gameobjects.gamebehaviour.builtin.camera.CameraController;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import engine.scenes.SceneManager;

public class Main extends AbstractGame {
	
	Scene inGame;
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new Main());	
		gc.setSize(new Vector2(1000, 500));
		gc.start();
	}
	
	public Main() {
		inGame = new Scene("inGame") {

			@Override
			public void instanceGameObjects() {
				GameObject wuerfelTest = new GameObject(new Vector2(0), true);
				int[] arrangement = {15, 15};
				SpriteAnimationSheet ss = new SpriteAnimationSheet("/animationTest.png", arrangement, new Vector2(10, 10));       
				SpriteAnimator spriteAnim = new SpriteAnimator(ss);
				wuerfelTest.addComponent(spriteAnim);
				wuerfelTest.addComponent(new GameBehaviour() {
					SpriteAnimator sa = spriteAnim;
					
					public void update() {
						if (GameContainer.input.isKey(KeyEvent.VK_SPACE)) {
							sa.playAfterFinish(1);
						}
					}
				});
				spriteAnim.playInstant(0);
				this.addGameObject(wuerfelTest);
				wuerfelTest.setScale(new Vector2(10));
				
				
				this.defaultCamera.gameObject.addComponent(new CameraController(true, true, false));
			}
			
		};
	}

	@Override
	public void start() {
		SceneManager.loadScene(inGame);
	}

}
