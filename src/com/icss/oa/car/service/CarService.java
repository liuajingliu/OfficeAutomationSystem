package com.icss.oa.car.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.dao.CarDao;
import com.icss.oa.car.pojo.car;

public class CarService {
	
	private CarDao dao = new CarDao();
	
	/**
	 *  ���ӳ���
	 * @throws SQLException 
	 */
	public void addCarServerlet(car ccCar) throws SQLException {
		
		dao.insert(ccCar);
		
	}
	
	/**
	 * �޸ĳ�����Ϣ
	 */
	
	public void updateCarServerlet(car ccCar) throws SQLException {
		
		dao.update(ccCar);
		
	}
	
	/**
	 * ɾ������
	 */
	
	public void deleteCarServerlet(int carId) throws SQLException {
		
		dao.delete(carId);
		
	}
	
	/**
	 * ��ѯ��������
	 * @throws SQLException 
	 */
	
	public car queryCarServerlet(int carId) throws SQLException {
		
		return dao.queryById(carId);
		
	}
	
	/**
	 * ��ѯ���г���
	 * @throws SQLException 
	 */
	public ArrayList<car> queryAllCarServerlet() throws SQLException {
		
		return dao.queryAll();
		
	}
	
	/**
	 * ��ѯ���г���
	 */
	public ArrayList<car> queryAllFreeServerlet() throws SQLException {
		
		return dao.queryFree();
		
	}
	
	/**
	 * �޸ĳ���״̬
	 * @throws SQLException 
	 */
	
	public void updateCarStatusServerlet(int carId) throws SQLException {
		
		dao.updateCarStatus(carId);
		
	}

}
