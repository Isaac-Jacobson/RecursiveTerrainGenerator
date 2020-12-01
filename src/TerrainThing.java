import processing.core.PApplet;

public class TerrainThing extends PApplet {
	float scale = 10;
	float verticalScale = 15;
	float angle = 0;
	int rows, cols;
	float[][] terrain;

	public void setup() {
		size(601, 601, P3D);

		rows = (int) (width / scale);
		cols = (int) (height / scale);

		terrain = new float[rows][cols];

		genTerrain(terrain, 0, rows - 1, 0, cols - 1, 20);
	}

	// public void genTerrain(float[][] array, float angle) {
	// for (int row = 0; row < array.length; row++) {
	// for (int col = 0; col < array[0].length; col++) {
	// array[row][col] = (float) (Math.sin(col + 20 * angle) + Math.sin(row));
	// }
	// }
	// }

	public void genTerrain(float[][] arr, int row1, int row2, int col1, int col2, float var) {

		if (row2 - row1 <= 1 || col2 - col1 <= 1) {
			return;
		}

		int midRow = (int) (row1 + row2) / 2;
		int midCol = (int) (col1 + col2) / 2;

		arr[row1][midCol] = (float) (((arr[row1][col1] + arr[row1][col2]) / 2) + ((Math.random() * var) - var / 2));
		arr[row2][midCol] = (float) (((arr[row2][col1] + arr[row2][col2]) / 2) + ((Math.random() * var) - var / 2));
		arr[midRow][col1] = (float) (((arr[row1][col1] + arr[row2][col1]) / 2) + ((Math.random() * var) - var / 2));
		arr[midRow][col2] = (float) (((arr[row1][col2] + arr[row2][col2]) / 2) + ((Math.random() * var) - var / 2));

		arr[midRow][midCol] = (float) (((arr[row1][col1] + arr[row1][col2] + arr[row2][col1] + arr[row2][col2]) / 4)
				+ ((Math.random() * var) - var / 2));

		genTerrain(arr, row1, midRow, col1, midCol, var * 0.4f);
		genTerrain(arr, row1, midRow, midCol, col2, var * 0.4f);
		genTerrain(arr, midRow, row2, col1, midCol, var * 0.4f);
		genTerrain(arr, midRow, row2, midCol, col2, var * 0.4f);

	}

	public void genTerrainPoint(float[][] arr, int row, int col) {

		float sum = 0;
		int counter = 0;

		if (col + 1 < arr[0].length) {
			sum += arr[row][col + 1];
			counter++;
		}
		if (col - 1 >= 0) {
			sum += arr[row][col - 1];
			counter++;
		}
		if (row + 1 < arr.length) {
			sum += arr[row + 1][col];
			counter++;
		}
		if (row - 1 >= 0) {
			sum += arr[row + 1][col];
			counter++;
		}

		arr[row][col] = (float) ((sum / counter) + (Math.random() * 2) - 4);
	}

	public void draw() {
		background(0);
		stroke(0, 0, 0);
		// fill(0, 255, 0);
		fill(0, 0, 0);

		translate(width / 2, height / 2);
		rotateX(PI / 3);
		rotateZ(angle);
		// rotateY(angle);
		translate(-width / 2, -height / 2);
		angle += 0.01f;

		// genTerrain(terrain, angle);

		// Make this based on percentages
		float upperThreshold = 5;

		// Make this based on percentages
		float lowerThreshold = 1;

		for (int row = 0; row < terrain.length - 1; row++) {
			beginShape(TRIANGLE_STRIP);

			for (int col = 0; col < terrain[row].length; col++) {

				if (terrain[row][col] == 0) {
					genTerrainPoint(terrain, row, col);
				}

				if (terrain[row][col] > upperThreshold) {
					fill(133, 137, 125);
				} else if (terrain[row][col] > lowerThreshold) {
					fill(85, 226, 72);
				} else {
					fill(0, 0, 255);
				}

				// System.out.print(terrain[row][col] + " | ");

				vertex(col * scale, row * scale, verticalScale * terrain[row][col]);
				vertex(col * scale, (row + 1) * scale, verticalScale * terrain[row + 1][col]);
			}

			// System.out.println();

			endShape();
		}

	}

}
