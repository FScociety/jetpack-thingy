package world;

import java.awt.Color;

import engine.game.Drawing;
import engine.math.Vector2;

public class BackgroundElement {
	
	public float posX;
	public int sizeX;
	public BackgroundElement follower;
	public Drawing d;
	
	public BackgroundElement(Drawing d, float posX, int sizeX, int toAdd) {
		this.sizeX = sizeX;
		this.posX = posX;
		this.d = d;
		
		System.out.println("added one Background element posX: " + this.posX + " | SizeX: " + this.sizeX);
		
		if (toAdd > 0) { 
			this.follower = new BackgroundElement(this.d, this.posX + this.sizeX, this.sizeX, toAdd-1);
		}
	}
	
	public void setFollower(BackgroundElement follower) {
		this.follower = follower;
		this.follower.posX = this.posX + this.sizeX;
	}
	
	public BackgroundElement getEnd() {
		if (this.follower != null) {
			return this;
		} else {
			return this.follower.getEnd();
		}
	}
	
	public void moveToEnd() {
		this.getEnd().setFollower(this);
	}
	
	public void move(float moving) {
		this.posX -= moving;
		
		if (this.follower != null) {
			this.follower.move(moving);
		}
	}
	
	public void render() {
		this.d.setColor(Color.WHITE);
		this.d.drawRect(new Vector2(posX, 0), new Vector2(sizeX));
	}
}