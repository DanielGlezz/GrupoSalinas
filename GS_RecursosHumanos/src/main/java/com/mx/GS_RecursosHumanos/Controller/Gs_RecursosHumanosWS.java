package com.mx.GS_RecursosHumanos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.GS_RecursosHumanos.Domain.Employee;
import com.mx.GS_RecursosHumanos.Domain.DTO.ContractNewDTO;
import com.mx.GS_RecursosHumanos.Domain.DTO.EmployeeContractDTO;
import com.mx.GS_RecursosHumanos.Service.ServicesImplements;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/GsRecursosHumanos")

@Api(value = "Gestión de Recursos Humanos", description = "Operaciones relacionadas con empleados y contratos")
public class Gs_RecursosHumanosWS {

	@Autowired
	private ServicesImplements service;

	@ApiOperation(value = "Listar empleados con detalles de contrato", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Empleados listados exitosamente"),
        @ApiResponse(code = 404, message = "No existen empleados")
    })
	@GetMapping
	public ResponseEntity<?> listarEmployee() {
		List<EmployeeContractDTO> empleados = service.listar();

		if (empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"No existen Empleados. \"}");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(empleados);
		}
	}

	@ApiOperation(value = "Agregar un nuevo contrato a un empleado")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Contrato agregado exitosamente"),
        @ApiResponse(code = 500, message = "Error al agregar contrato")
    })
	@PostMapping
	public ResponseEntity<?> addNewContract(@RequestBody ContractNewDTO contractNewDTO) {
		try {

			service.agregarContrato(contractNewDTO.getEmployeeId(), contractNewDTO.getContractTypeId(),
					contractNewDTO.getDateFrom(), contractNewDTO.getDateTo(), contractNewDTO.getSalaryPerDay());
			return ResponseEntity.status(HttpStatus.CREATED).body("{\"Mensaje\":\"Contrato agregado exitosamente.\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("{\"Mensaje\":\"Error al agregar contrato: " + e.getMessage() + "\"}");
		}
	}

	 @ApiOperation(value = "Agregar un nuevo empleado")
	    @ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Empleado agregado exitosamente"),
	        @ApiResponse(code = 409, message = "El RFC ya está registrado para otro empleado"),
	        @ApiResponse(code = 500, message = "Error al agregar empleado")
	    })
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {

			service.agregarEmpleado(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body("{\"Mensaje\":\"Empleado agregado exitosamente.\"}");

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"Mensaje\":\"" + e.getMessage() + "\"}");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("{\"Mensaje\":\"Error al agregar empleado: " + e.getMessage() + "\"}");
		}
	}
}
