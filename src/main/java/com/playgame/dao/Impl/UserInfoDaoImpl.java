package com.playgame.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.DBCon;
import com.playgame.dao.UserInfoDao;

public class UserInfoDaoImpl implements UserInfoDao {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		String sql = "SELECT  UI_NUM,UI_NAME ,UI_ID,UI_PWD,UI_IMG_PATH,UI_DESC\r\n"
				+ "UI_BIRTH,CREDAT,CRETIM,LMODAT,LMOTIM,ACTIVE\r\n" + "FROM user_info";
		List<Map<String, String>> userList = new ArrayList<>();
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("LMOTIM", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						userList.add(map);

					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		// TODO Auto-generated method stub
		String sql = "SELECT  UI_NUM,UI_NAME ,UI_ID,UI_PWD,UI_IMG_PATH,UI_DESC\r\n"
				+ "UI_BIRTH,CREDAT,CRETIM,LMODAT,LMOTIM,ACTIVE\r\n" + "FROM user_info WHERE UI_NUM=?";

		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiNum);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("LMOTIM", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;

					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO user_info(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH,\r\n"
				+ "UI_DESC, UI_BIRTH, CREDAT ,CRETIM, LMODAT, LMOTIM)\r\n" + "VALUES(?, ?,?, ?, ?,\r\n"
				+ " ?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "DATE_FORMAT(NOW(),'%H%i%s'))";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				return ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE USER_INFO\r\n" + "SET UI_NAME=?,\r\n" + "UI_PWD=?,\r\n" + "UI_IMG_PATH=?,\r\n"
				+ "UI_DESC=?,\r\n" + "UI_BIRTH=?,\r\n" + "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n" + "WHERE UI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				return ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM user_info WHERE UI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiNum);
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		// TODO Auto-generated method stub
		String sql="SELECT  UI_NUM,UI_NAME ,UI_ID,UI_PWD,UI_IMG_PATH,UI_DESC\r\n"
				+ "UI_BIRTH,CREDAT,CRETIM,LMODAT,LMOTIM,ACTIVE\r\n" + "FROM user_info WHERE UI_ID=?" ; 
		List<Map<String, String>> userList = new ArrayList<>();
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiId);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("LMOTIM", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;

					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	public static void main(String[] args) {
		UserInfoDao uiDao = new UserInfoDaoImpl();
		Map<String, String> map = new HashMap<>();
		map.put("uiName", "test");
		map.put("uiId", "ik1");
		map.put("uiPwd", "test");
		map.put("uiDesc", "test");
		map.put("uiBirth", "39390");
		// int result = uiDao.insertUserInfo(map);
		// System.out.println(result);
		 Map<String,String> userInfo = uiDao.selectUserInfo("1");
		// int result1 = uiDao.updateUserInfo(userInfo);
		// System.out.println(result);
	
		 System.out.println(uiDao.selectUserInfoById("HONG"));
	}
}
