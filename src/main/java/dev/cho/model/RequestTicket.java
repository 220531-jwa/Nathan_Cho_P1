package dev.cho.model;

import java.sql.Date;

public class RequestTicket {
	private String status;
	private String subject;
	private String description;
	private Date eventDate;
	private String location;
	private double cost;
	private String eventType;
	private String grade;
	private Date submissionTime;
	private int userId;
	private int id;
	
	public RequestTicket() {
		super();
	}
	public RequestTicket(String st, String su, String desc, Date eD, 
			String loca, double cost, String eT, String grade, Date sT, int uID, int id) {
		
		super();
		this.status = st;
		this.subject = su;
		this.description = desc;
		this.eventDate = eD;
		this.location = loca;
		this.cost = cost;
		this.eventType = eT;
		this.grade = grade;
		this.submissionTime = sT;
		this.userId = uID;
		this.id = id;
	}
	
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public Date getSubmissionTime() {
		return submissionTime;
	}
	
	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
