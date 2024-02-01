package com.luminahi.app;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    
    @Override
    public EntityModel<Order> toModel(Order order) {
        
        EntityModel<Order> orderModel;
        
        try {
            orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));
        } catch (OrderNotFoundException e) {
            orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));
        }
        
        if (order.getStatus() == Status.IN_PROGRESS) {
            try {
                orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
                orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));
            } catch (OrderNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        return orderModel;
    }
}
