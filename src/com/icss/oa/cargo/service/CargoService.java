package com.icss.oa.cargo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.cargo.dao.CargoDao;
import com.icss.oa.cargo.pojo.Cargo;
import com.icss.oa.common.Pager;

public class CargoService {
private CargoDao dao = new CargoDao();
	
	public void addCargo(Cargo cp) throws SQLException {
		dao.insert(cp);
	}	
	
	public ArrayList<Cargo> queryAllCargo(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	
	public int getCargoCount() throws SQLException {
		return dao.getCount();
	}
}
