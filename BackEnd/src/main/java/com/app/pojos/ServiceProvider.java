package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="service_provider")
public class ServiceProvider {

	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="sp_id")
		private int serviceProviderId;
		@Column(name="first_name",length = 30 )
		private String firstName;
		@Column(name="last_name",length = 30 )
		private String lastName;
		@Column(name="gender",length = 50 )
		private String gender;
		@Column(name="email",length = 50 ,unique = true )
		private String email;
		@Column(name="password",length = 20)
		private String password;
		@Column(name="charges")
		private Double charges;
		@Column(name="experience")
		private Double experience;
		@Column(name="address",length = 100)
		private String address;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		
		private LocalDate dob;
		@Column(name="mobile")
		private String mobile;
		
		@Lob
		private byte[] profileImg;
		@Column(name="aadhar_number")
		private String aadharNumber;
		
		
		@Column(name="service_name")
		private String serviceName;
		
		//one to many relation of service provider with booking cart
		//one service provider can have many bookings
			
		
        
		//many to one relation of service provider with service id
		//many service provider can have same service id
		
		private int Service_id;


		public int getService_id() {
			return Service_id;
		}


		public void setService_id(int service_id) {
			Service_id = service_id;
		}


		public ServiceProvider() {
			System.out.println("in constructor of "+getClass().getName());
		}


		public int getServiceProviderId() {
			return serviceProviderId;
		}


		public void setServiceProviderId(int serviceProviderId) {
			this.serviceProviderId = serviceProviderId;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public Double getCharges() {
			return charges;
		}


		public void setCharges(Double charges) {
			this.charges = charges;
		}


		public Double getExperience() {
			return experience;
		}


		public void setExperience(Double experience) {
			this.experience = experience;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public LocalDate getDob() {
			return dob;
		}


		public void setDob(LocalDate dob) {
			this.dob = dob;
		}


		public String getMobile() {
			return mobile;
		}


		public void setMobile(String mobile) {
			this.mobile = mobile;
		}


	


		public String getAadharNumber() {
			return aadharNumber;
		}


		public void setAadharNumber(String aadharNumber) {
			this.aadharNumber = aadharNumber;
		}


		public String getServiceName() {
			return serviceName;
		}


		public void setServiceName(String serviceName) {
			System.out.println("in setter of service name");
			this.serviceName = serviceName;
		}


		public byte[] getProfileImg() {
			return profileImg;
		}

		 

		public void setProfileImg(byte[] profileImg) {
			this.profileImg = profileImg;
		}


		@Override
		public String toString() {
			return "ServiceProvider [serviceProviderId=" + serviceProviderId + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", password=" + password
					+ ", charges=" + charges + ", experience=" + experience + ", address=" + address + ", dob=" + dob
					+ ", mobile=" + mobile + ", profileImg=" + Arrays.toString(profileImg) + ", aadharNumber="
					+ aadharNumber + ", serviceName=" + serviceName + ", Service_id=" + Service_id + "]";
		}


		




}


