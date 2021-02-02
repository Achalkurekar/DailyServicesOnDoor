package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "service_table")
public class ServiceTable 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_id")
	private Integer serviceId;	
	
	@Column(name="service_name")
	private String serviceName;
	
	//one to many relation of service with service provider
	//one service can have many service provider
    private Integer s_id;
	
	
	public ServiceTable() {
		System.out.println("in constructor of "+getClass().getName());
	}
	
	

	public ServiceTable(Integer serviceId, String serviceName, Integer s_id) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.s_id=s_id;
	}



	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	



	public Integer getS_id() {
		return s_id;
	}



	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}



	@Override
	public String toString() {
		return "ServiceTable [serviceId=" + serviceId + ", serviceName=" + serviceName + ", s_id=" + s_id + "]";
	}

	
	
}
