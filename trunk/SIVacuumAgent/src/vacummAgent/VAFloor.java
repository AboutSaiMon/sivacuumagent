package vacummAgent;

import java.awt.Point;

import vacummAgent.VATile.VATileStatus;

public class VAFloor {

	int size;
	VATile floor[][];

	public VAFloor() {
		super();
		this.size = 0;
		this.floor = null;
	}

	public VAFloor(int size) {
		super();
		this.size = size;
		this.floor = new VATile[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.floor[i][j] = new VATile();
			}
		}
	}

	public VATile getTile(Point p) {

		if (p.x > size || p.y > size || p.x < 0 || p.y < 0) {
			return new VATile(VATileStatus.BLOCK);
		}

		return floor[p.x][p.y];
	}

	public int getSize() {
		return size;
	}

	public VATile[][] getFloor() {
		return floor;
	}

	public void setFloor(VATile[][] floor) {

		this.size = floor.length;
		this.floor = floor;
	}

}
