import java.awt.Graphics;

public class State {
	String name;
	int population;
	int sick;
	int healthy;
	double humidity;// (-1   to   1)
	double wealthy;// (0-1)
	double popDensity;// (0-1)
	double temperature;//
	Poly bounds;
	
	
	
	public State(String name, int population, double humidity, double wealthy, double popDensity,
			double temperature, Poly bounds) {
		this.name = name;
		this.population = population;
		this.sick = 0;
		this.healthy = population;
		this.humidity = humidity;
		this.wealthy = wealthy;
		this.popDensity = popDensity/90.0;
		this.temperature = temperature;
		this.bounds = bounds;
	}
	
	public boolean clicked() {
		return bounds.surrounds(InputManager.mPos) && InputManager.mouseReleased[1];
	}



	public void update() { //updates for one day - adding new infections
		
	}
	
	public void draw(Graphics g) {
		bounds.draw(g, true);
	}

}
