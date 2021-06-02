package world;

import java.awt.Color;

import engine.game.Drawing;
import engine.math.Vector2;

public class BackgroundElement {
	
	public float posX;
	public int sizeX;
	public BackgroundElement follower;
	public BackgroundLayer parent;
	public Drawing d;
	
	public BackgroundElement(BackgroundLayer parent, Drawing d, float posX, int sizeX, int toAdd) {
		
		this.parent = parent;
		
		this.sizeX = sizeX;
		this.posX = posX;
		this.d = d;
		
		if (toAdd > 0) { 
			this.follower = new BackgroundElement(this.parent, this.d, this.posX + this.sizeX, this.sizeX, toAdd-1);
		}
	}
	
	public void setFollower(BackgroundElement follower) {
		this.follower = follower;
		this.follower.posX = this.posX + this.sizeX;
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
		
		BackgroundElement end = this.getEnd();
		System.out.println("Ending posX: " + end.posX);
		end.setFollower(this);
	}
	
	public void move(float moving) {
		this.posX -= moving;
		
		//System.out.println(posX  + " " + this.parent.backgroundsSize * this.sizeX);
		
		//BAD Practise "backgroundSize * sizeX" = const. muss nich immer gerechnet werden
		if (this.posX <= -this.parent.backgroundsSize/2 * this.sizeX) {
			this.moveToEnd();
		}
		
		if (this.follower != null) {
			this.follower.move(moving);
		}
	}
	
	public void render() {
		this.d.setColor(Color.WHITE);
		this.d.drawRect(new Vector2(posX, 0), new Vector2(sizeX));
		
		/*if (this.follower != null) {
			this.follower.render();
		}*/
	}
}