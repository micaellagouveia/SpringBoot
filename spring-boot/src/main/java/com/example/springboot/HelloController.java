package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController //manipula solicitações web. Combina a @Controller e o @ResponseBody
public class HelloController {

    @RequestMapping("/") //mapeia para o método index()
    public String index(){
        return "Greeting from Spring Boot!";
    }
}
