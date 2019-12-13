package ui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import managers.GameManager;
import managers.Sounds;
import utilities.*;

public class PauseButton extends Button {

	public PauseButton(int x, int y, int width, int height, Texture[] textures) { super(x, y, width, height, textures, 0); }
	
	public void pauseButtonUpdate() {
		super.update();
	}
	
	public void pauseButtonRender() {
		super.render();
	}
	
	// overriding checkMouseOverandClick() from Button.java because a pause button has different active sprites depending if the game has already been paused or not
	protected void checkMouseOverAndClick() {	
		int mouseX = Mouse.getX(), mouseY = Constants.GAME_HEIGHT-Mouse.getY();
		if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
			if (canPlayHoverSound) { 
				Sounds.play(Sounds.hover, AudioType.SFX); 
				canPlayHoverSound = false;
			}
			
			if (GameManager.isGamePaused()) { buttonTexture = buttonTextures[3]; }
			else { buttonTexture = buttonTextures[1]; }
			
			if (Mouse.isButtonDown(0) && !clickTransition) { 
				Sounds.play(Sounds.click, AudioType.SFX);
				GameManager.toggleGamePause(); 
				clickCooldown = new Cooldown(Constants.BUTTONCLICKCOOLDOWN);
				clickCooldown.reset();
				clickTransition = true;
			}
		} else {
			canPlayHoverSound = true;
			
			if (GameManager.isGamePaused()) { buttonTexture = buttonTextures[2]; }
			else { buttonTexture = buttonTextures[0]; }
		}
	}
	
	protected void buttonClickTransition() {
		if (clickCooldown.isCooldownCompleted()) {			
			clickCooldown = null;
			clickTransition = false;
		}
	}
}
