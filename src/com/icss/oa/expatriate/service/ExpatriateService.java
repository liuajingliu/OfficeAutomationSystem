package com.icss.oa.expatriate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.expatriate.dao.ExpatriateDao;
import com.icss.oa.expatriate.pojo.Expatriate;

/**
 * @author Administrator
 * ��ǲ��¼ҵ��
 */
public class ExpatriateService {
	private ExpatriateDao dao = new ExpatriateDao();
	
	/**
	 * ������ǲ��¼
	 * @throws SQLException 
	 */
	public void addExpatriate(Expatriate ps) throws SQLException {
		dao.insert(ps);
	}
	
	/**
	 * ɾ����ǲ��¼
	 */
	public void deleteExpatriate(int ps) throws SQLException {
		dao.delete(ps);
	}	
	
	/**
	 * ��ѯ���������ǲ��¼
	 * @throws SQLException 
	 */
	public ArrayList<Expatriate> queryAllFinishExpatriate() throws SQLException {
		
		return dao.queryAllFinish();
	}
	
	/**
	 * ��ѯ���������¼
	 * @throws SQLException 
	 */
	public ArrayList<Expatriate> queryAllUnfinishedExpatriate() throws SQLException {
		
		return dao.queryAllUnfinished();
	}
	
}
