package com.example.SoftwarePatterns;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Controller
    public class WelcomeController {

        // inject via application.properties
        @Value("${welcome.message:test}")
        private String message = "Hello World";

        @RequestMapping("/")
        public String welcome(Map<String, Object> model) {
            model.put("message", this.message);
            return "welcome";
        }
    }
}