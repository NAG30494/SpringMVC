package org.springmvc.service;

import java.util.List;

import org.springmvc.dao.Lookup;

public interface LookupService extends BaseService {
	
	public List<Lookup> getLookupList();	
	public List<Lookup> getLookup(String lookupType);
	public Lookup getLookupById(long lookupId);
	public boolean saveLookup(Lookup lookup);
	public boolean remove(Lookup lookup);
}


