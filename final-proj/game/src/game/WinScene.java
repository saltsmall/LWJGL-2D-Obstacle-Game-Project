package game;

import managers.Sounds;
import managers.Textures;
import ui.Button;
import utilities.AudioType;
import utilities.Constants;

public class WinScene extends Scene {
	private Button quitButton;
	
	public WinScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		Sounds.stopSFX();
		
		quitButton = new Button(Constants.GAME_WIDTH/2-Constants.UNITSIZE*2, Constants.GAME_HEIGHT-Constants.UNITSIZE*2-10, Constants.UNITSIZE*4, Constants.UNITSIZE*2, Textures.quitButtonFrames, -1);
		buttons.add(quitButton);
		
		super.setup();
		
		Sounds.play(Sounds.winScreenMusic, AudioType.MUSIC);
	}

	protected void update() {
		for (Button b : buttons) { b.update(); }
	}

	protected void render() {
		Textures.render(Textures.winScreen);
		for (Button b :  buttons) { b.render(); }
	}
	
	public void clear() {
		buttons.clear();
	}
}
