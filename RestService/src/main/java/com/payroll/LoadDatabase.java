package com.payroll;

import com.payroll.models.Employee;
import com.payroll.dataConfiguration.EmployeeRepository;
import com.payroll.dataConfiguration.OrderRepository;
import com.payroll.models.Order;
import com.payroll.models.Status;
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

    @Bean
    CommandLineRunner initDataBaseOrder (OrderRepository orderRepository){
        return args -> {
            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("Iphone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
