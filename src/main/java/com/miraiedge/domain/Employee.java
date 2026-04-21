package com.miraiedge.domain;

public class Employee {
   public Long id;
   public String employeeName;
   public String designation;
   public Double salary;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getEmployeeName() {
      return employeeName;
   }

   public void setEmployeeName(String employeeName) {
      this.employeeName = employeeName;
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
