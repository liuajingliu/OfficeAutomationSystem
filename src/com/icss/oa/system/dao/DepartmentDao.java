package com.icss.oa.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DBConnection;
import com.icss.oa.system.pojo.Department;

/**
 * 部门DAO
 * 
 * @author Administrator
 * 
 */
public class DepartmentDao {

	/**
	 * 插入数据
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public void insert(Department dept) throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "insert into department values (department_seq.nextval,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptDesc());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * 删除数据
	 * 
	 * @param deptId
	 * @throws SQLException
	 */
	public void delete(int deptId) throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "delete from department where dept_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 修改数据
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public void update(Department dept) throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "update department set dept_name=?,dept_desc=? where dept_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptDesc());
		pstmt.setInt(3, dept.getDeptId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 根据id查询单条数据
	 * 
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public Department queryById(int deptId) throws SQLException {

		Department dept = null;

		Connection conn = DBConnection.getConnection();

		String sql = "select * from department where dept_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, deptId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			dept = new Department(rs.getInt(1), rs.getString(2),
					rs.getString(3));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return dept;
	}

	/**
	 * 查询所有数据
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Department> queryAll() throws SQLException {
		
		ArrayList<Department> list = new ArrayList<Department>();

		Connection conn = DBConnection.getConnection();

		String sql = "select * from department";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Department dept = new Department(rs.getInt(1), rs.getString(2),
					rs.getString(3));
			list.add(dept);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}

}
