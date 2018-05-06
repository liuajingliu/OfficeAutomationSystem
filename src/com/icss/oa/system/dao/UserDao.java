package com.icss.oa.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icss.oa.common.DBConnection;
import com.icss.oa.system.pojo.User;

/**
 * 管理员DAO类
 * @author Administrator
 *
 */
public class UserDao {
	
	/**
	 * 根据用户名查询返回数据
	 * @param adminName
	 * @return
	 * @throws SQLException
	 */
	public User queryByAdminId(int adminId) throws SQLException {
		
		User adminlogin = null;
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "select * from manager where emp_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, adminId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			adminlogin = new User(rs.getInt(1));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return adminlogin;
		
	}

}