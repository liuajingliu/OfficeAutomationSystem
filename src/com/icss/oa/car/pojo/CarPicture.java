package com.icss.oa.car.pojo;

import java.io.InputStream;

/**
 * 汽车照片实体类
 * 
 * @author Administrator
 * 
 */
public class CarPicture {

	private int cpId;

	private String cpDesc;

	private InputStream cpPic;

//	private long cpPicSize;

	public CarPicture(int cpId, String cpDesc, InputStream cpPic/*, long cpPicSize*/) {
		super();
		this.cpId = cpId;
		this.cpDesc = cpDesc;
		this.cpPic = cpPic;
//		this.cpPicSize = cpPicSize;
	}

	public int getCpId() {
		return cpId;
	}

	public void setCpId(int cpId) {
		this.cpId = cpId;
	}

	public String getCpDesc() {
		return cpDesc;
	}

	public void setCpDesc(String cpDesc) {
		this.cpDesc = cpDesc;
	}

	public InputStream getCpPic() {
		return cpPic;
	}

	public void setCpPic(InputStream cpPic) {
		this.cpPic = cpPic;
	}

//	public long getCpPicSize() {
//		return cpPicSize;
//	}
//
//	public void setCpPicSize(long cpPicSize) {
//		this.cpPicSize = cpPicSize;
//	}

	public CarPicture() {
		super();
	}

	@Override
	public String toString() {
		return "CarPicture [cpId=" + cpId + ", cpDesc=" + cpDesc + ", cpPic="
				+ cpPic + /*", cpPicSize=" + cpPicSize +*/ "]";
	}

	public CarPicture(String cpDesc, InputStream cpPic/*, long cpPicSize*/) {
		super();
		this.cpDesc = cpDesc;
		this.cpPic = cpPic;
//		this.cpPicSize = cpPicSize;
	}

}