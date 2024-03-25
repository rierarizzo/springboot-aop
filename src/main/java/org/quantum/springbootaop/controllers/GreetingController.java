package org.quantum.springbootaop.controllers;

import org.quantum.springbootaop.services.IGreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class GreetingController {

    private final IGreetingService greetingService;

    public GreetingController(final IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public ResponseEntity<Map<String, Object>> greeting() {
        String greeting = greetingService.sayHello("Keneth", "Hola");

        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting));
    }

}
