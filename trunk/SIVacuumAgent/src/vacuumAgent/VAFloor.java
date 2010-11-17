package vacuumAgent;

import java.awt.Point;

import vacuumAgent.VATile.VATileStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class VAFloor.
 */
public class VAFloor {

	/** The size. */
	private int size;
	
	/** The floor. */
	VATile floor[][];

	/**
	 * Instantiates a new vA floor.
	 */
	public VAFloor() {
		super();
		this.setSize(0);
		this.floor = null;
	}

	/**
	 * Instantiates a new vA floor.
	 *
	 * @param size the size
	 */
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

	/**
	 * Gets the tile.
	 *
	 * @param p the p
	 * @return the tile
	 */
	public VATile getTile(Point p) {

		if (p.x > getSize() || p.y > getSize() || p.x < 0 || p.y < 0) {
			return new VATile(VATileStatus.BLOCK);
		}

		return floor[p.x][p.y];
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Gets the floor.
	 *
	 * @return the floor
	 */
	public VATile[][] getFloor() {
		return floor;
	}

	/**
	 * Sets the floor.
	 *
	 * @param floor the new floor
	 */
	public void setFloor(VATile[][] floor) {

		this.setSize(floor.length);
		this.floor = floor;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
