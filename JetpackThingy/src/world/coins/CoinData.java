package world.coins;

import java.awt.Color;
import java.awt.image.BufferedImage;

import engine.game.GameContainer;
import engine.math.Vector2;
import tools.worldlayers.MovingData;

public class CoinData extends MovingData {
	
	public static int coinSize = 15;
	
	boolean coins[] = new boolean[coinSize];
	
	private BufferedImage coin;
	
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
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Math.random() < 0.5f ? true : false;
		}
	}

	@Override
	public void render() {
		for (int i = 0; i < coins.length; i++) {
			/*GameContainer.d.setColor(Color.YELLOW);
			GameContainer.d.drawRect(new Vector2(this.parent.position, (i-((float)this.coins.length)/2) * this.parent.parent.elementBounds.y), new Vector2(this.parent.parent.elementBounds.y));*/
			if (coins[i] == true) {
				GameContainer.d.drawImage(this.coin, new Vector2(this.parent.position, (i-((float)this.coins.length)/2) * this.parent.parent.elementBounds.y), new Vector2(this.parent.parent.elementBounds.y));
			}
		}
	}
	
	public void remove(int startingY) {
		if (startingY > coins.length-3) {
			startingY = coins.length-3;
		}
		for (int i = 0; i < 3; i++) {
			coins[i + startingY] = false;
		}
	}
	
	public void blink() {
		for (int i = 0; i < coins.length; i++) {
			coins[i] = true;
		}
	}
}	