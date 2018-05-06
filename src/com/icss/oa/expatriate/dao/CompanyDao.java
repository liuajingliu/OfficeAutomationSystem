package com.icss.oa.expatriate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DBConnection;
import com.icss.oa.expatriate.pojo.Company;

public class CompanyDao {
	/**
	 * 
	 * @author: Administrator
	 * @功能: 插入一条数据
	 */
	public void insert(Company cp) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO company values(company_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, cp.getName());
		pstmt.setString(2, cp.getMaster());
		pstmt.setLong(3, cp.getPhone());
		pstmt.setString(4, cp.getRequest());
		pstmt.setLong(5, cp.getQq());
		pstmt.setString(6, cp.getDesc());
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
		
		String sql = "DELETE FROM company WHERE company_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有数据
	 */
	public ArrayList<Company> queryAll() throws SQLException {
		Company cp = null;
		ArrayList<Company> list = new ArrayList<Company>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT company_id, company_name, company_master, company_phone, company_request, company_qq, company_desc FROM company";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		
		while (rs.next()) {
			cp = new Company(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			list.add(cp);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
