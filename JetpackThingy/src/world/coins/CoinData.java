package world.coins;

import java.awt.Color;

import engine.game.GameContainer;
import engine.math.Vector2;
import tools.worldlayers.MovingData;

public class CoinData extends MovingData {
	
	boolean coins[] = new boolean[10];
	
	public CoinData() {
		this.generateNew();
	}

	@Override
	public MovingData getNew() {
		return new CoinData();
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
			GameContainer.d.setColor(Color.YELLOW);
			GameContainer.d.drawRect(new Vector2(this.parent.position, i * this.parent.parent.elementBounds.y), new Vector2(this.parent.parent.elementBounds.y));
		}
	}
}	