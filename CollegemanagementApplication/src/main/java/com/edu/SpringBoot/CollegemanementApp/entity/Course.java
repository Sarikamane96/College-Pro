package com.edu.SpringBoot.CollegemanementApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
	@Entity
	@Table(name="courseTbl")
	public class Course {
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column
		private long id;
		@Column(name="coursename")
		private String coursename;
		@Column(name="classe")
		private String classe;
		@Column(name="department")
		private String department;
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCourseName() {
			return coursename;
		}
		public void setCourseName(String coursename) {
			this.coursename = coursename;
		}
		public String getClasse() {
			return classe;
		}
		public void setClasse(String classe) {
			this.classe = classe;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		

}
