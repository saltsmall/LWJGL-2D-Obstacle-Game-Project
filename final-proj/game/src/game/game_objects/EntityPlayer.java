package game.game_objects;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import managers.GameManager;
import managers.Textures;
import utilities.*;

public class EntityPlayer extends Entity {

	private VisibleObject flame;
	private boolean instantiateFlame;
	
	private Texture[] PFrames = Textures.playerPFrames, BFrames = Textures.playerBFrames, WFrames = Textures.playerWFrames, 
			WLFrames = Textures.playerWLFrames, WRFrames = Textures.playerWRFrames, JFrames = Textures.playerJFrames, FFrames = Textures.playerFFrames;
	
	public EntityPlayer(int x, int y, double playeranimationfps) {
		super(x, y, playeranimationfps);
		this.width = Constants.UNITSIZE;
		this.height = Constants.UNITSIZE*2;
		isJumping = false;
		isMoving = false;
		isFalling = false;
		reverseAnim = false;
		instantiateFlame = false;
		animator.setFrames(WRFrames);	// default
		lives = 1 + (int)(Math.random()*5);	// 1-5 lives (discrete of course)
	}
	
	public void update() {	
		super.update();
		
		if (GameManager.isLostLifeOrLostTransition() && !instantiateFlame) { 
			flame = new Flame(x - (Constants.UNITSIZE/2), y - (Constants.UNITSIZE*2));
			instantiateFlame = true;
		}
		
		if (flame != null && GameManager.isLostLifeOrLostTransition()) { flame.update(); }
		
		if (!GameManager.isLostLifeOrLostTransition()) { 
			instantiateFlame = false; 
			flame = null;
		}
		
		handleAnimations();
		handleSounds();
	}
	
	public void render() {	
		if (flame != null && GameManager.isLostLifeOrLostTransition()) { flame.render(); }
		Textures.render(selectAnimationFrame(), x, y, Constants.UNITSIZE, Constants.UNITSIZE*2);
	}
	
	protected void handleAnimations() {	
		if (GameManager.isWinTransition()) {
			reverseAnim = true;
			isMoving = true;	// so that the animation can be played out
			animator.setFrames(WFrames);
		} 
		else if (GameManager.isLostLifeOrLostTransition() || GameManager.isOutOfTimeTransition()) {	// out of time and lost life (from lava) animations can be played simultaneously
			if (GameManager.isLostLifeOrLostTransition()) {
				reverseAnim = true;
				isMoving = true;	// so that the animation can be played out
				animator.setFrames(BFrames);
			}
			if (GameManager.isOutOfTimeTransition()) {
				reverseAnim = false;
				isMoving = true;	// so that the animation can be played out
				animator.setFrames(PFrames);
			}
		} else {
			// Vertical movement animations take precedence over horizontal movement animations
			super.handleAnimations();	// put here so that during the transitions, the zero movement animation code will not freeze the winning/dying player animations
			if (yVelocity < 0) {
				reverseAnim = true;
				animator.setFrames(JFrames);
			} else if (yVelocity > 0) {
				reverseAnim = true;
				animator.setFrames(FFrames);
			} else {	
				if (!(animator.getCurrentFrames() == WRFrames || animator.getCurrentFrames() == WLFrames) && !isJumping) { // if finished falling
					reverseAnim = false;
					animator.setFrames(WRFrames); // default
				}
	
				if (xVelocity > 0) {
					reverseAnim = true;
					animator.setFrames(WRFrames);
				} else if (xVelocity < 0) {
					reverseAnim = true;
					animator.setFrames(WLFrames);
				} 
			}
		}
	}
	
	protected void handleSounds() {
		super.handleSounds();
	}

	public void collideStop(ArrayList<VisibleObject> collidables) {
		this.x += 13;
		this.width -= 26;
		this.height -= 5;
		super.collideStop(collidables);
		this.x -= 13;
		this.width += 26;
		this.height += 5;	
	}
	
	// getters/setters
	public int getLives() { return super.getLives(); }
	public void setLives(int lives) { super.setLives(lives); }
}
