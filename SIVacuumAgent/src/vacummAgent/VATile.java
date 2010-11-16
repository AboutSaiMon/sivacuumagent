package vacummAgent;

import framework.EnvironmentObject;

public class VATile implements EnvironmentObject{
	
	public enum VATileStatus {
		CLEAN,
		DIRTY,
		BLOCK,
		UNDEFINED
	}

	VATileStatus status;
	
	public VATile() {
		super();
		status = VATileStatus.UNDEFINED;
	}

	public VATile(VATileStatus status) {
		super();
		this.status = status;
	}

	public VATileStatus getStatus() {
		return status;
	}

	public void setStatus(VATileStatus status) {
		this.status = status;
	}
}
