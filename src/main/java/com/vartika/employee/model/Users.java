package com.vartika.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.javafaker.Name;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "roles")

@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "employee")
@EqualsAndHashCode(exclude = "employee")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;
	private String email;

	@ManyToOne
	//@JoinColumn(name="email_id_fk", nullable = false)
	@JoinColumn(name="roles", nullable = false)
	@JsonBackReference
	private Employee employee;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	




}
