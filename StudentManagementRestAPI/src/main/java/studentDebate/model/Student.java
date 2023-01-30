package com.lab.studentDebate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	private String firstName;
	private String lastName;
	private String course;
	private String country;
	
	public Student(String firstName, String lastName, String course,String country) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.country = country;
	}
}
