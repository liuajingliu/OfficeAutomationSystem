package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.EmployeeDao;
import com.icss.oa.system.pojo.Employee;

/**
 * Ա��ҵ��
 * @author Administrator
 *
 */
public class EmployeeService {
	
	private EmployeeDao dao = new EmployeeDao();
	
	/**
	 * ����Ա��
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Employee emp) throws SQLException {
		
		dao.insert(emp);
		
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateEmp(Employee emp) throws SQLException {
		dao.update(emp);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteEmp(int id) throws SQLException {
		dao.delete(id);
	}
	
	/**
	 * ��ѯԱ��
	 * @throws SQLException 
	 */
	public ArrayList<Employee> queryAll(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);		
	}
	
	public Employee queryById(int Id) throws SQLException {
		return dao.queryById(Id);
	}
	/**
	 * ����ܼ�¼��
	 * @throws SQLException 
	 */
	public int getEmpCount() throws SQLException {
		return dao.getCount();
	}

}