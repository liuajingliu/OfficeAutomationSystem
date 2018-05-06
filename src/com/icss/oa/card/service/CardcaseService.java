package com.icss.oa.card.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.dao.CardcaseDao;
import com.icss.oa.card.pojo.Cardcase;

public class CardcaseService {
	private CardcaseDao dao = new CardcaseDao();

	
	public void addCardcase(Cardcase cc) throws SQLException {
		dao.insert(cc);
	}

	public void deleteCardcase(int id) throws SQLException {
		dao.delete(id);
	}

	public ArrayList<Cardcase> queryAllCardcase(int empid) throws SQLException {
		return dao.queryAll(empid);
	}
}
