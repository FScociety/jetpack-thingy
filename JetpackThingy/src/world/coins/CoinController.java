package world.coins;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import tools.worldlayers.MovingLayer;

public class CoinController extends GameBehaviour {
	
	public static CoinController cc;
	public MovingLayer coinList;
	
	BufferedImage coin;
	
	public int coinSize = 50;
	
	public CoinPattern activeCoinPattern;
	public CoinPattern[] coinPatterns = new CoinPattern[6];
	
	public CoinController() {
		//Signleton assignment
		if (CoinController.cc == null) {
			CoinController.cc = this;
		}
		
		for (int i = 1; i < coinPatterns.length; i++) {
			this.coinPatterns[i] = new CoinPattern(i);
		}
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
		this.activeCoinPattern.newYOffset();
		System.out.println(this.activeCoinPattern);
		return this.activeCoinPattern;
	}
	
	public void update() {
		coinList.update();
	}
	
	public void render() {
		coinList.render();
	}
}