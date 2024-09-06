package com.mx.GS_RecursosHumanos.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.GS_RecursosHumanos.Domain.Contract;

@Repository
public interface IContractDao extends JpaRepository<Contract, Long> {

	@Query("SELECT c FROM Contract c WHERE c.employee.employeeId = :employeeId AND c.isActive = true")
	Optional<Contract> findActiveContractByEmployeeId(@Param("employeeId") Integer employeeId);

}
