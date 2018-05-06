package com.icss.oa.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DBConnection;
import com.icss.oa.system.pojo.Job;

public class JobDao {

	/**
	 * 插入数据
	 * 
	 * @param job
	 * @throws SQLException
	 */
	public void insert(Job job) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO job values(job_seq.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, job.getJobName());
		pstmt.setString(2, job.getJobDesc());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	/**
	 * 删除数据
	 * 
	 * @param jobId
	 * @throws SQLException
	 */
	public void delete(int jobId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "DELETE FROM job WHERE job_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 修改数据
	 * 
	 * @param job
	 * @throws SQLException
	 */
	public void update(Job job) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE job SET job_name=?,job_desc=? where job_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, job.getJobName());
		pstmt.setString(2, job.getJobDesc());
		pstmt.setInt(3, job.getJobId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 按ID查询数据
	 * 
	 * @param jobId
	 * @return
	 * @throws SQLException
	 */
	public Job queryById(int jobId) throws SQLException {
		Job job = null;
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM job WHERE job_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			job = new Job(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return job;
	}

	public ArrayList<Job> queryAll() throws SQLException {
		Job job = null;
		ArrayList<Job> list = new ArrayList<Job>();
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM job";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while (rs.next()) {
			job = new Job(rs.getInt(1), rs.getString(2), rs.getString(3));
			list.add(job);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

}
