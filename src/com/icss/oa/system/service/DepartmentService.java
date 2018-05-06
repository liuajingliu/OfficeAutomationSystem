package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/**
 * ����ҵ��
 * @author Administrator
 *
 */
public class DepartmentService {
	
	private DepartmentDao dao = new DepartmentDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addDept(Department dept) throws SQLException {
		dao.insert(dept);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateDept(Department dept) throws SQLException {
		dao.update(dept);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteDept(int deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public Department queryDeptById(int deptId) throws SQLException {
		
		return dao.queryById(deptId);
	}
	
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<Department> queryAllDept() throws SQLException {
		
		return dao.queryAll();
	}

}