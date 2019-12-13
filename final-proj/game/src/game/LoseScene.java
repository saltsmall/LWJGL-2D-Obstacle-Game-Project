package game;

import managers.Sounds;
import managers.Textures;
import ui.Button;
import utilities.AudioType;
import utilities.Constants;

public class LoseScene extends Scene {
	private Button playAgainButton, mainMenuButton, quitButton;
	
	public LoseScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		Sounds.stopSFX();
		
		playAgainButton = new Button(Constants.GAME_WIDTH/2-Constants.UNITSIZE*2, Constants.GAME_HEIGHT-Constants.UNITSIZE*2-20, Constants.UNITSIZE*4, Constants.UNITSIZE*2, Textures.playAgainButtonFrames, 3);
		mainMenuButton = new Button(50, Constants.GAME_HEIGHT-Constants.UNITSIZE*2-20, Constants.UNITSIZE*4, Constants.UNITSIZE*2, Textures.mainMenuButtonFrames, 0);
		quitButton = new Button(Constants.GAME_WIDTH-Constants.UNITSIZE*4-50, Constants.GAME_HEIGHT-Constants.UNITSIZE*2-20, Constants.UNITSIZE*4, Constants.UNITSIZE*2, Textures.quitButtonFrames, -1);
		buttons.add(playAgainButton);
		buttons.add(mainMenuButton);
		buttons.add(quitButton);
		
		super.setup();
		
		Sounds.play(Sounds.lost, AudioType.SFX);
		Sounds.play(Sounds.loseScreenMusic, AudioType.MUSIC);
	}

	protected void update() {
		for (Button b : buttons) { b.update(); }
	}

	protected void render() {
		Textures.render(Textures.loseScreen);
		for (Button b : buttons) { b.render(); }
	}
	
	public void clear() {
		buttons.clear();
	}
}
