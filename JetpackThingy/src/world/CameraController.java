package world;

import engine.game.GameContainer;
import engine.gameobjects.gamebehaviour.builtin.camera.Camera;
import engine.gameobjects.gamebehaviour.type.GameBehaviour;

public class CameraController extends GameBehaviour {
	
	private Camera cam;
	
	public CameraController(Camera newCam) {
		this.cam = newCam;
		this.updateZoom();
	}
	
	private void updateZoom() {
		this.cam.zoom = GameContainer.windowSize.y / 1080;
	}
	
	public void update() {
		this.updateZoom();
	}
}