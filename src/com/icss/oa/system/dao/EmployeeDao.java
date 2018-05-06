package com.icss.oa.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DBConnection;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.pojo.Job;

/**
 * 员工DAO
 * 
 * @author Administrator
 * 
 */
public class EmployeeDao {

	/**
	 * 插入数据
	 * 
	 * @param emp
	 * @throws SQLException
	 */
	public void insert(Employee emp) throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "INSERT INTO employee VALUES (employee_seq.nextval,?,?,?,?,?,'123456',?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpPhone());
		pstmt.setDate(3, emp.getEmpBirthday());
		pstmt.setString(4, emp.getEmail());
		pstmt.setString(5, emp.getQq());
		pstmt.setInt(6, emp.getDept().getDeptId());
		pstmt.setInt(7, emp.getJob().getJobId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * 删除数据
	 * 
	 * @param empId
	 * @throws SQLException
	 */
	public void delete(int empId) throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "delete from employee where emp_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 修改数据
	 * 
	 * @param emp
	 * @throws SQLException
	 */
	public void update(Employee emp) throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "update employee set emp_name=?,emp_phone=?,emp_birthday=?,dept_id=?,job_id=? where emp_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpPhone());
		pstmt.setDate(3, emp.getEmpBirthday());
		pstmt.setInt(4, emp.getDept().getDeptId());
		pstmt.setInt(5, emp.getJob().getJobId());
		pstmt.setInt(6, emp.getEmpId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 根据id查询单条数据
	 * 
	 * @param empId
	 * @return
	 * @throws SQLExceptionc
	 */
	public Employee queryById(int empId) throws SQLException {

		Employee emp = null;

		Connection conn = DBConnection.getConnection();

		String sql = "select emp_id, emp_name, emp_phone, emp_birthday, emp_email, emp_qq, department.dept_id, job.job_id, dept_name,"
				+ "job_name, emp_pwd from employee, department, job where employee.emp_id = ? and employee.dept_id=department.dept_id and employee.job_id=job.job_id";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, empId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			Department dept = new Department(rs.getInt(7), rs.getString(9));

			Job job = new Job(rs.getInt(8), rs.getString(10));

			emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(11), dept, job);

		}

		rs.close();
		pstmt.close();
		conn.close();

		return emp;
	}

	/**
	 * 分页查询所有数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Employee> queryAll(Pager pager) throws SQLException {

		Employee emp = null;
		ArrayList<Employee> list = new ArrayList<Employee>();

		Connection conn = DBConnection.getConnection();

		String sql = "select emp_id, emp_name, emp_phone, emp_birthday, emp_email, emp_qq, department.dept_id, job.job_id, dept_name, job_name"
				+ " from employee, department, job where employee.dept_id=department.dept_id and employee.job_id=job.job_id";

		sql = "SELECT * FROM (SELECT rownum rnum,ee.* from (" + sql +") ee) WHERE  rnum BETWEEN ? AND ?";
		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());
		
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Department dept = new Department(rs.getInt(8), rs.getString(10));

			Job job = new Job(rs.getInt(9), rs.getString(11));

			emp = new Employee(rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6), rs.getString(7), dept, job);

			list.add(emp);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

	/**
	 * 返回总记录数
	 * 
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {

		Connection conn = DBConnection.getConnection();

		String sql = "SELECT COUNT(*) FROM employee";

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