package tools.movingList;

public abstract class MovingData <_MovingList_ extends MovingList, _MovingData_ extends MovingData>{
	
	public float posX;
	public MovingElement<_MovingList_> element;
	
	public abstract _MovingData_ generateNewOne(MovingElement me);
	
	public abstract void move(float moving);
	
	public abstract void render();
}