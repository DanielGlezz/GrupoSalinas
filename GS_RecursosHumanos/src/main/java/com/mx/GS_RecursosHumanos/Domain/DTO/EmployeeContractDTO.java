package com.mx.GS_RecursosHumanos.Domain.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EmployeeContractDTO {
	private String fullName;
	private String taxIdNumber;
	private String email;
	private String contractTypeName;
	private LocalDateTime contractStartDate;
	private LocalDateTime contractEndDate;
	private BigDecimal salaryPerDay;

	public EmployeeContractDTO(String fullName, String taxIdNumber, String email, String contractTypeName,
			LocalDateTime contractStartDate, LocalDateTime contractEndDate, BigDecimal salaryPerDay) {
		this.fullName = fullName;
		this.taxIdNumber = taxIdNumber;
		this.email = email;
		this.contractTypeName = contractTypeName;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.salaryPerDay = salaryPerDay;
	}

}
