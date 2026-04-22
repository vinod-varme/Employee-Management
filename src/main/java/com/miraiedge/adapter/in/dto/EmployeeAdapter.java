package com.miraiedge.adapter.in.dto;

import com.miraiedge.domain.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class EmployeeAdapter {

    public Employee mapRequestDtoToEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee();
       // employee.setId(employeeDto.getId());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setSalary(employeeDto.getSalary());
        employee.setJsonData(employeeDto.getJsonData());
        return employee;
    }

    public Flux<EmployeeDto> mapEmployeeEntityToDto(Flux<Employee> employeeList) {
        return employeeList.map(emp -> {
            EmployeeDto dto = new EmployeeDto();
            dto.setId(emp.getId());
            dto.setEmployeeName(emp.getEmployeeName());
            dto.setDesignation(emp.getDesignation());
            dto.setSalary(emp.getSalary());
            dto.setJsonData(emp.getJsonData());
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
            dto.setJsonData(employee.getJsonData());
            return dto;
        });
    }
}
