package com.luminahi.app;

public class EmployeeNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
