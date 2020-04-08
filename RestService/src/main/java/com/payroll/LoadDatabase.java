package com.payroll;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j //cria automaticamente um LoggerFactory, permitindo registrar os funcionários recém criados.
class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase (EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins","burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief")));
        };
    }
}
