package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import engine.game.AbstractGame;
import engine.game.GameContainer;
import engine.gameobjects.GameObject;
import engine.gameobjects.gamebehaviour.builtin.camera.CameraController;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import scenes.GlobalTestScene;
import scenes.InGameScene;
import scenes.NewTest;
import scenes.UITest;

public class Main extends AbstractGame {
	
	Scene inGame, UiTest, globalTest, newTest;
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer();	
		gc.setSize(new Vector2(500, 500));
		gc.setGame(new Main());
		gc.start();
	}
	
	public Main() {
		inGame = new InGameScene();
		
		UiTest = new UITest();
		
		globalTest = new GlobalTestScene();
		
		newTest = new NewTest();
	}

	@Override
	public void start() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		GameContainer.window.frame.setSize(size);
		
		//Safety cause multithreading
		//Not a good solution but it works
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SceneManager.loadScene(inGame);
	}
	
	public void update() {
		this.inGame.defaultCamera.zoom = GameContainer.windowSize.y / 500 / 2;
		
		if (GameContainer.input.isKey(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
	}
}