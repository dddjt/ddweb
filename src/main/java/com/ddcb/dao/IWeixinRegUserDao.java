package com.ddcb.dao;

import java.util.List;

import com.ddcb.model.WeixinRegUserModel;

public interface IWeixinRegUserDao {

	public WeixinRegUserModel getWeixinRegUserByUserId(String userId);
	
	public boolean addWeixinRegUser(WeixinRegUserModel weixinUserModel);
	
	public boolean addWeixinRegUserDetailInfo(WeixinRegUserModel weixinUserModel);
	
	public List<WeixinRegUserModel>  getAllWeixinRegUser();
	
	public boolean updateUserPwd(String user_id, String pwd);
			
}