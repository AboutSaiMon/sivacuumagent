package vacummAgent;

import java.awt.Point;

import vacummAgent.VATile.VATileStatus;

import framework.Percept;


public class VAPercept implements Percept{

	VAFloor floor;
	Point vacuumAgentPosition;
	VATileStatus currentTileStatus;
	VANeighborhood neighborhood;
	
	
	public VAPercept(VAFloor floor, Point vacuumAgentPosition,
			VATileStatus currentTileStatus, VANeighborhood neighborhood) {
		super();
		this.floor = floor;
		this.vacuumAgentPosition = vacuumAgentPosition;
		this.currentTileStatus = currentTileStatus;
		this.neighborhood = neighborhood;
	}


	public VAFloor getFloor() {
		return floor;
	}


	public void setFloor(VAFloor floor) {
		this.floor = floor;
	}


	public Point getVacuumAgentPosition() {
		return vacuumAgentPosition;
	}


	public void setVacuumAgentPosition(Point vacuumAgentPosition) {
		this.vacuumAgentPosition = vacuumAgentPosition;
	}


	public VATileStatus getCurrentTileStatus() {
		return currentTileStatus;
	}


	public void setCurrentTileStatus(VATileStatus currentTileStatus) {
		this.currentTileStatus = currentTileStatus;
	}


	public VANeighborhood getNeighborhood() {
		return neighborhood;
	}


	public void setNeighborhood(VANeighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	
	
	
	
	
	
	
}
