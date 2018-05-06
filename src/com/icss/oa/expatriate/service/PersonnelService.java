package com.icss.oa.expatriate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.expatriate.dao.PersonnelDao;
import com.icss.oa.expatriate.pojo.Personnel;

/**
 * @author Administrator
 * 外派人才业务
 */
public class PersonnelService {
	private PersonnelDao dao = new PersonnelDao();
	
	/**
	 * 增加外派人才
	 * @throws SQLException 
	 */
	public void addPersonnel(Personnel ps) throws SQLException {
		dao.insert(ps);
	}
	
	/**
	 * 删除外派人才
	 */
	public void deletePersonnel(int ps) throws SQLException {
		dao.delete(ps);
	}	
	
	/**
	 * 查询所有外派人才
	 * @throws SQLException 
	 */
	public ArrayList<Personnel> queryAllPersonnel() throws SQLException {
		
		return dao.queryAll();
	}
}
