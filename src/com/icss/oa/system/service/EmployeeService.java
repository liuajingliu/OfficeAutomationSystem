package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.EmployeeDao;
import com.icss.oa.system.pojo.Employee;

/**
 * 员工业务
 * @author Administrator
 *
 */
public class EmployeeService {
	
	private EmployeeDao dao = new EmployeeDao();
	
	/**
	 * 增加员工
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Employee emp) throws SQLException {
		
		dao.insert(emp);
		
	}
	
	/**
	 * 修改部门
	 */
	public void updateEmp(Employee emp) throws SQLException {
		dao.update(emp);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteEmp(int id) throws SQLException {
		dao.delete(id);
	}
	
	/**
	 * 查询员工
	 * @throws SQLException 
	 */
	public ArrayList<Employee> queryAll(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);		
	}
	
	public Employee queryById(int Id) throws SQLException {
		return dao.queryById(Id);
	}
	/**
	 * 获得总记录数
	 * @throws SQLException 
	 */
	public int getEmpCount() throws SQLException {
		return dao.getCount();
	}

}