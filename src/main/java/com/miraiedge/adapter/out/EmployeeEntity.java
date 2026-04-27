package com.miraiedge.adapter.out;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("employeedata")
public class EmployeeEntity {
    @Id
    private Long id;
    private String name;
    private String designation;
    private Double salary;
    public String jsondata;

    public String getJsonData() {
        return jsondata;
    }

    public void setJsonData(String jsonData) {
        this.jsondata = jsonData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
