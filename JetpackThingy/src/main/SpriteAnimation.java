package main;

import engine.gameobjects.gamebehaviour.type.GameBehaviour;

public class SpriteAnimation extends GameBehaviour {
	
	SpriteSheet ss;
	
	int posX,  posY;
	
	public SpriteAnimation(SpriteSheet ss) {
		this.ss = ss;
	}
	
	public void render() {
		this.d.drawImage(ss.getSprite(posX, posY));
	}

}