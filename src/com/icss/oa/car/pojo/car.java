package com.icss.oa.car.pojo;

import java.util.Arrays;

public class car {
	
	private int carId;
	
	private String carType;
	
	private String carNum;
	
	private String carStatus;
	
	private CarPicture CarPic;

	public car() {
		//super();
	}

	public car(int carId, String carType, String carNum, String carStatus,
			CarPicture CarPic) {
		super();
		this.carId = carId;
		this.carType = carType;
		this.carNum = carNum;
		this.carStatus = carStatus;
		this.CarPic = CarPic;
	}

	public car(String carType, String carNum, String carStatus, CarPicture CarPic) {
		super();
		this.carType = carType;
		this.carNum = carNum;
		this.carStatus = carStatus;
		this.CarPic = CarPic;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}

	public CarPicture getCarPic() {
		return CarPic;
	}

	public void setCarPhoto(CarPicture CarPic) {
		this.CarPic = CarPic;
	}

	@Override
	public String toString() {
		return "car [carId=" + carId + ", carType=" + carType + ", carNum="
				+ carNum + ", carStatus=" + carStatus + ", carPhoto="
				+ CarPic + "]";
	}
	
}
