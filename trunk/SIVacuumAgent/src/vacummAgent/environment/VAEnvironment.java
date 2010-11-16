package vacummAgent.environment;

import java.awt.Point;

import vacummAgent.VAAction;
import vacummAgent.VAAction.VAActionType;
import vacummAgent.VAFloor;
import vacummAgent.VANeighborhood;
import vacummAgent.VAPercept;
import vacummAgent.VATile.VATileStatus;

import framework.Agent;
import framework.Environment;


public abstract class VAEnvironment implements Environment{
	
	protected Agent vacuumAgent;
	protected Point vacuumAgentPosition;
	protected VAFloor floor;
	
	
	public VAEnvironment(Agent vacuumAgent, Point vacuumAgentPosition,
			VAFloor floor) {
		super();
		this.vacuumAgent = vacuumAgent;
		this.vacuumAgentPosition = vacuumAgentPosition;
		this.floor = floor;
	}


	public Agent getVacuumAgent() {
		return vacuumAgent;
	}



	public void setVacuumAgent(Agent vacuumAgent) {
		this.vacuumAgent = vacuumAgent;
	}

	
	protected VAPercept genPerception(){
		return null;
	}
	
	@Override
	public void step() throws RuntimeException{
		VAPercept percept = this.genPerception();
		VAAction action = (VAAction) vacuumAgent.execute(percept);
		VANeighborhood neighborhood = this.getNeighborhood(vacuumAgentPosition);
		
		if(action.getActionType() == VAActionType.SUCK){
			floor.getTile(vacuumAgentPosition).setStatus(VATileStatus.CLEAN);
		}
		if(action.getActionType() == VAActionType.MOVENORTH){			
			if(!neighborhood.isNorth()){
				throw new RuntimeException("Illegal Move!");
			}		
			vacuumAgentPosition.x++;
		}
		if(action.getActionType() == VAActionType.MOVESOUTH){
			if(!neighborhood.isSouth()){
				throw new RuntimeException("Illegal Move!");
			}
			vacuumAgentPosition.x--;
		}
		if(action.getActionType() == VAActionType.MOVEWEST){
			if(!neighborhood.isWest()){
				throw new RuntimeException("Illegal Move!");
			}
			vacuumAgentPosition.y--;
		}
		if(action.getActionType() == VAActionType.MOVEEAST){
			if(!neighborhood.isEast()){
				throw new RuntimeException("Illegal Move!");
			}
			vacuumAgentPosition.y++;
		}	
	}

	@Override
	public void step(int n) {
		for(int i = 0; i < n; i++){
			this.step();
		}
		
	}

	@Override
	public void stepUntilDone() {
		while(!isDone()){
			this.step();
		}
		
	}

	@Override
	public boolean isDone() {
		// TODO GIOVEDI
		return false;
	}

	@Override
	public double getPerformanceMeasure(Agent forAgent) {
		// TODO GIOVEDI
		return 0;
	}
	
	public VANeighborhood getNeighborhood(Point p){
		
		boolean north = true; 
		boolean south = true; 
		boolean east = true;
		boolean west = true;
		
		
		if(floor.getTile(new Point(p.x+1, p.y)).getStatus() == VATileStatus.BLOCK){ north = false; }
		if(floor.getTile(new Point(p.x-1, p.y)).getStatus() == VATileStatus.BLOCK){ south = false; }
		if(floor.getTile(new Point(p.x, p.y+1)).getStatus() == VATileStatus.BLOCK){ east = false; }
		if(floor.getTile(new Point(p.x, p.y-1)).getStatus() == VATileStatus.BLOCK){ west = false; }
		
		return new VANeighborhood(north, south, east, west);
	}

}
