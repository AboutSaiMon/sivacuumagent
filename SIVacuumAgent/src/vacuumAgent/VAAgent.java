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
	public abstract Action execute(Percept percept);	

	@Override
	public abstract boolean isAlive();

	@Override
	public abstract void setAlive(boolean alive);

}
