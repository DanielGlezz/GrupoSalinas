package com.mx.GS_RecursosHumanos.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.GS_RecursosHumanos.Domain.Employee;

@FeignClient(name = "GS_RecursosHumanos", url = "http://localhost:1234") // Cambia la URL y nombre si es necesario
public interface EmployeeClient {
	@PostMapping("/employees/addEmployee")
	String addEmployee(@RequestBody Employee employee);
}
