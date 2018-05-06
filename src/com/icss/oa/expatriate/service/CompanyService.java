package com.icss.oa.expatriate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.expatriate.dao.CompanyDao;
import com.icss.oa.expatriate.pojo.Company;


/**
 * @author Administrator
 * ������˾ҵ��
 */
public class CompanyService {
private CompanyDao dao = new CompanyDao();
	
	/**
	 * ���Ӻ�����˾
	 * @throws SQLException 
	 */
	public void addCompany(Company cp) throws SQLException {
		dao.insert(cp);
	}
	
	/**
	 * ɾ��������˾
	 */
	public void deleteCompany(int cp) throws SQLException {
		dao.delete(cp);
	}	
	
	/**
	 * ��ѯ���к�����˾
	 * @throws SQLException 
	 */
	public ArrayList<Company> queryAllCompany() throws SQLException {
		
		return dao.queryAll();
	}
}
