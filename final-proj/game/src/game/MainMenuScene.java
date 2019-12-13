package game;

import managers.Sounds;
import managers.Textures;
import ui.Button;
import utilities.AudioType;
import utilities.Constants;

/* MainMenuScene takes charge in instantiating the single LWJGL instance. */
public class MainMenuScene extends Scene {	
	private Button playButton, controlsButton, quitButton;
	
	public MainMenuScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		Sounds.stopSFX();
		
		playButton = new Button(Constants.GAME_WIDTH/2-Constants.UNITSIZE*2, 20, Constants.UNITSIZE*4, Constants.UNITSIZE*2, Textures.playButtonFrames, 2);
		controlsButton = new Button(50, 20, Constants.UNITSIZE*4, Constants.UNITSIZE*2, Textures.controlsButtonFrames, 1);
		quitButton = new Button(Constants.GAME_WIDTH-Constants.UNITSIZE*4-50, 20, Constants.UNITSIZE*4, Constants.UNITSIZE*2, Textures.quitButtonFrames, -1);
		buttons.add(playButton);
		buttons.add(controlsButton);
		buttons.add(quitButton);
		
		super.setup();

		Sounds.play(Sounds.mainMenuMusic, AudioType.MUSIC); 
	}

	protected void update() {
		for (Button b : buttons) { b.update(); }
	}

	protected void render() {
		Textures.render(Textures.mainMenuBackground);
		for (Button b : buttons) { b.render(); }
	}
	
	public void clear() {
		buttons.clear();
	}
}
