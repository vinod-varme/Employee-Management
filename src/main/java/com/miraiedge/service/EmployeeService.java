package com.miraiedge.service;

import com.miraiedge.adapter.in.dto.EmployeeAdapter;
import com.miraiedge.adapter.in.dto.EmployeeDto;
import com.miraiedge.domain.Employee;
import com.miraiedge.port.EmployeeRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepositoryPort repo;
    private final EmployeeAdapter employeeAdapter;
    public EmployeeService(EmployeeRepositoryPort repo,EmployeeAdapter employeeAdapter) {
        this.repo = repo;
        this.employeeAdapter=employeeAdapter;
    }

    public Mono<Employee> saveEmployee(EmployeeDto employeeDto) {
        Employee emploee=employeeAdapter.mapRequestDtoToEmployee(employeeDto);
        return repo.save(emploee);
    }

    public Flux<EmployeeDto> getListOfEmployees() {
        Flux<Employee> employeeList= repo.findAll();
        return employeeAdapter.mapEmployeeEntityToDto(employeeList);
    }

    public Mono<EmployeeDto> getEmployeeById(Long id) {
        Mono<Employee> emp= repo.findById(id);
        return employeeAdapter.mapEmployeeEntityToEmployeeDto(emp);
    }

    public Mono<Employee> updateEmployeeById(Long id, Employee emp) {
        return repo.findById(id)
                .flatMap(existing -> {
                    existing.setEmployeeName(emp.getEmployeeName());
                    existing.setDesignation(emp.getDesignation());
                    existing.setSalary(emp.getSalary());
                    return repo.save(existing);
                });
    }

    public Mono<Void> deleteEmployeeById(Long id) {
        return repo.deleteById(id);
    }

    public Mono<Long> getEmployeeCount(){
        return repo.getEmployeeCount();
    };

}
