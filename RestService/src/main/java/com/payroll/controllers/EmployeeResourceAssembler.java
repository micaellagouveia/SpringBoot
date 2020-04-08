package com.payroll.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.payroll.controllers.EmployeeController;
import com.payroll.models.Employee;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResourceAssembler implements RepresentationModelAssembler <Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel (Employee employee){
        return new EntityModel<>(employee,
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
}
//toModel -> conversão de um objeto que é non-resource (Employee) em um objeto resource-based (EntityModel<Employee)
