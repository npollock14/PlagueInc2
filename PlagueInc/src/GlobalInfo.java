import java.util.ArrayList;

public abstract class GlobalInfo {
//INFO FOR GAME
	static int totalPopulation = 327200000;
	static int totalSick = 0;
	static int totalHealthy = 327200000;
	static ArrayList<State> states = new ArrayList<State>();
	static State california = new State("California", 39560000, .75, .95, 251.3, 72, new Poly(0,0,100,0,100,100,0,100,0,0));
	
	
	public static void init() {
		states.add(california);
	}
}
