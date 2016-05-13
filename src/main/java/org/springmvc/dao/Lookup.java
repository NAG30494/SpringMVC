package org.springmvc.dao;

public class Lookup extends BaseDAO {

	private String lookupType;
	private String lookupValue;
	
	private boolean isAudit =true;

	public Lookup() {
	}

	public Lookup(String lookupType, String lookupValue, boolean isActive) {
		super.setIsActive(isActive);
		this.lookupType = lookupType;
		this.lookupValue = lookupValue;
	}

	public String getLookupType() {
		return this.lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupValue() {
		return this.lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	@Override
	public String toString() {
		return "Lookup [lookupType=" + lookupType + ", lookupValue="
				+ lookupValue + ", isAudit=" + isAudit + ", toString()="
				+ super.toString() + "]";
	}

	public boolean isAudit() {
		return isAudit;
	}

	public void setAudit(boolean isAudit) {
		this.isAudit = isAudit;
	}		

}
