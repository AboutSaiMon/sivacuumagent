package vacummAgent;

public class VANeighborhood {

	boolean north;
	boolean south;
	boolean east;
	boolean west;
	
	public VANeighborhood(boolean north, boolean south, boolean east,
			boolean west) {
		super();
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}
	public boolean isNorth() {
		return north;
	}
	public void setNorth(boolean north) {
		this.north = north;
	}
	public boolean isSouth() {
		return south;
	}
	public void setSouth(boolean south) {
		this.south = south;
	}
	public boolean isEast() {
		return east;
	}
	public void setEast(boolean east) {
		this.east = east;
	}
	public boolean isWest() {
		return west;
	}
	public void setWest(boolean west) {
		this.west = west;
	}
	
	
	
	
}
