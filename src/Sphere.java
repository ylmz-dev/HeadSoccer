import java.awt.Graphics;

public abstract class Sphere {
	private int x = 0, y = 0, radius;
	private double vX = 0, vY = 0, aX = 0, aY = 0;

	public Sphere(int x, int y, int r) {
		setX(x);
		setY(y);
		setRadius(r);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < 1366 && x > 0) {
			this.x = x;
		} else {
			setvX(vX * (-1));

		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (this instanceof Ball) {
			if (y < 710 && y > 0) {

				this.y = y;

			} else {
				setvY(-5);
			}

		} else if (y < 685 && y > 0) {

			this.y = y;

		}

	}

	public double getvX() {
		return vX;
	}

	public void setvX(double vX) {
		this.vX = vX;
	}

	public double getvY() {
		return vY;
	}

	public void setvY(double vY) {
		this.vY = vY;
	}

	public double getaX() {
		return aX;
	}

	public void setaX(double aX) {
		this.aX = aX;
	}

	public double getaY() {
		return aY;
	}

	public void setaY(double aY) {
		this.aY = aY;
	}

	public abstract void draw(Graphics g);

	public void move() {

		setX((int) (getX() + getvX()));

		setY((int) (getY() + getvY()));

	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void collision(Player b) {
		// TODO Auto-generated method stub
		
	}

	

	

}
