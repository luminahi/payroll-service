package com.luminahi.app;

public class OrderNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;
    
    public OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}
