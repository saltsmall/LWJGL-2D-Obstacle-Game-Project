package game.game_objects;

import game.Textures;

public class Block extends VisibleObject {
	
	public void render() {
		Textures.render(Textures.hatsune, x, y);
	}
	
	public Block(int width, int height) {
		super(width, height);
	}

}
