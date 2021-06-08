package world.coins;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import tools.worldlayers.MovingLayer;

public class CoinController extends GameBehaviour {
	
	public MovingLayer coinList;
	
	BufferedImage coin;
	
	public int coinSize = 50;
	
	public void start() {
		try { this.coin = ImageIO.read(getClass().getResourceAsStream("/coins/coin.png"));
		} catch (IOException e) {}
		
		CoinData defaultCoin = new CoinData(this.coin);
		coinList = new MovingLayer(defaultCoin, new Vector2(coinSize), -1000, 1);
		coinList.addInstant(40);
		defaultCoin.parent = coinList.start;
	}
	
	public void update() {
		coinList.update();
	}
	
	public void render() {
		coinList.render();
	}
}