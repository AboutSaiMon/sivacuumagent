package vacummAgent.environment;

import java.awt.Point;

import vacummAgent.VAFloor;
import vacummAgent.VANeighborhood;
import vacummAgent.VAPercept;
import vacummAgent.VATile.VATileStatus;
import framework.Agent;

public class VAEnvObservable extends VAEnvironment {

	public VAEnvObservable(Agent vacuumAgent, Point vacuumAgentPosition, VAFloor floor) {
		super(vacuumAgent, vacuumAgentPosition, floor);
	}

	@Override
	protected VAPercept genPerception() {
		VATileStatus currentTileStatus = floor.getTile(vacuumAgentPosition)
				.getStatus();
		VANeighborhood neighborhood = this.getNeighborhood(vacuumAgentPosition);
		VAPercept percept = new VAPercept(this.floor, this.vacuumAgentPosition,
				currentTileStatus, neighborhood);
		return percept;
	}

}
