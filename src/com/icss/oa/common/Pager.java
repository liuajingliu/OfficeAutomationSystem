package com.icss.oa.common;

/**
 * ��ҳ������
 * @author Administrator
 *
 */
public class Pager {

	private int recordCount; //�ܼ�¼��
	
	private int pageSize;//ÿҳ������
	
	private int pageNum;//��ǰҳ��
	
	private int pageCount;//����ҳ
	
	private int start; //��ʼλ��
	
	private int end; //��ֹλ��
	
	public Pager(int recordCount,int pageNum,int pageSize) {
		
		this.recordCount = recordCount;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		
//		���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0) {
			this.pageCount ++;
		}
		
//		���㵱ǰҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;
		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
		
//		������ʼλ��
		this.start = (this.pageNum - 1) * this.pageSize + 1;
//		������ֹλ��
		this.end = this.pageNum * this.pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Pager [recordCount=" + recordCount + ", pageSize=" + pageSize
				+ ", pageNum=" + pageNum + ", pageCount=" + pageCount
				+ ", start=" + start + ", end=" + end + "]";
	}
		
}