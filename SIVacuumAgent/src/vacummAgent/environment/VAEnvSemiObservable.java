package vacummAgent.environment;

import java.awt.Point;

import framework.Agent;
import vacummAgent.VAFloor;
import vacummAgent.VANeighborhood;
import vacummAgent.VAPercept;
import vacummAgent.VATile.VATileStatus;

public class VAEnvSemiObservable extends VAEnvironment {

	public VAEnvSemiObservable(Agent vacuumAgent, Point vacuumAgentPosition,
			VAFloor floor) {
		super(vacuumAgent, vacuumAgentPosition, floor);
	}

	@Override
	protected VAPercept genPerception() {

		VATileStatus currentTileStatus = floor.getTile(vacuumAgentPosition)
				.getStatus();
		VANeighborhood neighborhood = this.getNeighborhood(vacuumAgentPosition);
		VAFloor undefFloor = new VAFloor(floor.getSize());
		VAPercept percept = new VAPercept(undefFloor, this.vacuumAgentPosition,
				currentTileStatus, neighborhood);
		return percept;
	}

}
