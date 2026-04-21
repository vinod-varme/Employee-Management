package com.miraiedge.port;
import com.miraiedge.domain.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepositoryPort {

    Mono<Employee> save(Employee emp);

    Flux<Employee> findAll();

    Mono<Employee> findById(Long id);

    Mono<Void> deleteById(Long id);
}
