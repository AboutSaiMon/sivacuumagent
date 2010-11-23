package vacuumAgent;

import framework.Action;
import framework.Agent;
import framework.Percept;

public abstract class VAAgent implements Agent{
	
	protected int energy;
	
	public VAAgent(int energy) {
		super();
		this.energy = energy;
	}
	
	

	public int getEnergy() {
		return energy;
	}



	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public void spendEnergy()
	{
		this.energy--;
	}



	@Override
	public Action execute(Percept percept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAlive(boolean alive) {
		// TODO Auto-generated method stub
		
	}

}
