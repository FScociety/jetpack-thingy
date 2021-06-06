package tools.movingList;

public abstract class MovingList<_MovingList_ extends MovingList> {
	
	public MovingElement start;
	
	public abstract void render();
}