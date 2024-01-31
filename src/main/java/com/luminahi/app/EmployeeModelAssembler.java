package com.luminahi.app;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
    
    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        
        try {
            return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
        } catch (EmployeeNotFoundException e) {
            return EntityModel.of(employee,
                    linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
        }
    }
}
