package scenes;

import java.awt.Color;
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

public class GlobalTestScene extends Scene {


	public GlobalTestScene() {
	super("GlobalTestScene");
	}

	@Override
	public void instanceGameObjects() {
		/*GameObject empty = new GameObject(new Vector2(0), true);
		empty.updatesOutOfView = true;
		empty.addComponent(new GameBehaviour() {
			public void update() {
				this.gameObject.addPosition(new Vector2((float)GameContainer.dt * 25, 0));
			}
		});
		this.addGameObject(empty);
		
		for (int i = -5; i < 5; i++) {
			GameObject wallParallaxTest = new GameObject(new Vector2(i * 61, 0), empty);
			wallParallaxTest.updatesOutOfView = true;
			int lines[] = {3};
			SpriteAnimationSheet spriteSheet = new SpriteAnimationSheet("/test2.png", lines, new Vector2(61, 91));
			//SpriteAnimator sa = new SpriteAnimator(spriteSheet);
			//wallParallaxTest.addComponent(sa);
			//sa.playInstant(0);
			wallParallaxTest.addComponent(new GameBehaviour() {
				private int x = 1;
				private float startOffset = 0;
				
				public void start() {
					startOffset = this.gameObject.getTransformWithCaution().position.x;
				}
				
				public void update() {
					//this.gameObject.setPosition(new Vector2(GameContainer.input.getMousePos(true).x + this.startOffset, 0));
					
					int actualX = (int)this.gameObject.getTransformWithCaution().position.x;
					
					actualX /= 20;
					actualX = Math.round(actualX);
					if (actualX > 1) {
						actualX = 1;
					} else if (actualX < -1) {
						actualX = -1;
					}
					actualX *= -1;
					x = actualX + 1;
				}
				
				public void render() {
					this.d.drawImage(spriteSheet.getSprite(x, 0));
				}
			});
		}
		*/
		
		GameObject slices = new GameObject(new Vector2(0), true);
		slices.addComponent(new GameBehaviour() {
			BufferedImage slice;
			
			private float[] offsetX = new float[3];
			
			public void start() {
				try {
					 this.slice = ImageIO.read(getClass().getResourceAsStream("/slice.png"));
				} catch (IOException e) {
				}
				offsetX[0] = -slice.getWidth() * 5f;
				offsetX[1] = 0;
				offsetX[2] = slice.getWidth() * 5f;
			}
			
			public void update() {
				for (int i = 0; i < offsetX.length; i++) {
					//offsetX[i]-=(float)GameContainer.dt * 300;
					if (offsetX[i] < -slice.getWidth() * 5f) {
						offsetX[i] = slice.getWidth() * 5f;
					}
				}
			}
			
			public void render() {
				for (int i = 0; i < offsetX.length; i++) {
					this.d.setColor(Color.WHITE);
					
					this.d.drawString(Math.round(offsetX[i])+"", 5, new Vector2(offsetX[i] - slice.getWidth() * 2.5f, -slice.getHeight() * 2.5f));
					this.d.drawImage(slice, new Vector2(offsetX[i] - slice.getWidth() * 2.5f, -slice.getHeight() * 2.5f), new Vector2(slice.getWidth() * 5, slice.getHeight() * 5));
				}
			}
		});
		this.addGameObject(slices);
		this.defaultCamera.zoom = 0.5f;
	}
}