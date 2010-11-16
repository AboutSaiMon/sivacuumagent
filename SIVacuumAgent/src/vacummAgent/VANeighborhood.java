package vacummAgent;

public class VANeighborhood {

	boolean north;
	boolean south;
	boolean east;
	boolean west;

	public VANeighborhood() {
		super();
		this.north = true;
		this.south = true;
		this.east = true;
		this.west = true;

	}

	public VANeighborhood(boolean north, boolean south, boolean east,
			boolean west) {
		super();
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}

	public boolean northIsFree() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean southIsFree() {
		return south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public boolean eastIsFree() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean weastIsFree() {
		return west;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

}
