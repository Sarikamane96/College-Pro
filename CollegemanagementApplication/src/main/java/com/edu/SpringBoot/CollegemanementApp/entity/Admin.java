package com.edu.SpringBoot.CollegemanementApp.entity;

	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
	@Data
	@Entity
	@Table(name = "Admin_tbl")
	public class Admin {
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column
		private long id;
		@Column(name="first_name")
		private String firstName;
		@Column(name="last_name")
		private String lastName;
		@Column(name="email")
		private String email;
		@Column(name="mobile_no")
		private long mobile_no;
		
		@Transient
		private int count;
		public Admin() {
		super();
		}
		
		public Admin(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
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
	    
	    public Admin(Long id, String email) {
			super();
			this.id = id;
			this.email = email;
		}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public Admin(long id, long mobile_no) {
			super();
			this.id = id;
			this.mobile_no = mobile_no;          
		}

		public Object getMobile_no() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setMobile_no(Object mobile_no2) {
			// TODO Auto-generated method stub
			
		}

	}
