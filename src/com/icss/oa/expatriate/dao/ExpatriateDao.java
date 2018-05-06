package com.icss.oa.expatriate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DBConnection;
import com.icss.oa.expatriate.pojo.Company;
import com.icss.oa.expatriate.pojo.Expatriate;

public class ExpatriateDao {
	/**
	 * 
	 * @author: Administrator
	 * @功能: 插入一条数据
	 */
	public void insert(Expatriate et) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO expatriate values(company_seq.nextval, ?, ?, ?, ?, 'unfinished')";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, et.getPerid());
		pstmt.setLong(2, et.getComid());
		pstmt.setDate(3, et.getStart());
		pstmt.setDate(4, et.getEnd());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 删除一条数据
	 */
	public void delete(int id) throws SQLException {
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE FROM expatriate WHERE expatriate_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有完成数据
	 */
	public ArrayList<Expatriate> queryAllFinish() throws SQLException {
		Company cp = null;
		ArrayList<Expatriate> list = new ArrayList<Expatriate>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT company_id, company_name, company_master, company_phone, company_request, company_qq, company_desc FROM company";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		
		while (rs.next()) {
			cp = new Company(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
		//	list.add(cp);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有未完成数据
	 */
	
	public ArrayList<Expatriate> queryAllUnfinished() throws SQLException {
		Company cp = null;
		ArrayList<Expatriate> list = new ArrayList<Expatriate>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT company_id, company_name, company_master, company_phone, company_request, company_qq, company_desc FROM company";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		
		while (rs.next()) {
			cp = new Company(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
		//	list.add(cp);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
