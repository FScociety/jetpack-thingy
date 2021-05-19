package player;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import engine.game.GameContainer;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;
import engine.math.Vector2;

public class PlayerController extends GameBehaviour {
	
	public static int borders = 350;
	
	int sizeY = 50;
	
	boolean ceilCollision, floorCollision;
	
	float velocityY = 0;
	float forceY = 9.81f;
	
	public void update() {
		
		float posY = this.gameObject.getTransformWithCaution().position.y;
		if (posY-sizeY/2 < -borders && this.ceilCollision == false) {
			ceilCollision = true;
			this.velocityY = 0;
			this.gameObject.getTransformWithCaution().position.y = -borders + sizeY/2;
		} else if (posY-sizeY/2 > -borders) {
			ceilCollision = false;
			if (posY+sizeY/2 > borders && this.floorCollision == false) {
				floorCollision = true ;
				this.velocityY = 0;
				this.gameObject.getTransformWithCaution().position.y = borders - sizeY/2;
			} else if (posY+sizeY/2 < borders) {
				floorCollision = false;
			}
		}
		
		if (!this.floorCollision) {
			this.velocityY += (float) (this.forceY * GameContainer.dt * 20);
		}
		
		if ((this.floorCollision == false && this.ceilCollision == false) || 
			(this.floorCollision == true && this.velocityY < 0) || 
			(this.ceilCollision == true && this.velocityY > 0)) {
				this.gameObject.addPosition(new Vector2(0, (float) (this.velocityY * GameContainer.dt)));
		}
		
		if (GameContainer.input.isKeyDown(KeyEvent.VK_SPACE) && !this.ceilCollision) {
			this.velocityY -= (float) (this.forceY * GameContainer.dt * 50);
		}
	}
	
	public void render() {
		this.d.setColor(Color.WHITE);
		this.d.fillRect(new Vector2(sizeY));
	}
	
	//Schule version
	
	/*public PlayerController(String name) {
		this.name = name;
		PlayerController.players.add(this);
	}
	
	public static ArrayList<PlayerController> players = new ArrayList<PlayerController>();
	private String name;
	
	public static PlayerController getPlayer(String name) {
		for (PlayerController pc : players) {
			if (pc.name == name) {
				return pc;
			}
		}
		return null;
	}*/
}