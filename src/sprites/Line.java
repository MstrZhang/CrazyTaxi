package sprites;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

/**
 * A class to represent the lines on the highway
 * @author Kevin Zhang
 *
 */
public class Line {
	
	static final int WIDTH = 10;
	static final int HEIGHT = 100;
	static final int DELIMITER = 50;
	
	private int xcoord;
	private int ycoord;
	private float speed;
	
	/**
	 * Creates a new line object with the given x-coordinate
	 * The y-coordinate is not needed because all lines start from the same y-coordinate
	 * @param xcoord the given x-coordinate of the line
	 */
	public Line(int xcoord) {
		this.xcoord = xcoord;
		this.ycoord = -100;
		this.speed = 2f;
	}
	
	/**
	 * Draws the lines on the screen
	 * @param g the Java Graphics object required to draw objects onto the screen
	 */
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(xcoord, ycoord - HEIGHT - DELIMITER, WIDTH, HEIGHT);
		g.fillRect(xcoord, ycoord, WIDTH, HEIGHT);
		g.fillRect(xcoord, ycoord + HEIGHT + DELIMITER, WIDTH, HEIGHT);
		g.fillRect(xcoord, ycoord + 2 * HEIGHT + 2 * DELIMITER, WIDTH, HEIGHT);
		g.fillRect(xcoord, ycoord + 3 * HEIGHT + 3 * DELIMITER, WIDTH, HEIGHT);
		g.fillRect(xcoord, ycoord + 4 * HEIGHT + 4 * DELIMITER, WIDTH, HEIGHT);
		g.fillRect(xcoord, ycoord + 5 * HEIGHT + 5 * DELIMITER, WIDTH, HEIGHT);

	}
	
	/**
	 * Moves the lines on the screen
	 */
	public void move() {
		ycoord += speed;
		
		if ((ycoord + 5 * HEIGHT + 5 * DELIMITER) > Game.HEIGHT) {
			ycoord = -100;
		}
	}

}
