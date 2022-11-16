package com.mytests.spring.springDataProceduresAndFunctions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataProceduresFunctionsApplication implements CommandLineRunner {

    private final PersonService personService;

    public SpringDataProceduresFunctionsApplication(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataProceduresFunctionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personService.displayResults();
    }
}
