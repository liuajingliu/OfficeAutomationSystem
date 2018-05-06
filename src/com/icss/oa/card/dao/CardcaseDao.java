package com.icss.oa.card.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.pojo.Cardcase;
import com.icss.oa.common.DBConnection;

public class CardcaseDao {
	public void insert(Cardcase cc) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO cardcase values(cardcase_seq.nextval, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, cc.getCardName());
		pstmt.setInt(2, cc.getEmpId());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 删除一条数据
	 */
	public void delete(int cardcaseid) throws SQLException {
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE FROM cardcase WHERE cardcase_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cardcaseid);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有数据
	 */
	public ArrayList<Cardcase> queryAll(int empid) throws SQLException {
		Cardcase cc = null;
		ArrayList<Cardcase> list = new ArrayList<Cardcase>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM cardcase where emp_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empid);

		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			cc = new Cardcase(rs.getInt(1), rs.getString(2),rs.getInt(3));
			list.add(cc);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
