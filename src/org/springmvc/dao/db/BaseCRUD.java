package org.springmvc.dao.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springmvc.dao.Audit;
import org.springmvc.dao.BaseDAO;
import org.springmvc.dao.User;

public class BaseCRUD {

	protected final Log log = LogFactory.getLog(getClass());
	private String userName;
	
	//@Autowired
	private User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return getUser()!=null?getUser().getUserName():"springmvc";
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public <T> T updateData(T t) {
		hibernateTemplate.update(t);
		return t;
	}

	public boolean delete(BaseDAO t) {
		try{
		hibernateTemplate.delete(t);
		}catch(Exception ex){
			return false;
		}
		return true;
	}

	public <T> Boolean save(T t) {
		try {
			hibernateTemplate.setCheckWriteOperations(false);
			hibernateTemplate.saveOrUpdate(t);
			hibernateTemplate.setCheckWriteOperations(true);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(BaseDAO t) {
		try {
			
			t.setTimestampForUpdate(getUserName());
			log.info(t);
			hibernateTemplate.setCheckWriteOperations(false);
			hibernateTemplate.update(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			hibernateTemplate.setCheckWriteOperations(true);
		}
	}
	
	public boolean insert(BaseDAO baseDAO) {
		try {
			hibernateTemplate.setCheckWriteOperations(false);
			baseDAO.setTimestampForInsert(getUserName());
			hibernateTemplate.save(baseDAO);
			if(baseDAO.isAudit()){
				Audit audit = new Audit();
				audit.setTimestampForInsert(getUserName());
				audit.setObjectName(baseDAO.getClass().getSimpleName());
				audit.setObjectId(baseDAO.getId());
				audit.setValue(baseDAO.getAudit());
				hibernateTemplate.save(audit);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			hibernateTemplate.setCheckWriteOperations(true);
		}
	}

	public <T> T search(final Class<T> type, final Long id) {
		return (T) hibernateTemplate.get(type, id);
	}

	@SuppressWarnings("unchecked")
	@Fetch(value = FetchMode.SELECT)
	public <T> List<T> listData(@SuppressWarnings("rawtypes") Class clazz) {
		return hibernateTemplate.loadAll(clazz);
	}

	@SuppressWarnings("unchecked")
	@Fetch(value = FetchMode.SELECT)
	public <T> List<T> search(DetachedCriteria crit) {
		return (List<T>) hibernateTemplate.findByCriteria(crit);
	}

}