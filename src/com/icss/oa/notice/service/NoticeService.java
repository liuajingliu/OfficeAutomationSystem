package com.icss.oa.notice.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.notice.dao.NoticetDao;
import com.icss.oa.notice.pojo.Notice;

/**
 * 公告业务
 * @author Administrator
 *
 */
public class NoticeService {
	
	private NoticetDao dao = new NoticetDao();
	
	/**
	 * 增加公告
	 * @throws SQLException 
	 */
	public void addNotice(Notice nt) throws SQLException {
		dao.insert(nt);
	}
	
	/**
	 * 删除公告
	 */
	public void deleteNotice(int ntId) throws SQLException {
		dao.delete(ntId);
	}	
	
	/**
	 * 查询所有公告
	 * @throws SQLException 
	 */
	public ArrayList<Notice> queryAllNotice() throws SQLException {
		
		return dao.queryAll();
	}

}