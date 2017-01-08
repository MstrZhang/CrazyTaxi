package sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;

/**
 * A class to represent the main Player in the CrazyTaxi game
 * @author Kevin Zhang
 *
 */
public class Player {
	
	static final int WIDTH = 40;
	static final int HEIGHT = 70;
	static final int SPEED = 7;
	
	protected int xcoord;
	protected int ycoord;
	
	private int xspeed = 0;
	private int yspeed = 0;
	
	/**
	 * Creates a new player with the given coordinates
	 * @param xcoord the given x-coordinate of the player
	 * @param ycoord the given y-coordinate of the player
	 */
	public Player(int xcoord, int ycoord) {
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	
	/**
	 * Draws the player's sprite onto the screen
	 * @param g the Java Graphics object required to draw objects
	 */
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(xcoord, ycoord, WIDTH, HEIGHT);
	}
	
	/**
	 * Moves the player sprite
	 */
	public void move() {
		if (xcoord + xspeed > 0 && xcoord + WIDTH + xspeed < Game.WIDTH)
			xcoord += xspeed;
		if (ycoord + yspeed > 0 && ycoord + HEIGHT + yspeed < Game.HEIGHT)
			ycoord += yspeed;
	}
	
	/**
	 * Stops all horizontal movement
	 */
	public void stopHorizontal() {
		xspeed = 0;
	}
	
	/**
	 * Stops all vertical movement
	 */
	public void stopVertical() {
		yspeed = 0;
	}
	
	/**
	 * Moves the player up
	 */
	public void moveUp() {
		yspeed = SPEED * -1;
	}
	
	/**
	 * Moves the player down
	 */
	public void moveDown() {
		yspeed = SPEED;
	}
	
	/**
	 * Moves the player right
	 */
	public void moveRight() {
		xspeed = SPEED;
	}
	
	/**
	 * Moves the player left
	 */
	public void moveLeft() {
		xspeed = SPEED * -1;
	}
	
	/**
	 * Checks if the player has collided with another object
	 * @param r the Rectangle object of another object (a computer car)
	 * @return true if the player has collided with another object
	 */
	public boolean collision(Rectangle r) {
		Rectangle rect = new Rectangle(xcoord, ycoord, WIDTH, HEIGHT);
		if (rect.intersects(r)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns a Rectangle representation of the player with the player's current coordinates
	 * @return a Rectangle representation of the player
	 */
	public Rectangle getRectangle() {
		return new Rectangle(xcoord, ycoord, WIDTH, HEIGHT);
	}

}
