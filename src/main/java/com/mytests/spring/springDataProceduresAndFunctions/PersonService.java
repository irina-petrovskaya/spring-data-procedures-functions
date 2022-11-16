package com.mytests.spring.springDataProceduresAndFunctions;

import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 11/14/2022.</p>
 * <p>Project: spring-data-procedures-functions</p>
 * *
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void displayResults(){

        System.out.println("====custom function in select clause, named parameters:");
        for (String s : personRepository.useFunctionInSelectClauseNamedParam(" ")) {
            System.out.println(s);
        }
        System.out.println("====custom function in where clause:");
        for (PersonEntity person : personRepository.useFunctionInWhereClause("Russia", "SPb", ", ")) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}
