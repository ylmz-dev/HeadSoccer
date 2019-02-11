import java.awt.Graphics;

public class Player extends Sphere {
	public Player(int x, int y, int r) {
		super(x, y, r);
	}

	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void draw(Graphics g) {
		g.fillOval((int) getX() - getRadius() / 2, (int) getY() - getRadius() / 2, getRadius(), getRadius());

	}

	
	


}
