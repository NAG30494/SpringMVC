package org.springmvc.dao;

public class LoginHistory  extends BaseDAO  {
	

	private long userId;
	private String ipAddress;
	private String jSessionId;
	private boolean isSuccess;
	
	
	
	public LoginHistory() {
		super();
	}
	public LoginHistory(long userId, String ipAddress, String jSessionId) {
		super();
		this.userId = userId;
		this.ipAddress = ipAddress;
		this.jSessionId = jSessionId;
	}
	
	
	
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getjSessionId() {
		return jSessionId;
	}
	public void setjSessionId(String jSessionId) {
		this.jSessionId = jSessionId;
	}
	@Override
	public String toString() {
		return "LoginHistory [getUserId()=" + getUserId() + ", getIpAddress()="	+ getIpAddress() + ", getjSessionId()=" + getjSessionId() + "]";
	}
	@Override
	public String getAudit() {
		
		return "";
	}

	
	

}
