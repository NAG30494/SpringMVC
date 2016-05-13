package org.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvc.dao.Lookup;
import org.springmvc.dao.db.LookupDao;
import org.springmvc.service.LookupService;

@Service("lookupService")
public class LookupServiceImpl extends BaseServiceImpl  implements LookupService {

	
	@Autowired
	private LookupDao dbses;
	
	public LookupDao getDbses() {
		return dbses;
	}

	public void setDbses(LookupDao dbses) {
		this.dbses = dbses;
	}

	@Override
	public List<Lookup> getLookupList() {
		return dbses.listData(Lookup.class);
	}

	@Override
	public List<Lookup> getLookup(String lookupType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lookup getLookupById(long lookupId) {
		return dbses.search(Lookup.class, lookupId);
	}
	
	public boolean saveLookup(Lookup lookup){
		if(lookup.getId()==0){
			return dbses.insert(lookup);
		}else{
			return dbses.update(lookup);
		}
	}

	@Override
	public boolean remove(Lookup lookup) {
		return dbses.delete(lookup);
	}

}
