package org.springmvc.service.impl;

import java.net.InetAddress;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvc.dao.LoginHistory;
import org.springmvc.dao.UserPassword;
import org.springmvc.dao.db.UserDao;
import org.springmvc.dao.views.ViewUserPassword;
import org.springmvc.service.LoginService;


@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl implements LoginService{
	
	
	@Autowired
	private UserDao dbses ;
	
	@Override
	public ViewUserPassword AuthenticateUser(String userName,String password,String JSessionID, String ipAddress) {
		List<ViewUserPassword> userPasswords = null;
		ViewUserPassword viewUserPassword =null;
		try{
			if(!utils.isEmpty(userName) && !utils.isEmpty(password)){
				log.warn("Executing Query"+userName+" Password "+password);
				DetachedCriteria criteria =DetachedCriteria.forClass(ViewUserPassword.class);
				criteria.add(Restrictions.eq("userName", userName));
				//criteria.add(Restrictions.eq("currPassword", password));
				userPasswords = dbses.search(criteria);
			}
			viewUserPassword =( (userPasswords!=null&& userPasswords.size()>0)? userPasswords.get(0):null);
			if(viewUserPassword!=null ){
				if(viewUserPassword.getCurrPassword().equals(password) && !viewUserPassword.getIsUserLocked()){
					logHistory(viewUserPassword.getId(), ipAddress, JSessionID, userName, true);
				}else{
					logHistory(viewUserPassword.getId(), ipAddress, JSessionID, userName, false);
				}
				viewUserPassword = dbses.search(ViewUserPassword.class,viewUserPassword.getId());
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return viewUserPassword;
	}

	public UserDao getDbses() {
		return dbses;
	}

	public void setDbses(UserDao dbses) {
		this.dbses = dbses;
	}

	public void logHistory(long userId,String ipAddress, String JSessionID,String userName,boolean isSuccess) {
		UserPassword userPassword =null;
		try{
			log.warn("saving Login History !!!!!!!!!!!"+userId);
			LoginHistory loginHistory = new LoginHistory(userId,ipAddress,JSessionID);
			InetAddress host = InetAddress.getByName(ipAddress);
			System.out.println(host.getHostName()); 
			
			if(isSuccess){
				loginHistory.setIsSuccess(true);
				userPassword = dbses.search(UserPassword.class,userId);
				userPassword.setPasswordAttempt(0);
			}else{
				userPassword = dbses.search(UserPassword.class,userId);
				if(userPassword!=null){
				userPassword.setPasswordAttempt(userPassword.getPasswordAttempt()+1);
				if(userPassword.getPasswordAttempt()>3){
					userPassword.setUserLocked(true);
				}
				}
				loginHistory.setIsSuccess(false);
			}
			userPassword.setTimestampForUpdate(userName);
			loginHistory.setTimestampForInsert(userName);
			log.warn("Saved Login History !!!!!!!!!!!");
			dbses.save(userPassword);
			dbses.save(loginHistory);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}