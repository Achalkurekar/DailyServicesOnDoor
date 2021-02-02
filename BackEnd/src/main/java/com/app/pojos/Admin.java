package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="Admin")
	public class Admin {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="admin_id")
		private int adminId;
		private String email;
		private String password;
		private String name;
		
		
		public Admin() {
			System.out.println("In the Constructor "+getClass().getName());
		}

		public int getAdminId() {
			return adminId;
		}

		public void setAdminId(int adminId) {
			this.adminId = adminId;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", email=" + email + ", password=" + password + ", name=" + name + "]";
		}

	



}
