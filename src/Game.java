import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player player1, player2;
	Ball ball;
	BufferedImage img;

	public Game() {
		player1 = new Player(1275, 220, 100);
		player2 = new Player(75, 220, 100);
		ball = new Ball(640, 700, 50);
		Timer timer = new Timer(15, this);
		addKeyListener(this);
		setFocusable(true);
		try {
			img = ImageIO.read(new File("back1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel background = new JLabel(new ImageIcon(img));

		timer.start();

	}

	@Override
	protected void paintComponent(Graphics g) {

		// Set Return

		setBackground(Color.orange);
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Random numGen = new Random();
		g.setColor(Color.black);
		g2.fill3DRect(5, 300, 108, 30, false);
		g2.fill3DRect(1237, 300, 108, 30, false);
		g2.fill3DRect(5, 330, 30, 420, false);
		g2.fill3DRect(1315, 330, 30, 420, false);

		Font myFont = new Font("Courier New", 1, 40);
		g.setColor(Color.red);
		g.setFont(myFont);

		g.drawString("Player1:" + Main.player1, 100, 150);
		g.drawString("Score:" + Player2Score, 100, 200);
		g.setColor(Color.blue);

		g.drawString("Player2:" + Main.player2, 950, 150);
		g.drawString("Score:" + Player1Score, 950, 200);

		myFont = new Font("Courier New", 1, 28);
		g.setFont(myFont);

		g.setColor(new Color(numGen.nextInt(256), numGen.nextInt(256), numGen.nextInt(256)));
		g.drawString("-->WARNING: This game is gonna make you addicted to itself like the weed does!! ", 0, 50);

		g.setColor(Color.cyan);
		
		ball.draw(g);
		g.setColor(Color.blue);
		
		player1.draw(g);
		g.setColor(Color.red);
	
		player2.draw(g);
		player1.move();
		player2.move();
		ball.move();

		if (player1.getY() < 420) {
			player1.setvY(10);
		}
		if (player1.getY() < 0) {
			System.out.println("h");
			player1.setvY(0);
		}
		if (player2.getY() < 420) {
			player2.setvY(10);
		}
		if (player2.getY() < 0) {
			System.out.println("h");
			player2.setvY(0);
		}

		JPanel gamePanel = new JPanel();
		Image background = Toolkit.getDefaultToolkit().createImage("back1.jpg");
		g.drawImage(background, 0, 0, null);

		/*
		 * g2.drawLine(ball.getX(), ball.getY(), player1.getX(), player1.getY());
		 * g2.drawLine(ball.getX(), ball.getY(), player2.getX(), player2.getY());
		 */

	}

	int Player1Score = 0;
	int Player2Score = 0;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		if (new Rectangle(ball.getX(), ball.getY(), 50, 50).intersects(5, 330, 30, 420)) {

			Player1Score++;
			player1.setX(1275);
			player1.setY(220);
			player2.setX(75);
			player2.setY(220);
			ball.setX(640);
			ball.setY(700);
			ball.setvX(0);
			ball.setvY(0);

		}

		if (new Rectangle(ball.getX(), ball.getY(), 50, 50).intersects(5, 300, 108, 30)
				|| new Rectangle(ball.getX(), ball.getY(), 50, 50).intersects(1257, 300, 108, 30)) {

			ball.setvX(-ball.getvX());
			ball.setvY(-ball.getvY());

		}
		if (new Rectangle(ball.getX(), ball.getY(), 50, 50).intersects(1315, 330, 30, 420)) {

			Player2Score++;
			player1.setX(1275);
			player1.setY(220);
			player2.setX(75);
			player2.setY(220);
			ball.setX(640);
			ball.setY(700);
			ball.setvX(0);
			ball.setvY(0);

		}

		ball.collision(player1);
		ball.collision(player2);
		// player2.collision(ball);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player1.setvY(-10);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player1.setvY(10);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player1.setvX(-10);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player1.setvX(10);
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player2.setvY(-10);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player2.setvY(10);
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player2.setvX(-10);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player2.setvX(10);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player1.setvX(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player1.setvX(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {

		}
		if (e.getKeyCode() == KeyEvent.VK_S) {

		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player2.setvX(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player2.setvX(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
