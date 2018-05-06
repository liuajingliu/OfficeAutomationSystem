package com.icss.oa.cargo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.cargo.pojo.Cargo;
import com.icss.oa.common.DBConnection;
import com.icss.oa.common.Pager;

public class CargoDao {
	public void insert(Cargo cg) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO cargo values(cargo_seq.nextval, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, cg.getName());
		pstmt.setString(2, cg.getDesc());
		pstmt.setInt(3, cg.getPrice());
		pstmt.setInt(4, cg.getNum());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有数据
	 */
	public ArrayList<Cargo> queryAll(Pager pager) throws SQLException {
		Cargo cp = null;
		ArrayList<Cargo> list = new ArrayList<Cargo>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT cargo_id,cargo_name,cargo_desc,cargo_price,cargo_num FROM cargo";

		sql = "SELECT * FROM (SELECT rownum rnum,ee.* from (" + sql +") ee) WHERE  rnum BETWEEN ? AND ?";		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);

		System.out.println(pager);
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			cp = new Cargo(rs.getInt(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getInt(6));
			list.add(cp);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	public int getCount() throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "SELECT COUNT(*) FROM cargo";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		rs.next();

		int count = rs.getInt(1);

		rs.close();
		pstmt.close();
		conn.close();

		return count;
	}
}
