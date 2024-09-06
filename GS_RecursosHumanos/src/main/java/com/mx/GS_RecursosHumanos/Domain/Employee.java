package com.mx.GS_RecursosHumanos.Domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;

	@Column(length = 13, nullable = false)
	private String taxIdNumber; // RFC

	@Column(length = 60, nullable = false)
	private String name;

	@Column(length = 120, nullable = false)
	private String lastName;

	@Column(nullable = false)
	private LocalDateTime birthDate;

	@Column(length = 60, nullable = false)
	private String email;

	@Column(length = 20, nullable = false)
	private String cellPhone;

	@Column(nullable = false)
	private boolean isActive;

	@Column(nullable = false)
	private LocalDateTime dateCreated;

}
