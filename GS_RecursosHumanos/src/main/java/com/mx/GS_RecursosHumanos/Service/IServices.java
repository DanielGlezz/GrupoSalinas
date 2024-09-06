package com.mx.GS_RecursosHumanos.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.mx.GS_RecursosHumanos.Domain.Contract;
import com.mx.GS_RecursosHumanos.Domain.Employee;
import com.mx.GS_RecursosHumanos.Domain.DTO.EmployeeContractDTO;

public interface IServices {

	public List<EmployeeContractDTO> listar();

	public void agregarContrato(Integer employeeId, Short contractTypeId, LocalDateTime dateFrom, LocalDateTime dateTo,
			BigDecimal salaryPerDay);

	public void agregarEmpleado(Employee employee);

	public void actualizar(Employee employee);

	public void eliminarContrato(Contract contract);

}
