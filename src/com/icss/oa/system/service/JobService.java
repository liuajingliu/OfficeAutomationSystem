package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.system.dao.JobDao;
import com.icss.oa.system.pojo.Job;

/**
 * 职务业务类
 * @author Administrator
 *
 */
public class JobService {
	
	private JobDao dao = new JobDao();
	
	/**
	 * 查询所有职务
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Job> queryAllJob() throws SQLException {
		return dao.queryAll();
	}
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addJob(Job id) throws SQLException {
		dao.insert(id);
	}
	
	/**
	 * 修改部门
	 */
	public void updateJob(Job id) throws SQLException {
		dao.update(id);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteJob(int id) throws SQLException {
		dao.delete(id);
	}
	
	/**
	 * 查询单独的部门
	 */
	public Job queryJobById(int id) throws SQLException {
		
		return dao.queryById(id);
	}
}