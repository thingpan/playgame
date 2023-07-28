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
import com.playgame.dao.BoardInfoDao;

public class BoardInfoDaoImpl implements BoardInfoDao {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub
		List<Map<String,String>> boarinfolist =new ArrayList<>();
		String sql="SELECT * FROM BOARD_INFO";
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
				try(ResultSet rs=ps.executeQuery()){
				   while(rs.next()) {
					   Map<String,String> ui =new HashMap<>();
					   ui.put("biNum", rs.getString("BI_NUM"));
					   ui.put("biTitle", rs.getString("BI_TITLE"));
					   ui.put("biContent", rs.getString("BI_CONTENT"));
					   ui.put("uiNum", rs.getString("UI_NUM"));
					   ui.put("cretim", rs.getString("CRETIM"));
					   ui.put("lmodat", rs.getString("LMODAT"));
					   ui.put("lmotim", rs.getString("LMOTIM"));
					   ui.put("ACTIVE", rs.getString("ACTIVE"));
					   boarinfolist.add(ui);
				   }
				}
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		}
		return boarinfolist;
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		// TODO Auto-generated method stub

		String sql="SELECT * FROM BOARD_INFO WHERE UI_NUM=?";
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
				ps.setString(1,biNum);
				try(ResultSet rs=ps.executeQuery()){
				   while(rs.next()) {
					   Map<String,String> ui =new HashMap<>();
					   ui.put("biNum", rs.getString("BI_NUM"));
					   ui.put("biTitle", rs.getString("BI_TITLE"));
					   ui.put("biContent", rs.getString("BI_CONTENT"));
					   ui.put("uiNum", rs.getString("UI_NUM"));
					   ui.put("cretim", rs.getString("CRETIM"));
					   ui.put("lmodat", rs.getString("LMODAT"));
					   ui.put("lmotim", rs.getString("LMOTIM"));
					   ui.put("ACTIVE", rs.getString("ACTIVE"));
					 return ui;
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
	public int insertBoardInfo(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub

		String sql="INSERT INTO board_info(BI_TITLE,BI_CONTENT,UI_NUM,CREDAT,CRETIM,LMODAT,LMOTIM)\r\n"
				+ "VALUES(?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(),'%H%i%s'))" ;
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
			  ps.setString(1, boardInfo.get("biTitle"));
			  ps.setString(2, boardInfo.get("biContent"));
			  ps.setString(3, boardInfo.get("uiNum"));  
		      return ps.executeUpdate();
				   }
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		}
		return 0;
	}
	

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub

		String sql="UPDATE board_info\r\n"
				+ "SET BI_TITLE =?,\r\n"
				+ "BI_CONTENT =?,\r\n"
				+ "UI_NUM=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ "WHERE BI_NUM=?\r\n" ;
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
			  ps.setString(1, boardInfo.get("biTitle"));
			  ps.setString(2, boardInfo.get("biContent"));
			  ps.setString(3, boardInfo.get("uiNum"));
			  ps.setString(4, boardInfo.get("biNum")); 
		      return ps.executeUpdate();
				   }
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM board_info WHERE BI_NUM=?" ;
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
				ps.setString(1,biNum);
				return ps.executeUpdate();
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return 0;
	}
	public static void main(String[] args) {
		BoardInfoDao biDao =new BoardInfoDaoImpl();

		int result1  =biDao.deleteBoardInfo("4");
		System.out.println(result1);
		
	

	}

}
