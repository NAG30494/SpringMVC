package org.springmvc.dao;



public class Audit extends BaseDAO {

	private long objectId;
	private String objectName;
	private String value;

	private boolean isAudit = false;

	public boolean isAudit() {
		return isAudit;
	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getAudit() {
	
		return "";
	}

}
