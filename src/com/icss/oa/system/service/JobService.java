package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.system.dao.JobDao;
import com.icss.oa.system.pojo.Job;

/**
 * ְ��ҵ����
 * @author Administrator
 *
 */
public class JobService {
	
	private JobDao dao = new JobDao();
	
	/**
	 * ��ѯ����ְ��
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Job> queryAllJob() throws SQLException {
		return dao.queryAll();
	}
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addJob(Job id) throws SQLException {
		dao.insert(id);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateJob(Job id) throws SQLException {
		dao.update(id);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteJob(int id) throws SQLException {
		dao.delete(id);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public Job queryJobById(int id) throws SQLException {
		
		return dao.queryById(id);
	}
}