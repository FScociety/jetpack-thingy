package world;

import java.awt.Color;

import engine.game.GameContainer;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;

public class TrackingPoint extends GameBehaviour {
	
	public void update() {
		this.gameObject.addPosition(new Vector2(-(float) (GameContainer.dt*1000), 0));
		if (this.gameObject.getTransformWithCaution().position.x <= -3000) {
			this.gameObject.setPosition(new Vector2(3000,0));
		}
		
		System.out.println(this.gameObject.getTransformWithCaution().position);
	}
	
	public void render() {
		this.d.setColor(Color.PINK);
		this.d.drawCircle(new Vector2(25));
	}

}
