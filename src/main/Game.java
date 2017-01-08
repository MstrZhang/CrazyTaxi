package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

import sprites.Computer;
import sprites.Line;
import sprites.Player;

/**
 * CRAZYTAXI
 * 
 * There used to be this Flash game that I would see people play all the time
 * This game is inspired by that Flash game
 * @author Kevin Zhang
 *
 */
public class Game extends JComponent implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    
    private Player player = new Player(210, 720);
    
    private Computer computer1 = new Computer(0, -300);
    private Computer computer2 = new Computer(70, -300);
    private Computer computer3 = new Computer(140, -300);
    private Computer computer4 = new Computer(210, -300);
    private Computer computer5 = new Computer(280, -300);
    private Computer computer6 = new Computer(350, -300);
    
    private Line line1 = new Line(50);
    private Line line2 = new Line(120);
    private Line line3 = new Line(190);
    private Line line4 = new Line(260);
    private Line line5 = new Line(330);
    
    private int score = 0;
    private boolean endScreen = false;
    private String[] endMessages = {"too fast, too furious", 
    		"follow the posted speed limit please", "you probably didn't survive that crash", 
    		"going a little fast there bud", "unlucky", "well that was unexpected",
    		"my grandma could get a higher score than you", "kev's my name, speed's my game"};

    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    private Random random = new Random();

    /**
     * Draws all the sprites onto the screen
     * @param g the Java Graphics object required to draw 
     */
    @Override
    public void paintComponent(Graphics g)
    {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // Drawing starts here
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        line1.draw(g);
        line2.draw(g);
        line3.draw(g);
        line4.draw(g);
        line5.draw(g);
        
        computer1.draw(g);
        computer2.draw(g);
        computer3.draw(g);
        computer4.draw(g);
        computer5.draw(g);
        computer6.draw(g);
        
        player.draw(g);
        
        g.setColor(Color.WHITE);
        g.drawString("SCORE: " + score, 10, 20);
        
        // Only appears after the game has ended
        if (endScreen) {
        	g.setColor(Color.PINK);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
        	
        	g.setColor(Color.WHITE);
        	int message = random.nextInt(8);
        	g.drawString(endMessages[message], 100, 100);
        	g.drawString("FINAL SCORE: " + score, 100, 130);
        }
        // Drawing ends here
    }
    
    /**
     * Method that runs the main logic and the main game loop
     */
    public void run()
    {
        long startTime;
        long deltaTime;
        
        boolean done = false; 
        while(!done)
        {
            startTime = System.currentTimeMillis();
            
            line1.move();
            line2.move();
            line3.move();
            line4.move();
            line5.move();
            
            computer1.move();
            computer2.move();
            computer3.move();
            computer4.move();
            computer5.move();
            computer6.move();
            
            player.move();
            score += 1;
            
            // I like this style more than the very long OR statement
            if (player.collision(computer1.getRectangle())) {
            	done = true;
            	endScreen = true;
            } else if (player.collision(computer2.getRectangle())) {
            	done = true;
            	endScreen = true;
            } else if (player.collision(computer3.getRectangle())) {
            	done = true;
            	endScreen = true;
            } else if (player.collision(computer4.getRectangle())) {
            	done = true;
            	endScreen = true;
            } else if (player.collision(computer5.getRectangle())) {
            	done = true;
            	endScreen = true;
            } else if (player.collision(computer6.getRectangle())) {
            	done = true;
            	endScreen = true;
            }
            
            repaint();

            deltaTime = System.currentTimeMillis() - startTime;
            try
            {
               if(deltaTime > desiredTime)
               {
            	   Thread.sleep(1);
               } else {
            	   Thread.sleep(desiredTime - deltaTime);
               }
            } catch(Exception e) {
            	e.printStackTrace();
            }
        }
    }
    
    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Crazy Taxi");

        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.add(game);
         
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(game);
        frame.pack();
        frame.setVisible(true);

        game.run();
    }

	/**
	 * Handles the player's movement when a key is pressed
	 * @param e the received key-press from the user
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				player.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				player.moveDown();
				break;
			case KeyEvent.VK_LEFT:
				player.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				player.moveRight();
				break;
			default:
				break;
		}
	}

	/**
	 * Handles the player's movement when a key is released
	 * @param e the received key-release from the user
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				player.stopVertical();
				break;
			case KeyEvent.VK_DOWN:
				player.stopVertical();
				break;
			case KeyEvent.VK_LEFT:
				player.stopHorizontal();
				break;
			case KeyEvent.VK_RIGHT:
				player.stopHorizontal();
				break;
			default:
				break;
		}
	}

	/**
	 * Implemented abstract method from KeyListener
	 * @param e the received key-typed from the user
	 */
	@Override
	public void keyTyped(KeyEvent e) { }
}