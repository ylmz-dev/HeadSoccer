import java.awt.Graphics;

public class Ball extends Sphere {

	public Ball(int x, int y, int r) {
		super(x, y, r);
	}

	@Override
	public void draw(Graphics g) {
		g.fillOval((int) getX() - getRadius() / 2, (int) getY() - getRadius() / 2, getRadius(), getRadius());

	}

	@Override
	public void collision(Player b) {

		if ((b.getRadius() + getRadius()) / 2 >= Math
				.sqrt(Math.pow(b.getX() - getX(), 2) + Math.pow(b.getY() - getY(), 2))) {

			b.setvY(0);
			b.setvX(0);
			if (b.getX() < this.getX()) {

				this.setvX(+10);

			} else {
				this.setvX(-10);
			}

			if (b.getY() > this.getY()) {

				this.setvY(-10);

			} else {
				this.setvY(+10);
			}
			b.setvY(10);
		}
	}

	

	public void setY(int y) {
		if (y < 768 && y > 0) {
			super.setY(y);
		}

		else {

			setvY(getvY() * -1);
		}

	}

}