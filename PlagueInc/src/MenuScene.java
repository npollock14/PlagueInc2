import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuScene extends Scene {
	Poly p;

	@Override
	public void draw(Graphics g) {
		
			p.draw(g, false);
		
		
		g.setFont(Misc.fBig);
		double start = System.currentTimeMillis();
		g.drawString("" + p.surrounds(InputManager.mPos) + " n=" + p.numVerts() + " " + (System.currentTimeMillis() - start) + "ms", Driver.screenWidth / 2, Driver.screenHeight / 2);
		
		g.drawString("" + InputManager.mPos.toString(), Driver.screenWidth / 2, Driver.screenHeight / 2 + 250);
		
	}

	@Override
	public void update() {
if(InputManager.mouse[1]) {
	if(p.numVerts() == 0) {
		p.addVerts(InputManager.mPos);
		p.addVerts(InputManager.mPos);
	}else {
		for(int i = 0; i < 1; i++) {
		p.addVert(p.numVerts()-1, InputManager.mPos);
		}
		
	}
	
	System.out.println(InputManager.mPos.toString());
	
}
	}

	@Override
	public void init() {
		p = new Poly();
		//100, 100, 150, 150, 50, 150, 100, 100
	}

}
