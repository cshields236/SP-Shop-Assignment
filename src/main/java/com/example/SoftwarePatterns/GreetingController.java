package com.example.SoftwarePatterns;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Conor!") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
