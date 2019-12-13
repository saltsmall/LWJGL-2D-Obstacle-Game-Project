package game.game_objects;

import org.newdawn.slick.opengl.Texture;

import game.Textures;
import utilities.Constants;

public class Heart extends VisibleObject {

	private Texture heart;
	private boolean isActive;
	
	public Heart(int x, int y) {
		this.x = x;
		this.y = y;
		width = Constants.UNITSIZE;
		height = Constants.UNITSIZE;
		isActive = false;
	}
	
	public void update() {
		if (isActive) { heart = Textures.livesFrames[0]; }
		else { heart = Textures.livesFrames[1]; }
	}

	public void render() {
		Textures.render(heart, x, y, width, height);
	}
	
	//getters/setters
	public void setActive(boolean active) { isActive = active; }
}
