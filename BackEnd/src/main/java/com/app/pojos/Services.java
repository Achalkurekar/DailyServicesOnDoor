package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="services")
public class Services {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int user_id;
	int Service_provider;
	int feedback_id;
	int feedbackstatus;
	int serstatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ser_Date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getService_provider() {
		return Service_provider;
	}
	public void setService_provider(int service_provider) {
		Service_provider = service_provider;
	}
	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public LocalDate getSerDate() {
		return ser_Date;
	}
	public void setSerDate(LocalDate serDate) {
		this.ser_Date = serDate;
	}
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSerstatus() {
		return serstatus;
	}
	public void setSerstatus(int serstatus) {
		this.serstatus = serstatus;
	}
	public LocalDate getSer_Date() {
		return ser_Date;
	}
	public void setSer_Date(LocalDate ser_Date) {
		this.ser_Date = ser_Date;
	}
	public int getFeedbackstatus() {
		return feedbackstatus;
	}
	public void setFeedbackstatus(int feedbackstatus) {
		this.feedbackstatus = feedbackstatus;
	}
	
	@Override
	public String toString() {
		return "Services [id=" + id + ", user_id=" + user_id + ", Service_provider=" + Service_provider
				+ ", feedback_id=" + feedback_id + ", feedbackstatus=" + feedbackstatus + ", serstatus=" + serstatus
				+ ", ser_Date=" + ser_Date + "]";
	}
	
	
	
	

}
