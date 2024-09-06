package com.mx.GS_RecursosHumanos.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.GS_RecursosHumanos.Dao.IContractDao;
import com.mx.GS_RecursosHumanos.Dao.IContractTypeDao;
import com.mx.GS_RecursosHumanos.Dao.IEmployeeDao;
import com.mx.GS_RecursosHumanos.Domain.Contract;
import com.mx.GS_RecursosHumanos.Domain.ContractType;
import com.mx.GS_RecursosHumanos.Domain.Employee;
import com.mx.GS_RecursosHumanos.Domain.DTO.EmployeeContractDTO;

@Service
public class ServicesImplements implements IServices {

	@Autowired
	private IEmployeeDao employeeDao;

	@Autowired
	private IContractDao contractDao;

	@Autowired
	private IContractTypeDao contractTypeDao;

	@Override
	public List<EmployeeContractDTO> listar() {
		return employeeDao.findEmployeesActive();
	}

	@Override
	public void agregarContrato(Integer employeeId, Short contractTypeId, LocalDateTime dateFrom, LocalDateTime dateTo,
			BigDecimal salaryPerDay) {

		Employee employee = employeeDao.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

		ContractType contractType = contractTypeDao.findById(contractTypeId)
				.orElseThrow(() -> new RuntimeException("Tipo de contrato no encontrado"));

		Optional<Contract> contractActive = contractDao.findActiveContractByEmployeeId(employeeId);

		if (contractActive.isPresent()) {
			Contract activeContract = contractActive.get();
			activeContract.setDateTo(LocalDateTime.now());
			activeContract.setActive(false); // Marcar el contrato como inactivo
			contractDao.save(activeContract);
		}
		Contract addContract = new Contract();
		addContract.setEmployee(employee);
		addContract.setContractType(contractType);
		addContract.setDateFrom(dateFrom);
		addContract.setDateTo(dateTo);
		addContract.setSalaryPerDay(salaryPerDay);
		addContract.setActive(true);
		addContract.setDateCreated(LocalDateTime.now());

		contractDao.save(addContract);
	}

	// uso del regex
	private static final String RFC_REGEX = "^[A-ZÑ&]{3,4}\\d{6}[A-V1-9][A-Z1-9][0-9A]$";

	@Override
	public void agregarEmpleado(Employee employee) {

		if (!employee.getTaxIdNumber().matches(RFC_REGEX)) {
			throw new IllegalArgumentException("El formato del RFC es incorrecto");
		}

		boolean rfcExiste = employeeDao.existsByTaxIdNumber(employee.getTaxIdNumber());
		if (rfcExiste) {
			throw new RuntimeException("El RFC ya está registrado para otro empleado");
		}

		employeeDao.save(employee);

	}

	@Override
	public void actualizar(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarContrato(Contract contract) {
		// TODO Auto-generated method stub

	}

}
