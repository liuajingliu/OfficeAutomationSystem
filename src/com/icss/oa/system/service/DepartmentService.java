package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/**
 * 部门业务
 * @author Administrator
 *
 */
public class DepartmentService {
	
	private DepartmentDao dao = new DepartmentDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addDept(Department dept) throws SQLException {
		dao.insert(dept);
	}
	
	/**
	 * 修改部门
	 */
	public void updateDept(Department dept) throws SQLException {
		dao.update(dept);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteDept(int deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	/**
	 * 查询单独的部门
	 */
	public Department queryDeptById(int deptId) throws SQLException {
		
		return dao.queryById(deptId);
	}
	
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<Department> queryAllDept() throws SQLException {
		
		return dao.queryAll();
	}

}