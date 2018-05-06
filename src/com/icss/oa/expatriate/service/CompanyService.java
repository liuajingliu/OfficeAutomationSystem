package com.icss.oa.expatriate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.expatriate.dao.CompanyDao;
import com.icss.oa.expatriate.pojo.Company;


/**
 * @author Administrator
 * 合作公司业务
 */
public class CompanyService {
private CompanyDao dao = new CompanyDao();
	
	/**
	 * 增加合作公司
	 * @throws SQLException 
	 */
	public void addCompany(Company cp) throws SQLException {
		dao.insert(cp);
	}
	
	/**
	 * 删除合作公司
	 */
	public void deleteCompany(int cp) throws SQLException {
		dao.delete(cp);
	}	
	
	/**
	 * 查询所有合作公司
	 * @throws SQLException 
	 */
	public ArrayList<Company> queryAllCompany() throws SQLException {
		
		return dao.queryAll();
	}
}
