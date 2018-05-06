package com.icss.oa.car.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.dao.RentDao;
import com.icss.oa.car.pojo.rent;
import com.icss.oa.common.Pager;

public class RentService {
	
	private RentDao dao = new RentDao();
	
	/**
	 * ������ǲ��Ϣ
	 * @throws SQLException 
	 */
	public void addRentServerlet(rent t) throws SQLException {
		
		dao.insert(t);
		
	}
	
	/**
	 * ɾ����ǲ��Ϣ
	 * @throws SQLException 
	 */
	public void deleteRentServerlet(int rentId) throws SQLException {
		
		dao.delete(rentId);
		
	}
	
	/**
	 *  �޸���ǲ��Ϣ
	 * @throws SQLException 
	 */
	public void updateRentServerlet(rent r) throws SQLException {
		
		dao.update(r);
		
	}
	
	/**
	 * ��ѯ������ǲ��Ϣ
	 * @throws SQLException 
	 */
	public rent queryRentServerlet(int rentId) throws SQLException {
	
		return dao.queryById(rentId);
		
	}
	
	/**
	 * ��ѯ������ǲ��Ϣ
	 * @throws SQLException 
	 */
	public  ArrayList<rent> queryAllRnetServerlet(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
		
	}
	
	/**
	 * ��ѯ�ܹ�����ǲ��Ϣ����
	 * @throws SQLException 
	 */
	public int getRentCountServerlet() throws SQLException {
		
		return dao.getCount();
		
	}

}
