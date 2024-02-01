package com.luminahi.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading" + employeeRepository.save(new Employee("alex", "lux", "programmer")));
            log.info("Preloading" + employeeRepository.save(new Employee("sara", "belarus","warrior")));
            
            log.info("Preloading" + orderRepository.save(new Order("MacBook Pro", Status.COMPLETED)));
            log.info("Preloading" + orderRepository.save(new Order("iPhone", Status.IN_PROGRESS)));
        };
    }
}
