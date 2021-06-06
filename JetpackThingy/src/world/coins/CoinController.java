package world.coins;

import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;
import tools.worldlayers.MovingLayer;

public class CoinController extends GameBehaviour {
	
	MovingLayer coinList;
	
	public void start() {
		CoinData defaultCoin = new CoinData();
		coinList = new MovingLayer(defaultCoin, new Vector2(50), -250, 0.2f);
		coinList.add(coinList.getAmoutOverScreen());
		defaultCoin.parent = coinList.start;
	}
	
	public void update() {
		coinList.update();
	}
	
	public void render() {
		coinList.render();
	}
}