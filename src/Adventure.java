import processing.core.PApplet;

public class Adventure extends PApplet {

	public void setup() {
		size(800, 800);

		// rect(300, 300, 300, 300);
		mysteryShape(400, 400, 400, 7);

	}

	public void mysteryShape(int x, int y, int rad, int n) {
		rect(x - (rad / 2), y - (rad / 2), rad, rad);

		if (n == 0) {
			return;
		}

		mysteryShape(x + rad / 2, y + rad / 2, rad / 2, n - 1);
		mysteryShape(x - rad / 2, y + rad / 2, rad / 2, n - 1);
		mysteryShape(x + rad / 2, y - rad / 2, rad / 2, n - 1);
		mysteryShape(x - rad / 2, y - rad / 2, rad / 2, n - 1);

	}

}
