package com.icss.oa.notice.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.notice.dao.NoticetDao;
import com.icss.oa.notice.pojo.Notice;

/**
 * ����ҵ��
 * @author Administrator
 *
 */
public class NoticeService {
	
	private NoticetDao dao = new NoticetDao();
	
	/**
	 * ���ӹ���
	 * @throws SQLException 
	 */
	public void addNotice(Notice nt) throws SQLException {
		dao.insert(nt);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteNotice(int ntId) throws SQLException {
		dao.delete(ntId);
	}	
	
	/**
	 * ��ѯ���й���
	 * @throws SQLException 
	 */
	public ArrayList<Notice> queryAllNotice() throws SQLException {
		
		return dao.queryAll();
	}

}