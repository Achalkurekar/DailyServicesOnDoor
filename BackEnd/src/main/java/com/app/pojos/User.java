package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name=" user_id")
		private Integer UserId;
		
		@Column(name="email",unique = true)
		private String Email;
		
		@Column(name="password",length = 20)
		private String Password;

		private String firstName;
		private String LastName;
		
		@Column(name="Mobile")
		private String Mobile;

		@Column(name="address",length = 100)
		private String Address;
		
		
		//one to many relation of user with booking cart
		//one user can book many service providers from booking
		@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
		private List<BookingCart> cart=new ArrayList<>();    
		
		 
		public User() {
			System.out.println("in constructor of "+getClass().getName());
		}

		
		public User(Integer userId, String email, String password, String firstName, String LastName, String mobile,
				String address, List<BookingCart> cart) {
			super();
			UserId = userId;
			Email = email;
			Password = password;
			firstName = firstName;
			LastName = LastName;
			Mobile = mobile;
			Address = address;
			this.cart = cart;
		}


		public Integer getUserId() {
			return UserId;
		}


		public void setUserId(Integer userId) {
			UserId = userId;
		}


		public String getEmail() {
			return Email;
		}


		public void setEmail(String email) {
			Email = email;
		}


		public String getPassword() {
			return Password;
		}


		public void setPassword(String password) {
			Password = password;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return LastName;
		}


		public void setLastName(String LastName) {
			this.LastName = LastName;
		}


		public String getMobile() {
			return Mobile;
		}


		public void setMobile(String mobile) {
			Mobile = mobile;
		}


		public String getAddress() {
			return Address;
		}


		public void setAddress(String address) {
			Address = address;
		}






		@Override
		public String toString() {
			return "User [UserId=" + UserId + ", Email=" + Email + ", Password=" + Password + ", firstName=" + firstName
					+ ", LastName=" + LastName + ", Mobile=" + Mobile + ", Address=" + Address + "]";
		}


}
