package com.ddcb.dao;

import java.util.List;

import com.ddcb.model.OrgModel;

public interface IOrgDao {
	
	public boolean addOrg(String orgName, String orgImg, String org_abstract);
	
	public boolean delOrgById(Long id);
	
	public List<OrgModel> getAllOrg();

}