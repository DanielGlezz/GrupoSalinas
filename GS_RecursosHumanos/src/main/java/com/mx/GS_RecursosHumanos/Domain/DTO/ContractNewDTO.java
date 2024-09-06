package com.mx.GS_RecursosHumanos.Domain.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ContractNewDTO {
	private Integer employeeId;
	private Short contractTypeId;
	private LocalDateTime dateFrom;
	private LocalDateTime dateTo;
	private BigDecimal salaryPerDay;

	public ContractNewDTO(Integer employeeId, Short contractTypeId, LocalDateTime dateFrom, LocalDateTime dateTo,
			BigDecimal salaryPerDay) {
		super();
		this.employeeId = employeeId;
		this.contractTypeId = contractTypeId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.salaryPerDay = salaryPerDay;
	}

}
