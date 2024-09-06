package com.mx.GS_RecursosHumanos.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.GS_RecursosHumanos.Domain.Employee;
import com.mx.GS_RecursosHumanos.Domain.DTO.EmployeeContractDTO;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

	@Query("SELECT new com.mx.GS_RecursosHumanos.Domain.DTO.EmployeeContractDTO( "
			+ "CONCAT(e.name, ' ', e.lastName), e.taxIdNumber, e.email, "
			+ "COALESCE(c.contractType.name, NULL), c.dateFrom, c.dateTo, c.salaryPerDay) " 
			+ "FROM Employee e "
			+ "LEFT JOIN Contract c ON e.employeeId = c.employee.employeeId AND c.isActive = true "
			+ "WHERE e.isActive = true")
	List<EmployeeContractDTO> findEmployeesActive();

	// consulta para la numero 3

	boolean existsByTaxIdNumber(String taxIdNumber);

}
