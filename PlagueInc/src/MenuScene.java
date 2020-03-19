import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuScene extends Scene {
	
	Button buttonStart;
	
	BufferedImage menuBackground;
	
	Font fntSmall = new Font("Impact", 0, 35);
	
	public void draw(Graphics g) {
	
		g.drawImage(menuBackground, 0, -30, Driver.screenWidth, Driver.screenHeight, null);
		
		buttonStart.draw(g, 110, 38);
	}

	
	public void update() {
		buttonStart.update();
		
		if (buttonStart.clicked) {
			
			SceneManager.gs.setActive(true);
			SceneManager.ms.setActive(false);
			
		}
	}

	public void init() {
		menuBackground = Misc.loadImage("/PlagueMenuBackground.png");
		
		buttonStart = new Button(new Rect(780, 400, 300, 50), null, 0, "Start", fntSmall, Color.GRAY, true, false);
	}

}
