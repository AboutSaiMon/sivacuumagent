package vacummAgent;

import framework.Action;

public class VAAction implements Action{
	public enum VAActionType{
		SUCK,
		MOVENORTH,
		MOVESOUTH,
		MOVEWEST,
		MOVEEAST
	}
	
	VAActionType actionType;

	public VAAction(VAActionType actionType) {
		super();
		this.actionType = actionType;
	}
	
	

	public VAActionType getActionType() {
		return actionType;
	}



	public void setActionType(VAActionType actionType) {
		this.actionType = actionType;
	}



	@Override
	public boolean isNoOp() {
		return false;
	}
	
	
	
	
	
}
