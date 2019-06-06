package com.roytuts.springmvc.model;

public class InterviwerVO {
	
	int interviewId;
	int resourceId;
	int jobCode;
	int round;
	String interviewedBy;
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
	public int getJobCode() {
		return jobCode;
	}
	public void setJobCode(int jobCode) {
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
