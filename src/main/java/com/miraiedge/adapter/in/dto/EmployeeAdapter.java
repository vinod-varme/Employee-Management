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
        employee.setId(employeeDto.getId());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }

    public List<EmployeeDto> mapEmployeeEntityToDto(Flux<Employee> employeeList) {
        List<EmployeeDto> listEmployeeDto=new ArrayList<>();
        for(Employee emp:employeeList.toIterable()){
            EmployeeDto  employeeDto=new EmployeeDto();
            employeeDto.setId(emp.getId());
            employeeDto.setEmployeeName(emp.getEmployeeName());
            employeeDto.setDesignation(emp.getDesignation());
            employeeDto.setSalary(emp.getSalary());
            listEmployeeDto.add(employeeDto);
        }
        return listEmployeeDto;
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
