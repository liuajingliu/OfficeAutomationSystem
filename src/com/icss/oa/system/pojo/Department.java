package com.icss.oa.system.pojo;

/**
 *  µÃÂ¿‡
 * 
 * @author Administrator
 * 
 */
public class Department {

	private int deptId;

	private String deptName;

	private String deptDesc;

	public Department() {
		super();
	}
	
	
	
	public Department(int deptId) {
		super();
		this.deptId = deptId;
	}



	public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}


	public Department(String deptName, String deptDesc) {
		super();
		this.deptName = deptName;
		this.deptDesc = deptDesc;
	}

	public Department(int deptId, String deptName, String deptDesc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName
				+ ", deptDesc=" + deptDesc + "]";
	}	
}