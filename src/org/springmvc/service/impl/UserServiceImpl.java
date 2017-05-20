package org.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvc.dao.Lookup;
import org.springmvc.dao.User;
import org.springmvc.dao.UserPassword;
import org.springmvc.dao.db.UserDao;
import org.springmvc.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl  implements UserService {

	@Autowired
	private UserDao dbses;


	public UserDao getDbses() {
		return dbses;
	}

	public void setDbses(UserDao dbses) {
		this.dbses = dbses;
	}

	public List<Lookup> getLookups(String lookupType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Lookup.class);
		criteria.add(Restrictions.eq("lookupType", lookupType));
		return dbses.search(criteria);
	}
	
	public Map<Long,String> getLookup(String lookupType) {
		List<Lookup>  lookups = getLookups(lookupType);
		java.util.Iterator<Lookup> iterator = null;
		Lookup lookup = null;
		Map<Long,String> lookupMap = new HashMap<Long, String>();
		if(!utils.isEmptyCollection(lookups)){
			iterator = lookups.listIterator();
			while(iterator.hasNext()){
				lookup = iterator.next();
				lookupMap.put(lookup.getId(),lookup.getLookupValue());
			}
		}
		return lookupMap;
	}

	public User getUserById(long userId) {
		return dbses.search(User.class, userId);
	}

	public UserPassword getUserPasswordById(long userId) {
		return dbses.search(UserPassword.class, userId);
	}

	@Override
	public Map<String, String> changePassword(long userId,String currentPassword, String newPassword, String confirmPassword) {
		log.warn(" [UserId :" + userId + " New Password : " + newPassword+ " Confirm Password : " + confirmPassword	+ " Current Password : " + currentPassword + " ]");
		UserPassword userPassword = getUserPasswordById(userId);
		log.warn(userPassword);
		String encryptedPassword = utils.getPasswordEncryption(newPassword);
		Map<String, String> message = new HashMap<String, String>();
		if (utils.isEmpty(newPassword)) {
			message.put("ErrorMsg", "Empty Password!");
		} else if (utils.isEmpty(confirmPassword)) {
			message.put("ErrorMsg", "Empty Confirm Password!");
		} else if (!newPassword.equals(confirmPassword)) {
			message.put("ErrorMsg", "Password & Confirm Password mismatch!");
		} else if (!utils.isValidUserNameOrPassword(newPassword)) {
			message.put("ErrorMsg",
					"Password is case sensitive and must be 6 to 14 characters long.");
		} else if (!utils.isValidPasswordForCapsNum(newPassword)) {
			message.put("ErrorMsg",	"Password does not meet one of the following criteria: must be 8 to 14 characters long; and must include at least one lowercase alphabet, one uppercase alphabet, a number and a special character.");
		} else if (encryptedPassword.equals(userPassword.getCurrPassword())
				|| encryptedPassword.equals(userPassword.getRecentPassword())
				|| encryptedPassword.equals(userPassword.getLastPassword())) {
			message.put("ErrorMsg",	"You are not allowed to use your last 3 Passwords. Please give a new password");
		}

		log.warn("Message " + message.keySet());
		if (utils.isEmptyCollection(message)) {
			log.warn("Executing when message map is empty ");
			userPassword.setLastPassword(userPassword.getRecentPassword());
			userPassword.setRecentPassword(userPassword.getCurrPassword());
			userPassword.setCurrPassword(utils.getPasswordEncryption(newPassword));
			userPassword.setTimestampForUpdate(userPassword.getLastModBy());
			log.warn(userPassword);
			dbses.save(userPassword);
			message.put("SuccessMsg", "UserPassword Changed Successfully!!");
		}
		return message;
	}

	@Override
	public List<User> getUserList() {
		return dbses.listData(User.class);
	}

	@Override
	public boolean saveUser(User user) {
		if(user.getId()==0){
			return dbses.insert(user);
		}else{
			return dbses.update(user);
		}
	}

	@Override
	public boolean removeUser(User user) {
		return dbses.delete(user);
	}

}
