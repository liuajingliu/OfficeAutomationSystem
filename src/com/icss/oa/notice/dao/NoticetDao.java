package com.icss.oa.notice.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DBConnection;
import com.icss.oa.notice.pojo.Notice;

public class NoticetDao {
	/**
	 * 
	 * @author: Administrator
	 * @功能: 插入一条公告数据
	 */
	public void insert(Notice nt) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO notice values(notice_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nt.getTitle());
		pstmt.setDate(2, (Date) nt.getDate());
		pstmt.setString(3, nt.getDesc());
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
		String sql = "DELETE FROM notice WHERE notice_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @author: Administrator
	 * @功能: 查询所有公告
	 */
	
	public ArrayList<Notice> queryAll() throws SQLException {
		Notice nt = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT notice_id, notice_title, notice_date, notice_desc FROM notice";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while (rs.next()) {
			nt = new Notice(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4));
			list.add(nt);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
