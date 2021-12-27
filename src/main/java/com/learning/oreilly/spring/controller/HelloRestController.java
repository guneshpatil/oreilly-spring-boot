package com.learning.oreilly.spring.controller;

import com.learning.oreilly.spring.entities.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/rest")
    public Greeting greet(@RequestParam(required = false, defaultValue = "world")
                          String name){
        return new Greeting("Hello, " + name + "!");
    }
}
