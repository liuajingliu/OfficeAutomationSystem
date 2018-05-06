package com.icss.oa.car.pojo;

import java.sql.Date;

/**
 * ³µÁ¾Íâ½è
 * @author Administrator
 *
 */

public class rent {
	
	private int rentId;
	
	private String rentPath;
	
	private Date rentStart;
	
	private Date rentEnd;
	
	private String rentStatus;
	
	private car ccCar;
	
	//private emplyee emp;

	public rent() {
		super();
	}

	public rent(int rentId, String rentPath, Date rentStart, Date rentEnd,
			String rentStatus, car ccCar) {
		super();
		this.rentId = rentId;
		this.rentPath = rentPath;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.rentStatus = rentStatus;
		this.ccCar = ccCar;
	}

	public rent(String rentPath, Date rentStart, Date rentEnd,
			String rentStatus, car ccCar) {
		super();
		this.rentPath = rentPath;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.rentStatus = rentStatus;
		this.ccCar = ccCar;
	}

	public int getRentId() {
		return rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public String getRentPath() {
		return rentPath;
	}

	public void setRentPath(String rentPath) {
		this.rentPath = rentPath;
	}

	public Date getRentStart() {
		return rentStart;
	}

	public void setRentStart(Date rentStart) {
		this.rentStart = rentStart;
	}

	public Date getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(Date rentEnd) {
		this.rentEnd = rentEnd;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public car getCcCar() {
		return ccCar;
	}

	public void setCcCar(car ccCar) {
		this.ccCar = ccCar;
	}

	@Override
	public String toString() {
		return "rent [rentId=" + rentId + ", rentPath=" + rentPath
				+ ", rentStart=" + rentStart + ", rentEnd=" + rentEnd
				+ ", rentStatus=" + rentStatus + ", ccCar=" + ccCar + "]";
	}
	
	public static void main(String[] args) {
		
		car cc = new car();
		cc.setCarId(2);
		
		rent rent = new rent(2,"qwerqwerqwr",Date.valueOf("2016-12-21"),Date.valueOf("2016-12-22"),"finish",cc);
		
		System.out.println(rent);
		
	}

}


























