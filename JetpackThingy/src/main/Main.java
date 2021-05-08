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
				int[] arrangement = {2, 4, 9};
				SpriteAnimationSheet ss = new SpriteAnimationSheet("/PlayerAnimation.png", arrangement, new Vector2(15, 15));       
				SpriteAnimator spriteAnim = new SpriteAnimator(ss);
				wuerfelTest.addComponent(spriteAnim);
				wuerfelTest.addComponent(new GameBehaviour() {
					SpriteAnimator sa = spriteAnim;
					
					float velocityY;
					
					public void update() {
						if (GameContainer.input.isKey(KeyEvent.VK_SPACE)) {
							sa.playInstant(2);
							velocityY = 0;
							velocityY-=300;
							sa.timePerFrame = 0.35f;
						} else {
							sa.playAfterFinish(1, 0.1f);
						}
						
						velocityY += GameContainer.dt * 9.81f * 30;
						if (this.gameObject.getTransformWithCaution().position.y < 0 || velocityY < 0) {
							this.gameObject.addPosition(new Vector2(0, (float) (velocityY * GameContainer.dt)));
						}
					}
				});
				spriteAnim.playInstant(0);
				this.addGameObject(wuerfelTest);
				wuerfelTest.setScale(new Vector2(5));
				
				
				this.defaultCamera.gameObject.addComponent(new CameraController(true, true, false));
			}
			
		};
	}

	@Override
	public void start() {
		SceneManager.loadScene(inGame);
	}

}
