package main;

import java.awt.Color;

import engine.game.AbstractGame;
import engine.game.GameContainer;
import engine.gameobjects.GameObject;
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
				GameObject würfelTest = new GameObject(new Vector2(0), true);
				SpriteSheet ss = new SpriteSheet("/lol.jpg", 6, 2);
				würfelTest.addComponent(new SpriteAnimation(ss));
				this.addGameObject(würfelTest);
				
			}
			
		};
	}

	@Override
	public void start() {
		SceneManager.loadScene(inGame);
	}

}
