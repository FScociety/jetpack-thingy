package main;

import java.awt.Color;
import java.awt.event.KeyEvent;

import engine.game.AbstractGame;
import engine.game.GameContainer;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.builtin.camera.CameraController;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import scenes.InGameScene;
import scenes.UITest;

public class Main extends AbstractGame {
	
	Scene inGame, UiTest;
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new Main());	
		gc.setSize(new Vector2(750, 750));
		gc.start();
	}
	
	public Main() {
		inGame = new InGameScene();
		
		UiTest = new UITest();
	}

	@Override
	public void start() {
		SceneManager.loadScene(UiTest);
	}
	
	public void update() {
		this.inGame.defaultCamera.zoom = GameContainer.windowSize.y / 500 / 2;
	}

}
