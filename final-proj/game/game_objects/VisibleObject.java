package game.game_objects;

import java.awt.Rectangle;

public abstract class VisibleObject {
	public int x;
	public int y;
	public int xVelocity;
	public int yVelocity;
	
	public int width;
	public int height;
	
	public abstract void render();
	
	public void update() {
		x += xVelocity;
		y += yVelocity;
		render();
	}
	
	public boolean isColliding(VisibleObject other) {
		Rectangle rect1 = new Rectangle(this.x, this.y, this.width, this.height);
		Rectangle rect2 = new Rectangle(other.x, other.y, other.width, other.height);
//		System.out.println("B1: " + this.x + " " + this.y + " " + this.width + " " + this.height);
//		System.out.println("B2: " + other.x + " " + other.y + " " + other.width + " " + other.height);
		return rect1.intersects(rect2);
	}
	
	public VisibleObject(int width, int height) {
		this.width = width;
		this.height = height;
		x = 0;
		y = 0;
		xVelocity = 0;
		yVelocity = 0;
	}
}
