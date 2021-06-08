package world.background;

import java.awt.image.BufferedImage;

import engine.game.GameContainer;
import engine.math.Vector2;
import tools.worldlayers.MovingData;

public class BackgroundData extends MovingData {
	
	public BufferedImage img;
	
	public BackgroundData(BufferedImage img) {
		this.img = img;
	}
	
	@Override
	public void render() {
		GameContainer.d.drawImage(img, new Vector2(this.parent.position, -this.parent.parent.elementBounds.y/2+1), Vector2.add(this.parent.parent.elementBounds, 2));
	}

	@Override
	public MovingData getNew() {
		return new BackgroundData(this.img);
	}

	@Override
	public void generateNew() {
		
	}
}
