import java.util.Random;

import processing.core.PApplet;

public class Terrian extends PApplet {

	Random r;

	public void setup() {
		size(800, 800);

		r = new Random();

		terrianLine(400, 400, 400, 400, 20, 100);

	}

	public void mouseReleased() {
		background(255);
		terrianLine(400, 400, 400, 400, 20, 100);
	}

	public void draw() {
		// background(255);
		// terrianLine(0, 300, 800, 300, 6, 300);
	}

	public void terrianLine(float x1, float y1, float x2, float y2, int lvl, double var) {

		if (lvl == 1) {
			line(x1, y1, x2, y2);
			return;
		}

		float midx = (x1 + x2) / 2;
		float midy = (y1 + y2) / 2;

		midx += r.nextGaussian() * 2 * var - var;
		midy += r.nextGaussian() * 2 * var - var;

		terrianLine(x1, y1, midx, midy, lvl - 1, var * 0.5);
		terrianLine(midx, midy, x2, y2, lvl - 1, var * 0.5);

	}

}
