package game.game_objects.blocks;

import managers.Textures;

public class BlockNether extends Block {
	public BlockNether(int x, int y) {
		super(x, y);
	}
	public void render() {
		Textures.render(Textures.netherrack, x, y, width, height);
	}

	public void update() {
		
	}
}
