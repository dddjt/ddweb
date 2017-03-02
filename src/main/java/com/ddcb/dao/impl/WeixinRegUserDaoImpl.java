package com.ddcb.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ddcb.dao.IWeixinRegUserDao;
import com.ddcb.mapper.WeixinRegUserMapper;
import com.ddcb.model.WeixinRegUserModel;

@Repository("weixinRegUserDao")
public class WeixinRegUserDaoImpl implements IWeixinRegUserDao {

	private static final Logger logger = LoggerFactory
			.getLogger(WeixinRegUserDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public WeixinRegUserModel getWeixinRegUserByUserId(String userId) {
		String sql = "select * from weixin_user where user_phone = ?";
		WeixinRegUserModel weixinUserModel = null;
		try {
			weixinUserModel = jdbcTemplate.queryForObject(sql,
					new Object[] { userId }, new WeixinRegUserMapper());
		} catch (Exception e) {
			logger.error("exception : {}", e.toString());
		}
		return weixinUserModel;
	}
	
	@Override
	public boolean addWeixinRegUser(WeixinRegUserModel weixinUserModel) {		
		try{
			String sql= "insert into weixin_user(user_name, user_phone, create_time, user_pwd, school, major, grade, country) values (?,?,?,?,?,?,?,?)";
			int num = jdbcTemplate.update(sql, weixinUserModel.getUser_name(), weixinUserModel.getUser_phone(),
					new Timestamp(System.currentTimeMillis()), weixinUserModel.getUser_pwd(), weixinUserModel.getSchool(),
					weixinUserModel.getMajor(), weixinUserModel.getGrade(), weixinUserModel.getCountry());
			return num > 0;
		}catch(Exception e){
			logger.error("exception : {}", e.toString());
		}
		return false;
	}
	
	@Override
	public boolean addWeixinRegUserDetailInfo(WeixinRegUserModel weixinUserModel) {		
		try{
			String sql= "update weixin_user set user_name=?, school=?, major=?, grade=?, country=? where user_phone=?";
			int num = jdbcTemplate.update(sql, weixinUserModel.getUser_name(),weixinUserModel.getSchool(),
					weixinUserModel.getMajor(), weixinUserModel.getGrade(), weixinUserModel.getCountry(),
					weixinUserModel.getUser_phone());
			return num > 0;
		}catch(Exception e){
			logger.error("exception : {}", e.toString());
		}
		return false;
	}

	@Override
	public List<WeixinRegUserModel> getAllWeixinRegUser() {
		List<WeixinRegUserModel> list = null;
		try {
			String sql = "select a.*,DATE_FORMAT(a.create_time,'%Y-%m-%d %T') as create_time from weixin_user as a order by a.create_time desc";
			list = jdbcTemplate.query(sql, new RowMapperResultSetExtractor<WeixinRegUserModel>(
							new WeixinRegUserMapper()));
		} catch (Exception e) {
			logger.debug("exception : {}", e.toString());
		}
		return list;
	}

	@Override
	public boolean updateUserPwd(String user_id, String pwd) {
		String sql = "update weixin_user set user_pwd=? where user_id=?";
		int affectedRows = 0;
		try {
			affectedRows = jdbcTemplate.update(sql, pwd, user_id);
		} catch(Exception ex) {
			logger.error(ex.toString());
		}
		return affectedRows != 0;
	}
}