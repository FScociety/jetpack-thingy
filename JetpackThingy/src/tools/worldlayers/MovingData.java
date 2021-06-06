package tools.worldlayers;

public abstract class MovingData {
	
	public MovingElement parent;
	
	public MovingData() {
		
	}
	
	public abstract MovingData getNew();
	
	public abstract void generateNew();
	
	public abstract void render();
}