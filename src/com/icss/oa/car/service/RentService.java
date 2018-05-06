package com.icss.oa.car.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.dao.RentDao;
import com.icss.oa.car.pojo.rent;
import com.icss.oa.common.Pager;

public class RentService {
	
	private RentDao dao = new RentDao();
	
	/**
	 * 增加派遣信息
	 * @throws SQLException 
	 */
	public void addRentServerlet(rent t) throws SQLException {
		
		dao.insert(t);
		
	}
	
	/**
	 * 删除派遣信息
	 * @throws SQLException 
	 */
	public void deleteRentServerlet(int rentId) throws SQLException {
		
		dao.delete(rentId);
		
	}
	
	/**
	 *  修改派遣信息
	 * @throws SQLException 
	 */
	public void updateRentServerlet(rent r) throws SQLException {
		
		dao.update(r);
		
	}
	
	/**
	 * 查询单独派遣信息
	 * @throws SQLException 
	 */
	public rent queryRentServerlet(int rentId) throws SQLException {
	
		return dao.queryById(rentId);
		
	}
	
	/**
	 * 查询所有派遣信息
	 * @throws SQLException 
	 */
	public  ArrayList<rent> queryAllRnetServerlet(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
		
	}
	
	/**
	 * 查询总共的派遣信息条数
	 * @throws SQLException 
	 */
	public int getRentCountServerlet() throws SQLException {
		
		return dao.getCount();
		
	}

}
