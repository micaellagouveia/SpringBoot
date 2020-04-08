package com.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody // Renderiza diretamente no corpo da resposta
    @ExceptionHandler ( EmployeeNotFoundException.class ) //responde apenas se um EmployeerNotFoundException for lançado
    @ResponseStatus (HttpStatus.NOT_FOUND) //HTTP 404
    String employeeNotFoundHandler (EmployeeNotFoundException ex){
        return ex.getMessage();//fornece a mensagem de exceção
    }
}
