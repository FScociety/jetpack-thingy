package tools.worldlayers;

import java.awt.Color;

import engine.game.GameContainer;
import engine.game.Window;
import engine.math.Vector2;
import engine.scenes.SceneManager;

public class MovingElement {
	public  MovingLayer parent;
	public  MovingData data;
	private MovingElement follower;
	
	public boolean visible = true;
	
	public float position;
	
	public MovingElement(MovingLayer parent, MovingData data, float position) {
		this.parent = parent;
		this.data = data;
		
		this.position = position;
	}
	
	public void add(int i) {
		if (i > 0) {
			MovingData newData = this.data.getNew();
			this.follower = new MovingElement(this.parent, newData, this.getFollowerPos());
			newData.parent = this.follower;
			
			this.follower.add(i-1);
			
			this.parent.elements++;
		}
	}
	
	public MovingElement getEnd() {
		if (this.follower == null) {
			return this;
		} else {
			return this.follower.getEnd();
		}
	}
	
	public MovingElement get(int i) {
		if (i > 0) {
			if (this.follower != null) {
				return this.follower.get(i-1);
			}
			return null;
		} else {
			return this;
		}
	}
	
	public float getFollowerPos() {
		return this.position + this.parent.elementBounds.x;
	}
	
	public void setFollower(MovingElement follower) {
		this.follower = follower;
		this.follower.position = this.getFollowerPos();
	}
	
	private void moveToEnd() {
		if (this.follower != null) {
			this.parent.start = this.follower;
		}
		
		this.getEnd().setFollower(this);
		this.follower = null;
	}
	
	public void realign(float pos) {
		this.position = pos;
		this.visible = true;
		
		if (this.follower != null) {
			pos += this.parent.elementBounds.x;
			this.follower.realign(pos);
		}
	}
	
	public void move(float speed) {
		
		if (this.visible) {
			this.position -= speed;
		}
			
		//Reached the end
		if (this.position < this.parent.positionBounds - this.parent.elementBounds.x) {
			if (this.parent.removeElements) {
				//Slowly vanish objects, which are out of view
				this.visible = false;
			} else {
				//Move to end for looping
				this.moveToEnd();
				
				//Generate new DATA
				this.data.generateNew();
			}
		}
			
		if (this.follower != null) {
			this.follower.move(speed);
		}
	}
	
	public void render() {
		if (this.visible) {
			/*GameContainer.d.setColor(Color.WHITE);
			GameContainer.d.drawRect(new Vector2(this.position, -this.parent.elementBounds.y/2), this.parent.elementBounds);*/
			this.data.render();
		}
		
		if (this.follower != null) {
			this.follower.render();
		}
	}
}