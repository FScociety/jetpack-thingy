package scenes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.game.GameContainer;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.builtin.animation.SpriteAnimationSheet;
import engine.gameobjects.gamebehaviour.builtin.animation.SpriteAnimator;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;

import test.MainNew;

public class GlobalTestScene extends Scene {


	public GlobalTestScene() {
	super("GlobalTestScene");
	}

	@Override
	public void instanceGameObjects() {
		MainNew.main();
		
		this.defaultCamera.zoom = 1;
		
		GameObject test = new GameObject(new Vector2(0), true);
		test.addComponent(new GameBehaviour() {
			
			float lastPos = 0;
			
			public void update() {
				this.gameObject.setPosition(Vector2.add(this.gameObject.getTransformWithCaution().position, new Vector2((float)GameContainer.dt*10)));
			
				if (GameContainer.input.isKey(KeyEvent.VK_SPACE)) {
					this.gameObject.setPosition(new Vector2(-100, 0));
				}
			}
			
			public void render() {
				this.d.setColor(Color.WHITE);
				this.d.fillRect(new Vector2(25));
				
				System.out.println(-this.lastPos + this.gameObject.getTransformWithCaution().position.x);
				this.lastPos = this.gameObject.getTransformWithCaution().position.x;
			}
		});
		this.addGameObject(test);
	}
}