package org.springmvc.dao;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")

@XmlRootElement
public class User extends BaseDAO implements java.io.Serializable {

	private String userName;
	private String firstName;
	private String lastName;
	private long gender;
	private long userRole;
	private String userDescription;
	private UserPassword userPassword;
	
	public boolean isAudit() {
		return super.isAudit();
	}

	public void setAudit(boolean isAudit) {
		super.setAudit(isAudit);
	}

	public User() {
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

	public long getUserRole() {
		return userRole;
	}

	public void setUserRole(long userRole) {
		this.userRole = userRole;
	}

	public long getGender() {
		return gender;
	}

	public void setGender(long gender) {
		this.gender = gender;
	}

	public UserPassword getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(UserPassword userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	
}
