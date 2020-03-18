import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Driver extends JPanel
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	static Font fb = new Font("Press Start", 0, 48);
	static Font fm = new Font("Press Start", 0, 20);
	static Font fs = new Font("Press Start", 0, 11);
	static int screenWidth = 1920;
	static int screenHeight = 1040;
	static Point windowLoc = new Point();
	static JFrame frame;
	ArrayList<Long> fps = new ArrayList<Long>();
	long frameStart = 0;
	
	  //==================================__________________=========================================\\
	//===================================/|\ GITHUB STUFF /|\==========================================\\
	 //==================================````````````````````=========================================\\
	
	//no direct commits to master unless u cool
	//make sure ur on ur branch when ur messing with things
	//try to comment ur code
	
	
	/* 
	 * To Make Your Branch the Same as Master Again:
	 *      - Commit/Push ur branch
	 *      - Right click the repository
	 *      - Reset
	 *      - Click master & Reset type = hard
	 *      - Then right click the repository
	 *      - push branch
	 *      - preview
	 *      - push
	 */
	
	/*
	 * To Merge Your Branch With Master *Once its 100% Working*
	 *      - Commit/Push ur branch
	 *      - Right click the repository
	 *      - switch to master
	 *      - right click repository
	 *      - merge
	 *      - click your branch + merge
	 *      - right click repository + push branch master
	 *      - switch back to ur branch
	 */
	
	

	public void paint(Graphics g) { // main paint		
		super.paintComponent(g);
		SceneManager.draw(g);
		
		
		//FPS COUNTER
		g.setFont(fs);
		fps.add((long) (1 / ((System.nanoTime() - frameStart) / Math.pow(10, 9))));
		if (fps.size() >= 60) {
			fps.remove(0);
		}
		double sum = 0;
		for (Long d : fps) {
			sum += d;
		}
		double avg = sum / fps.size();
		g.drawString((int) avg + "", screenWidth - 50, 25);
		frameStart = System.nanoTime();

	}

	public void update() throws InterruptedException { // main update
		SceneManager.update();
	}

	private void init() {
		SceneManager.initManager();
		SceneManager.ms.init();
		SceneManager.ms.setActive(true);
		SceneManager.gs.init();
	//	SceneManager.gs.setActive(true);
	}

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			InputManager.mPos = getMousePos();

			update();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
		InputManager.update();

	}

	public Point getMousePos() {
		try {
			return new Point(this.getMousePosition().x, this.getMousePosition().y);
		} catch (Exception e) {
			return InputManager.mPos;
		}
	}

	public static void main(String[] arg) {
		@SuppressWarnings("unused")
		Driver d = new Driver();
	}

	public Driver() {

		init();

		frame = new JFrame();
		frame.setTitle("CS Q3 Game");
		frame.setSize(screenWidth, screenHeight);
		frame.setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.addMouseMotionListener(this);
		frame.addMouseWheelListener(this);
		frame.addMouseListener(this);

		frame.add(this);

		t = new Timer(15, this);
		t.start();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		InputManager.keys[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		InputManager.setKeyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		InputManager.mouse[e.getButton()] = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		InputManager.mouse[e.getButton()] = false;
		InputManager.mouseReleased[e.getButton()] = true;
		InputManager.resetMouseReleased = true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		InputManager.mouse[e.getButton()] = true;

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
