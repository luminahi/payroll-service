package com.luminahi.app;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue
    private Long id;
    private String role;
    private String firstName;
    private String lastName;
    
    public Employee() {}

    public Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getName() {
        return firstName  + " " + lastName;
    }

    
    public void setName(String name) {
        String[] words = name.split(" ");
        this.firstName = words[0];
        this.lastName = words[1];
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, role);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        
        Employee employee = (Employee) obj;
        
        return Objects.equals(this.id, employee.id) &&
                Objects.equals(this.firstName, employee.firstName) &&
                Objects.equals(this.lastName, employee.lastName) &&
                Objects.equals(this.role, employee.role);
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' + ", role='" + this.role + '\'' + '}';    
    }
}
