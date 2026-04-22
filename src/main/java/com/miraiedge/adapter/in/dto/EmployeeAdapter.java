package com.miraiedge.adapter.in.dto;

import com.miraiedge.domain.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeAdapter {

    public Employee mapRequestDtoToEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee();
       // employee.setId(employeeDto.getId());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }

    public Flux<EmployeeDto> mapEmployeeEntityToDto(Flux<Employee> employeeList) {
        return employeeList.map(emp -> {
            EmployeeDto dto = new EmployeeDto();
            dto.setId(emp.getId());
            dto.setEmployeeName(emp.getEmployeeName());
            dto.setDesignation(emp.getDesignation());
            dto.setSalary(emp.getSalary());
            return dto;
        });
    }

    public Mono<EmployeeDto> mapEmployeeEntityToEmployeeDto(Mono<Employee> emp) {
        return emp.map(employee -> {
            EmployeeDto dto = new EmployeeDto();
            dto.setId(employee.getId());
            dto.setEmployeeName(employee.getEmployeeName());
            dto.setDesignation(employee.getDesignation());
            dto.setSalary(employee.getSalary());
            return dto;
        });
    }
}
