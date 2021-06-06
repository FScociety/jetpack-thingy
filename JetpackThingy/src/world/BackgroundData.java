package world;

import java.awt.Color;
import java.awt.image.BufferedImage;

import engine.game.Drawing;
import engine.math.Vector2;
import tools.movingList.MovingData;
import tools.movingList.MovingElement;

public class BackgroundData extends MovingData<BackgroundLayer, BackgroundData>{
	
	public BufferedImage image;
	
	public BackgroundData(float posX) {
		this.posX = posX;
	}
	

	@Override
	public BackgroundData generateNewOne(MovingElement gd) {
		BackgroundData bd = new BackgroundData(this.posX + ((BackgroundLayer)gd.parent).imageSize.x);
		bd.element = gd;
		bd.image = ((BackgroundLayer)gd.parent).getNewImage();
		return bd;
	}
	
	@Override
	public void move(float moving) {
		this.posX -= moving;
		
		//System.out.println(posX  + " " + this.parent.backgroundsSize * this.sizeX);
		
		//BAD Practise "backgroundSize * sizeX" = const. muss nich immer gerechnet werden
		if (this.posX <= -(this.element.parent.backgroundsSize/2+1) * this.element.parent.imageSize.x) {
			this.element.moveToEnd();
		}
		
		if (this.element.follower != null) {
			this.element.follower.data.move(moving);
		}
	}
	
	@Override
	public void render() {
		/*this.parent.d.setColor(Color.WHITE);
		this.parent.d.drawRect(new Vector2(posX, -this.parent.imageSize.y/2), this.parent.imageSize);*/
		
		this.element.parent.d.drawImage(image, new Vector2(posX, - ((this.element.parent.imageSize.y+2)/2)), Vector2.add(this.element.parent.imageSize, 2));
	}
}