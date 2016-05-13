package org.springmvc.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

public class AppUtils {
	
	protected final Log log = LogFactory.getLog(getClass());
	static AppUtils instance = new AppUtils();

	public static AppUtils getInstance() {
		return instance;
	}
	
	public String getPasswordEncryption(String toEncrypt) {
		String md5encryptedPassword = "";
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(toEncrypt.getBytes());
			byte raw[] = md5.digest();
			md5encryptedPassword = (new BASE64Encoder()).encode(raw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5encryptedPassword;
	}

	public String getRequestAttribute(HttpServletRequest request,String attributeName) {
		if (request.getAttribute(attributeName) != null) {
			return request.getAttribute(attributeName).toString();
		}
		return "";
	}

	public boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0)
			return true;
		return false;
	}
	
	public boolean isValidLong( String val){
		try{
			if(!isEmpty(val)){
				Long.parseLong(val);
				return true;
			}
			return false;
		}catch(NumberFormatException ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public long getLongParameter(HttpServletRequest request,String paramName){
		if(isValidLong((String)request.getParameter(paramName))){
			return Long.parseLong((String)request.getParameter(paramName));
		}else{
			return 0;
		}
	}
	
	public String getParameter(HttpServletRequest request,String paramName){
			return (String)request.getParameter(paramName);
	}
	
	public boolean getBooleanValue(String val){
		if(val.equalsIgnoreCase("yes")||val.equalsIgnoreCase("ture")||val.equalsIgnoreCase("1")){
			return true;
		}
		return false;
	}
	
	public boolean getBooleanParameter(HttpServletRequest request,String paramName){
		return getBooleanValue((String)request.getParameter(paramName));
	}
	
	
	public boolean isValidUserNameOrPassword(String userName) {
		int lengthOfUserName = userName.length();
		if (lengthOfUserName < 8 || lengthOfUserName > 14)
			return false;
		return true;
	}

	public boolean isValidPasswordForCapsNum(String userPassword) {
		boolean returnBoolean = false;
		boolean pwdLength = (userPassword.length() >= 8 && userPassword.length() <= 15) ? true : false;
		boolean noSpecialChars = Pattern.matches("^.*(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$",userPassword);
		boolean alphaFound = false;
		boolean numFound = false;
		char[] m = userPassword.toCharArray();
		for (int i = 0; i < m.length; i++) {
			if (!alphaFound && Character.isLetter(m[i])) {
				alphaFound = true;
			} else if (!numFound && Character.isDigit(m[i])) {
				numFound = true;
			}
			if (alphaFound && numFound) {
				break;
			}
		}
		if (pwdLength && noSpecialChars && alphaFound && numFound)
			returnBoolean = true;
		return returnBoolean;
	}
	
	
	/**
	 *  methods related to Collection for checking Empty
	 * 
	 * 	 */
	public boolean isEmptyCollection(List collection){
		if(null == collection || collection.isEmpty() ){
			return true;
		}
		return false;
	}
	
	public boolean isEmptyCollection(Set collection){
		if(null == collection || collection.isEmpty() ){
			return true;
		}
		return false;
	}
	
	public boolean isEmptyCollection(Map collection){
		if(null == collection || collection.isEmpty() ){
			return true;
		}
		return false;
	}

}
