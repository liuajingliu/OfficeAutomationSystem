package com.icss.oa.system.pojo;

import java.sql.Date;

/**
 * 员工实体类
 * @author Administrator
 *
 */
public class Employee {
	
	private int empId;
	
	private String empName;
	
	private String empPhone;
	
	private Date empBirthday;
	
	private String email;
	
	private String qq;
	
	private String pwd;

	private Department dept; //多对一
	
	private Job job; //多对一

	public Employee() {
	}
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	
	public Employee(int empId, String empName, String empPhone,
			Date empBirthday, String email, String qq, Department dept, Job job) {
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empBirthday = empBirthday;
		this.email = email;
		this.qq = qq;
		this.dept = dept;
		this.job = job;
	}

	public Employee(int empId, String empName, String empPhone,
			Date empBirthday, String email, String qq, String pwd,
			Department dept, Job job) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empBirthday = empBirthday;
		this.email = email;
		this.qq = qq;
		this.pwd = pwd;
		this.dept = dept;
		this.job = job;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public Date getEmpBirthday() {
		return empBirthday;
	}

	public void setEmpBirthday(Date empBirthday) {
		this.empBirthday = empBirthday;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empPhone=" + empPhone + ", empBirthday=" + empBirthday
				+ ", email=" + email + ", qq=" + qq + ", pwd=" + pwd
				+ ", dept=" + dept + ", job=" + job + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
