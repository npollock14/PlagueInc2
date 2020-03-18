import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameScene extends Scene{
BufferedImage map;
double sizeRatio = 1.1;
Color darkGrey = new Color(40,40,40);
	@Override
	public void draw(Graphics g) {
		g.setColor(darkGrey);
		g.fillRect(0, 0, Driver.screenWidth, Driver.screenHeight);
		g.drawImage(map, 260, 0, (int)(map.getWidth()/sizeRatio), (int)(map.getHeight()/sizeRatio),null);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void init() {
		map = Misc.loadImage("/USA-states.png");
	}

}
