package org.springmvc.dao.views;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class ViewUserPassword implements Serializable {

	/**
	 * LOGIN_USERS.ID , LOGIN_USERS.USER_NAME , LOGIN_USERS.FIRST_NAME ,
	 * LOGIN_USERS.LAST_NAME , LOGIN_USERS.USER_ROLE , LOGIN_USERS.GENDER ,
	 * LOGIN_USERS.IS_ACTIVE , USER_PASSWORD.CURR_PASSWORD ,
	 * USER_PASSWORD.RECENT_PASSWORD , USER_PASSWORD.LAST_PASSWORD ,
	 * USER_PASSWORD.PASSWORD_ATTEMPTS , USER_PASSWORD.PASSWORD_EXPIRY_DATE ,
	 * USER_PASSWORD.IS_USER_LOCKED
	 */

	private long id;
	
	private String userName;
	private String firstName;
	private String lastName;
	private long gender;
	private long userRole;
	private boolean isActive;
	private String currPassword;
	private String recentPassword;
	private String lastPassword;
	private int passwordAttempt;
	private boolean isUserLocked;
	private Timestamp passwordExpiryDate;

	public ViewUserPassword() {
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUserLocked(boolean isUserLocked) {
		this.isUserLocked = isUserLocked;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getGender() {
		return gender;
	}

	public void setGender(long gender) {
		this.gender = gender;
	}

	public long getUserRole() {
		return userRole;
	}

	public void setUserRole(long userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the currPassword
	 */
	public String getCurrPassword() {
		return currPassword;
	}

	/**
	 * @param currPassword
	 *            the currPassword to set
	 */
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

	public Timestamp getPasswordExpiryDate() {
		return passwordExpiryDate;
	}

	public void setPasswordExpiryDate(Timestamp passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
	}

	
	public String toString() {
		return String
				.format("ViewUserPassword [getFirstName()=%s, getGender()=%s, getLastName()=%s, getLastPassword()=%s, getPasswordAttempt()=%s, getPasswordExpiryDate()=%s, getRecentPassword()=%s,  getUserName()=%s, getUserPassword()=%s, getUserRole()=%s, isUserLocked()=%s]",
						getFirstName(), getGender(), getLastName(),
						getLastPassword(), getPasswordAttempt(),
						getPasswordExpiryDate(), getRecentPassword(),
						getUserName(), getCurrPassword(), getUserRole(),
						getIsUserLocked());
	}

}