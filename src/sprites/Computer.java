package sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import main.Game;

/**
 * A class to represent a computer car on the highway in the game CrazyTaxi
 * @author Kevin Zhang
 *
 */
public class Computer extends Player {
	
	static final int MAX_SPEED = 8;
	static final int MIN_SPEED = 1;
	static final int MAX_START_POSITION = -100;
	static final int MIN_START_POSITION = 0;
	
	static final int MAX_COLOR = 255;
	static final int MIN_COLOR = 0;
	
	private Random random = new Random();
	private float speed;
	private float counter;
	private Color color;
	
	/**
	 * Creates a new Computer at the given location
	 * @param xcoord the given x-coordinate of the computer
	 * @param ycoord the given y-coordinate of the computer
	 */
	public Computer(int xcoord, int ycoord) {
		super(xcoord, ycoord);
		this.speed = random.nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
		this.color = new Color(random.nextInt(MAX_COLOR - MIN_COLOR + 1), 
				random.nextInt(MAX_COLOR - MIN_COLOR + 1), random.nextInt(MAX_COLOR - MIN_COLOR + 1));
		this.counter = 0;
	}
	
	/* (non-Javadoc)
	 * @see sprites.Player#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(xcoord, ycoord, WIDTH, HEIGHT);
	}
	
	/* (non-Javadoc)
	 * @see sprites.Player#move()
	 */
	@Override
	public void move() {
		this.ycoord += speed + counter;
		counter += 0.001f;
		
		if (ycoord > Game.HEIGHT) {
			speed = random.nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
			ycoord = -300;
			color = new Color(random.nextInt(MAX_COLOR - MIN_COLOR + 1), 
					random.nextInt(MAX_COLOR - MIN_COLOR + 1), random.nextInt(MAX_COLOR - MIN_COLOR + 1));
		}
	}
	
}
