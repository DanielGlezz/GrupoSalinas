package com.mx.GS_RecursosHumanos.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Contract")
@Data
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contractId;

	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "contractTypeId", nullable = false)
	private ContractType contractType;

	@Column(nullable = false)
	private LocalDateTime dateFrom;

	@Column(nullable = false)
	private LocalDateTime dateTo;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal salaryPerDay;

	@Column(nullable = false)
	private boolean isActive;

	@Column(nullable = false)
	private LocalDateTime dateCreated;
}
