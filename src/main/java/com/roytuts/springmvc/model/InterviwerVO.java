package com.roytuts.springmvc.model;

public class InterviwerVO {
	
	int interviewId;
	int resourceId;
	String jobCode;
	int round;
	String interviewedBy;
	String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public 	String getJobCode() {
		return jobCode;
	}
	public void setJobCode(	String jobCode) {
		this.jobCode = jobCode;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getInterviewedBy() {
		return interviewedBy;
	}
	public void setInterviewedBy(String interviewedBy) {
		this.interviewedBy = interviewedBy;
	}
}
