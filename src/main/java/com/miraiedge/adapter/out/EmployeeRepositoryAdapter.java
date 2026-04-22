package com.miraiedge.adapter.out;

import com.miraiedge.domain.Employee;
import com.miraiedge.port.EmployeeRepositoryPort;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class EmployeeRepositoryAdapter implements EmployeeRepositoryPort {

    private final EmployeeRepository repo;
    private final DatabaseClient client;
    public EmployeeRepositoryAdapter(EmployeeRepository repo,DatabaseClient client) {
        this.repo = repo;
        this.client = client;
    }

    @Override
    public Mono<Employee> save(Employee emp) {
        EmployeeEntity entity = toEntity(emp);
        return repo.save(entity).map(this::toDomain);
    }

    @Override
    public Flux<Employee> findAll() {
        return repo.findAll().map(this::toDomain);
    }

    @Override
    public Mono<Employee> findById(Long id) {
        return repo.findById(id).map(this::toDomain);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return repo.deleteById(id);
    }

    private EmployeeEntity toEntity(Employee emp) {
        EmployeeEntity e = new EmployeeEntity();
        e.setId(emp.getId());
        e.setName(emp.employeeName);
        e.setDesignation(emp.designation);
        e.setSalary(emp.getSalary());
        return e;
    }

    private Employee toDomain(EmployeeEntity e) {
        Employee emp = new Employee();
        emp.setId(e.getId());
        emp.setEmployeeName(e.getName());
        emp.setDesignation(e.getDesignation());
        emp.setSalary(e.getSalary());
        return emp;
    }

    @Override
    public Mono<Long> getEmployeeCount() {
        return client.sql("SELECT getEmployeeCount()")
                .map((row, meta) -> row.get(0, Long.class))
                .one();
    }
}