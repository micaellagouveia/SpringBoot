package com.payroll.dataConfiguration;

import com.payroll.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}

// Essa interface estende o JpaRepository do Spring Data JPA, especificando o tipo de domínio como Funcionário e o tipo
// de Id como Long. Está vazia mas possibilita a criação de instâncias, atualização das instâncias, deletar, encontrar...