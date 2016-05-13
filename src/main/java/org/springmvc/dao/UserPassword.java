package org.springmvc.dao;

import java.io.Serializable;
import java.sql.Timestamp;


@SuppressWarnings("serial")
public class UserPassword extends BaseDAO implements Serializable {
	private String currPassword;
	private String recentPassword;
	private String lastPassword;
	private int passwordAttempt;
	private boolean isUserLocked;
	private Timestamp passwordExpiryDate;

	private User user;

	public UserPassword() {
	}

	public Timestamp getPasswordExpiryDate() {
		return passwordExpiryDate;
	}

	public void setPasswordExpiryDate(Timestamp passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
	}

	public void setUserLocked(boolean isUserLocked) {
		this.isUserLocked = isUserLocked;
	}

	public String getCurrPassword() {
		return currPassword;
	}

	public void setCurrPassword(String currPassword) {
		this.currPassword = currPassword;
	}

	public String getRecentPassword() {
		return recentPassword;
	}

	public void setRecentPassword(String recentPassword) {
		this.recentPassword = recentPassword;
	}

	public String getLastPassword() {
		return lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	public int getPasswordAttempt() {
		return passwordAttempt;
	}

	public void setPasswordAttempt(int passwordAttempt) {
		this.passwordAttempt = passwordAttempt;
	}

	public boolean getIsUserLocked() {
		return isUserLocked;
	}

	public void setIsUserLocked(boolean isUserLocked) {
		this.isUserLocked = isUserLocked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public String getAudit() {
	
		return "";
	}


}
