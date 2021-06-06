package tools.movingList;

public class MovingElement <_MovingList_ extends MovingList> {
	
	public MovingElement<_MovingList_> follower;
	public _MovingList_ parent;
	public MovingData data;
	
	public MovingElement(_MovingList_ parent, MovingData data, int toAdd) {
		this.parent = parent;
		this.data = data.generateNewOne(this);
		this.data.element = this;
		
		if (toAdd > 0) { 
			//this.follower = new MovingElement(this.parent, this.posX + this.parent.imageSize.x, toAdd-1);
			this.follower = new MovingElement(this.parent, data, toAdd-1);
		}
	}
	
	public MovingElement getEnd() {
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
		
		this.getEnd().follower = this;
		this.follower = null;
		
		//Get new Image variation
		//this.image = this.parent.getNewImage();
		this.data = this.data.generateNewOne(this);
	}
	
	public void render() {
		if (this.follower != null) {
			this.follower.render();
		}
	}
}