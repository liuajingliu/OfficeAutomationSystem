package com.icss.oa.card.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.pojo.Cardcase;
import com.icss.oa.common.DBConnection;

public class CardDao {
	public void insert(Card cd) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO card values(card_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, cd.getName());
		pstmt.setString(2, cd.getJob());
		pstmt.setString(3, cd.getPhone());
		pstmt.setString(4, cd.getQq());
		pstmt.setString(5, cd.getAddr());
		pstmt.setString(6, cd.getEmail());
		pstmt.setString(7, cd.getCompany());
		pstmt.setInt(8, cd.getCardcase().getCardcaseId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 删除一条数据
	 */
	public void delete(int cardid) throws SQLException {
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE FROM card WHERE card_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cardid);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有数据
	 */
	public ArrayList<Card> queryAll(int empid) throws SQLException {
		Card cd = null;
		ArrayList<Card> list = new ArrayList<Card>();
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT c.*, cc.cardcase_name FROM card c, cardcase cc where c.cardcase_id=cc.cardcase_id and cc.emp_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empid);

		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Cardcase cc = new Cardcase(rs.getInt(9), rs.getString(10));
			cd = new Card(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), cc);
			list.add(cd);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
