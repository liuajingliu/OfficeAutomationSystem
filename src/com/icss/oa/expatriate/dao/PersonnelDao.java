package com.icss.oa.expatriate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DBConnection;
import com.icss.oa.expatriate.pojo.Personnel;

public class PersonnelDao {
	/**
	 * 
	 * @author: Administrator
	 * @功能: 插入一条数据
	 */
	public void insert(Personnel ps) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = " insert into personnel values (personnel_seq.nextval, ?, ?, ?, ?, 'free')";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, ps.getName());
		pstmt.setString(2, ps.getEduction());
		pstmt.setString(3, ps.getSkill());
		pstmt.setInt(4, ps.getSalary());
	
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
		
		String sql = "DELETE FROM personnel WHERE personnel_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有数据
	 */
	public ArrayList<Personnel> queryAll() throws SQLException {
		Personnel cp = null;
		ArrayList<Personnel> list = new ArrayList<Personnel>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT personnel_id, personnel_name, personnel_educt, personnel_skill, personnel_salary, personnel_status FROM personnel";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		
		while (rs.next()) {
			cp = new Personnel(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getString(6));
			list.add(cp);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
