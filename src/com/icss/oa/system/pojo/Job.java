package com.icss.oa.system.pojo;

/**
 * 职务实体类
 * @author Administrator
 *
 */
public class Job {
	
	private int jobId;
	
	private String jobName;
	
	private String jobDesc;

	public Job() {
		super();
	}

	
	public Job(int jobId) {
		super();
		this.jobId = jobId;
	}


	public Job(int jobId, String jobName, String jobDesc) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDesc = jobDesc;
	}

	public Job(String jobName, String jobDesc) {
		super();
		this.jobName = jobName;
		this.jobDesc = jobDesc;
	}

	
	public Job(int jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", jobDesc="
				+ jobDesc + "]";
	}
	
	
}