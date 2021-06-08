package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import engine.game.AbstractGame;
import engine.game.GameContainer;
import engine.game.Window;
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
		GameContainer gc = new GameContainer(new Vector2(720, 405));	
        //Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		//gc.setSize(new Vector2((float)size.getWidth(), (float)size.getHeight()));
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
		SceneManager.loadScene(inGame);
	}
	
	public void update() {
		if (GameContainer.input.isKey(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
	}
}