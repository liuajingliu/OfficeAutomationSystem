package com.icss.oa.expatriate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.expatriate.dao.PersonnelDao;
import com.icss.oa.expatriate.pojo.Personnel;

/**
 * @author Administrator
 * �����˲�ҵ��
 */
public class PersonnelService {
	private PersonnelDao dao = new PersonnelDao();
	
	/**
	 * ���������˲�
	 * @throws SQLException 
	 */
	public void addPersonnel(Personnel ps) throws SQLException {
		dao.insert(ps);
	}
	
	/**
	 * ɾ�������˲�
	 */
	public void deletePersonnel(int ps) throws SQLException {
		dao.delete(ps);
	}	
	
	/**
	 * ��ѯ���������˲�
	 * @throws SQLException 
	 */
	public ArrayList<Personnel> queryAllPersonnel() throws SQLException {
		
		return dao.queryAll();
	}
}
