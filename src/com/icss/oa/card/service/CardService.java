package com.icss.oa.card.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.dao.CardDao;
import com.icss.oa.card.pojo.Card;

public class CardService {
	private CardDao dao = new CardDao();
	
	public void addCard(Card card) throws SQLException {
		dao.insert(card);
	}

	public void deleteCard(int id) throws SQLException {
		dao.delete(id);
	}

	public ArrayList<Card> queryAllCard(int empid) throws SQLException {
		return dao.queryAll(empid);
	}
}
