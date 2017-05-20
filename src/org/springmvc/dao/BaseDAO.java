package org.springmvc.dao;

import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.log4j.Logger;
public abstract class BaseDAO {

	private long id;
	private boolean isActive;
	private String createdBy;
	private String lastModBy;
	private Timestamp createdOn;
	private Timestamp lastModOn;
	private long lockTs;
	
	private boolean isAudit =false;
	
	public boolean isAudit() {
		return isAudit;
	}

	public void setAudit(boolean isAudit) {
		this.isAudit = isAudit;
	}

	private static Logger log;
	
	public BaseDAO() {
		log = Logger.getLogger(this.getClass().getName());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getLastModOn() {
		return lastModOn;
	}

	public void setLastModOn(Timestamp lastModOn) {
		this.lastModOn = lastModOn;
	}

	public long getLockTs() {
		return lockTs;
	}

	public void setLockTs(long lockTs) {
		this.lockTs = lockTs;
	}

	public Timestamp getCurrentTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}

	public void setTimestampForUpdate(String name) {
		this.lastModOn = getCurrentTimestamp();
		this.lastModBy = name;
		this.lockTs++;
		if(this.lockTs == Integer.MAX_VALUE){
			this.lockTs=1;
		}
	}

	public void setTimestampForInsert(String name) {
		this.lastModOn = getCurrentTimestamp();
		this.lastModBy = name;
		this.createdOn = getCurrentTimestamp();
		this.createdBy = name;
		this.lockTs++;
	}
	
	/*public String getAudit() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(baos);
		xmlEncoder.writeObject(this);
		xmlEncoder.close();
		return baos.toString();
	}*/
	
	
	public String getAudit() {
		StringWriter writer = new StringWriter();
		/*try{
		JAXBContext context = JAXBContext.newInstance(getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(this, writer);
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
		return writer.toString();
	}

	@Override
	public String toString() {
		return "BaseDAO [id=" + id + ", isActive=" + isActive + ", createdBy="
				+ createdBy + ", lastModBy=" + lastModBy + ", createdOn="
				+ createdOn + ", lastModOn=" + lastModOn + ", lockTs=" + lockTs
				+ ", isAudit=" + isAudit + "]";
	}
	
	
	

	/*public abstract String getAudit(); */
	
}
