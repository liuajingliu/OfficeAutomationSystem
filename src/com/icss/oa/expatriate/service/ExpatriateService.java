package com.icss.oa.expatriate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.expatriate.dao.ExpatriateDao;
import com.icss.oa.expatriate.pojo.Expatriate;

/**
 * @author Administrator
 * 派遣记录业务
 */
public class ExpatriateService {
	private ExpatriateDao dao = new ExpatriateDao();
	
	/**
	 * 增加派遣记录
	 * @throws SQLException 
	 */
	public void addExpatriate(Expatriate ps) throws SQLException {
		dao.insert(ps);
	}
	
	/**
	 * 删除派遣记录
	 */
	public void deleteExpatriate(int ps) throws SQLException {
		dao.delete(ps);
	}	
	
	/**
	 * 查询所有完成派遣记录
	 * @throws SQLException 
	 */
	public ArrayList<Expatriate> queryAllFinishExpatriate() throws SQLException {
		
		return dao.queryAllFinish();
	}
	
	/**
	 * 查询所有需求记录
	 * @throws SQLException 
	 */
	public ArrayList<Expatriate> queryAllUnfinishedExpatriate() throws SQLException {
		
		return dao.queryAllUnfinished();
	}
	
}
