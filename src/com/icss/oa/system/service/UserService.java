package com.icss.oa.system.service;

import java.sql.SQLException;

import com.icss.oa.system.dao.EmployeeDao;
import com.icss.oa.system.dao.UserDao;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.pojo.User;

/**
 * �����½ҵ��
 * @author Administrator
 *
 */
public class UserService {
	
	private UserDao dao = new UserDao();
	
	/**
	 * 
	 * @param admin ��Ҫ��֤�ĵ�½����
	 * @return 1�û���/�������  2 �û�����(ְԱ) 3�û�����(admin)
	 * @throws SQLException
	 */
	public int checkLogin(User user) throws SQLException {
		User adminlogin = dao.queryByAdminId(user.getUserId());
		
		Employee em = new EmployeeDao().queryById(user.getUserId());
		System.out.println(em);
		if (em == null || !em.getPwd().equals(user.getUserpwd()) ) {
			
			return 1;
		} else if (adminlogin == null) {
			
			return 2;
		} else {
			
			return 3;
		}
		
	}

}
