package org.quantum.springbootaop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {

    @Override
    public String sayHello(String person, String phrase) {
        String greeting = phrase + " " + person;
        System.out.println(greeting);

        return greeting;
    }

    @Override
    public String sayHelloError(String person, String phrase) {
        throw new RuntimeException("Cualquier error");
    }

}
