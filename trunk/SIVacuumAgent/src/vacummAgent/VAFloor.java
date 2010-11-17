package vacummAgent;

import java.awt.Point;

import vacummAgent.VATile.VATileStatus;

public class VAFloor {

	private int size;
	VATile floor[][];

	public VAFloor() {
		super();
		this.setSize(0);
		this.floor = null;
	}

	public VAFloor(int size) {
		super();
		this.setSize(size);
		this.floor = new VATile[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.floor[i][j] = new VATile();
			}
		}
	}

	public VATile getTile(Point p) {

		if (p.x > getSize() || p.y > getSize() || p.x < 0 || p.y < 0) {
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

		this.setSize(floor.length);
		this.floor = floor;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
