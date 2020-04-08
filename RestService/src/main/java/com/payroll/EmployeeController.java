package com.payroll;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;
    private final EmployeeResourceAssembler assembler;


    public EmployeeController(EmployeeRepository repository, EmployeeResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/employees")
    CollectionModel<EntityModel<Employee>> all() {
        List<EntityModel<Employee>> employees = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @PostMapping("/employees")
    ResponseEntity<?> newEmployee (@RequestBody Employee newEmployee) throws URISyntaxException {
        EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @GetMapping("/employees/{id}")
    EntityModel <Employee> one(@PathVariable Long id) {
        Employee employee = repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));

        return assembler.toModel(employee);
    }

    @PutMapping("employees/{id}")
    // Jeito de dar replace ou adicionar novo funcionario para que seja incluso nome e separe em nome e sobrenome
    ResponseEntity<?> replaceEmployee (@RequestBody Employee newEmployee, @PathVariable Long id) throws URISyntaxException{
        Employee updatedEmployee = repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return repository.save(employee);
        }).orElseGet(()->{
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });

        EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);
        //getRequiredLink -> recuperar o link criado pelo EmployeeResourceAssembler com um self rel. toUri() -> cast para URI.
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/employees/{id}")
   ResponseEntity<?> deleteEmployee (@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}

// EntityModel: container genérico do HATEOAS inclui não apenas dados, mas uma coleção de links.
// Construir um link? Inclui em URI e um rel (relação)
// CollectionModel: container HATEOAS destinado a encapsular coleções. Permite incluir links.
// Coleções: coleção de recursos dos funcionários. Você busca todos os funcionários mas os transforma em uma lista de objetos EntityModel.

/*@PutMapping("employees/{id}")
   Employee replaceEmployee (@RequestBody Employee newEmployee, @PathVariable Long id){
        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole((newEmployee.getRole()));
            return repository.save(employee);
        }).orElseGet(()-> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }*/

   /* @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }*/

/*    @DeleteMapping("/employees/{id}")
    void deleteEmployee (@PathVariable Long id) {
        repository.deleteById(id);
    }*/