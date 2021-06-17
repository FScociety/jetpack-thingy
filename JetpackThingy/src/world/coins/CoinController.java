package world.coins;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.game.GameContainer;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.io.Logger;
import engine.math.Vector2;
import tools.worldlayers.MovingLayer;

public class CoinController extends GameBehaviour {
	
	private final String prefix = "CoinController";
	
	public static CoinController cc;
	public MovingLayer coinList;
	
	BufferedImage coin;
	
	public int coinSize = 50;
	
	public CoinPattern activeCoinPattern;
	public CoinPattern[] coinPatterns = new CoinPattern[6];
	
	private float time;
	private float timeBounds;
	
	public CoinController() {
		//Signleton assignment
		if (CoinController.cc == null) {
			CoinController.cc = this;
		}
		
		for (int i = 0; i < coinPatterns.length; i++) {
			this.coinPatterns[i] = new CoinPattern(i);
		}
		
		Logger.fine("Coin Patterns were loaded!");
		
		newPattern();
	}
	
	public void start() {
		try { this.coin = ImageIO.read(getClass().getResourceAsStream("/coins/coin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CoinData defaultCoin = new CoinData(this.coin);
		coinList = new MovingLayer(defaultCoin, new Vector2(coinSize), -1000, 1);
		coinList.addInstant(40);
		defaultCoin.parent = coinList.start;
	}
	
	public CoinPattern newPattern() {
		int random = (int)(Math.random()*this.coinPatterns.length-1);
		this.activeCoinPattern = this.coinPatterns[random];
		this.activeCoinPattern.refresh();
		
		System.out.println(this.activeCoinPattern + "[s size: " + this.coinPatterns.length + "; " + random);
		
		this.activeCoinPattern.newYOffset();
		return this.activeCoinPattern;
	}
	
	public void update() {
		if (this.time >= this.timeBounds) {
			if (this.activeCoinPattern.isFinished()) {
				this.newPattern();
				this.time = 0;
				this.timeBounds = (float) (Math.random()+0.4f);
			}
		} else {
			this.time += GameContainer.dt;
		}
		
		coinList.update();
	}
	
	public void render() {
		coinList.render();
	}
}