package com.miraiedge.adapter.in;

import com.miraiedge.adapter.in.dto.EmployeeDto;
import com.miraiedge.domain.Employee;
import com.miraiedge.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/saveEmployee")
    public Mono<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return service.saveEmployee(employeeDto);
    }

    @GetMapping("/getListOfEmployees")
    public Flux<EmployeeDto> getListOfEmployees() {
        return service.getListOfEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Mono<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/updateEmployeeById/{id}")
    public Mono<Employee> updateEmployeeById(@PathVariable Long id,
                                 @RequestBody Employee emp) {
        return service.updateEmployeeById(id, emp);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public Mono<Void> deleteEmployeeById(@PathVariable Long id) {
        return service.deleteEmployeeById(id);
    }
}
