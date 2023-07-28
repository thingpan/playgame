package com.playgame.service.Impl;

import java.util.List;
import java.util.Map;
import com.playgame.dao.*;
import com.playgame.dao.Impl.*;

import com.playgame.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
private UserInfoDao uiDao=new UserInfoDaoImpl();
	@Override
	public List<Map<String, String>> SelectUserInfoList(Map<String, String> user) {
		// TODO Auto-generated method stub
		return uiDao.selectUserInfoList(user);
	}

	@Override
	public Map<String, String> SelectUserInfo(String uiNum) {
		// TODO Auto-generated method stub
		return uiDao.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> user) {
		// TODO Auto-generated method stub
		return uiDao.insertUserInfo(user);
	}

	@Override
	public int updateUserInfo(Map<String, String> user) {
		// TODO Auto-generated method stub
		return uiDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		// TODO Auto-generated method stub
		return uiDao.deleteUserInfo(uiNum);
	}

	@Override
	public Map<String, String> login(String userId) {
		// TODO Auto-generated method stub
		return uiDao.selectUserInfoById(userId);
	}

}
