package vacummAgent.environment;

import java.awt.Point;

import vacummAgent.VAFloor;
import vacummAgent.VANeighborhood;
import vacummAgent.VAPercept;
import vacummAgent.VATile.VATileStatus;
import framework.Agent;

public class VAEnvNonObservable extends VAEnvironment {

	public VAEnvNonObservable(Agent vacuumAgent, Point vacuumAgentPosition, VAFloor floor) {
		super(vacuumAgent, vacuumAgentPosition, floor);
	}

	@Override
	protected VAPercept genPerception() {

		VATileStatus currentTileStatus = floor.getTile(vacuumAgentPosition)
				.getStatus();
		VANeighborhood neighborhood = this.getNeighborhood(vacuumAgentPosition);
		VAFloor undefFloor = new VAFloor(floor.getSize());
		VAPercept percept = new VAPercept(undefFloor, null, currentTileStatus,
				neighborhood);
		return percept;
	}

}
