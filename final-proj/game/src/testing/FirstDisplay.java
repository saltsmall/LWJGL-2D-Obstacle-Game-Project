package testing;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;




public class FirstDisplay {
	public static void main(String[] args) {
		try {
			Display.setDisplayMode(new DisplayMode(200, 50));
			Display.setTitle("A fresh display!");
			Display.create();
		}
		catch(LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		while(!Display.isCloseRequested()) {
			if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				System.out.println("blaa");
			}
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
//		System.exit(0);
	}
}
