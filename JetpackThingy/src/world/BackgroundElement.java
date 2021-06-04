package world;

import java.awt.Color;
import java.awt.image.BufferedImage;

import engine.game.Drawing;
import engine.math.Vector2;

public class BackgroundElement {
	
	public float posX;
	public BackgroundElement follower;
	public BackgroundLayer parent;
	public BufferedImage image;
		
	public BackgroundElement(BackgroundLayer parent, float posX, int toAdd) {
		
		this.parent = parent;
		this.posX = posX;
		
		if (toAdd > 0) { 
			this.follower = new BackgroundElement(this.parent, this.posX + this.parent.imageSize.x, toAdd-1);
		}
		
		this.image = this.parent.getNewImage();
	}
	
	public void setFollower(BackgroundElement follower) {
		this.follower = follower;
		this.follower.posX = this.posX + this.parent.imageSize.x;
	}
	
	public BackgroundElement getEnd() {
		if (this.follower == null) {
			return this;
		} else {
			return this.follower.getEnd();
		}
	}
	
	public void moveToEnd() {
		
		if (this.follower != null) {
			this.parent.start = this.follower;
		}
		
		this.getEnd().setFollower(this);
		this.follower = null;
		
		//Get new Image variation
		this.image = this.parent.getNewImage();
	}
	
	public void move(float moving) {
		this.posX -= moving;
		
		// System.out.println(posX  + " " + this.parent.backgroundsSize * this.sizeX);
		
		// BAD Practise "backgroundSize * sizeX" = const. muss nich immer gerechnet werden
		if (this.posX <= -(this.parent.backgroundsSize/2+1) * this.parent.imageSize.x) {
			this.moveToEnd();
		}
		
		if (this.follower != null) {
			this.follower.move(moving);
		}
	}
	
	public void render() {
		/*this.parent.d.setColor(Color.WHITE);
		this.parent.d.drawRect(new Vector2(posX, -this.parent.imageSize.y/2), this.parent.imageSize);*/
		
		this.parent.d.drawImage(image, new Vector2(posX, - this.parent.imageSize.y/2), Vector2.add(this.parent.imageSize, 2));
		
		if (this.follower != null) {
			this.follower.render();
		}
	}
}