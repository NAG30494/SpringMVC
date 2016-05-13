package org.springmvc.service;

import java.util.List;
import java.util.Map;

import org.springmvc.dao.User;

public interface UserService {
	public List<User> getUserList();	
	public Map<Long,String> getLookup(String lookupType);
	public User getUserById(long userID);
	public Map<String,String> changePassword(long userId, String currentPassword,String newPassword,String repeatPassword);
	public boolean saveUser(User user );
	public boolean removeUser(User user );

}
