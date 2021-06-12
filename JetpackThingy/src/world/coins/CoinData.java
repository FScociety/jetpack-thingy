package world.coins;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;

import engine.game.GameContainer;
import engine.math.Vector2;
import tools.worldlayers.MovingData;

public class CoinData extends MovingData {
	
	public static int coinSize = 15;
	
	int coins[] = new int[coinSize];
	
	private BufferedImage coin;
	
	public Logger log;
	
	public CoinData(BufferedImage coin) {
		this.coin = coin;
		this.generateNew();
	}

	@Override
	public MovingData getNew() {
		return new CoinData(this.coin);
	}

	@Override
	public void generateNew() {
		if (CoinController.cc.activeCoinPattern != null) { 
			this.coins = CoinController.cc.activeCoinPattern.getLine();
		}
	}

	@Override
	public void render() {
		if (this.coins != null) {
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] == 1) {
					GameContainer.d.drawImage(this.coin, new Vector2(this.parent.position, (i-((float)this.coins.length)/2) * this.parent.parent.elementBounds.y), new Vector2(this.parent.parent.elementBounds.y));
				}
			}
		}
	}
	
	public void remove(int startingY) {
		System.out.println("Tryed to remove");

		if (startingY > coins.length-3) {
			startingY = coins.length-3;
		}
		for (int i = 0; i < 3; i++) {
			coins[i + startingY] = 0;
		}
	}
}	