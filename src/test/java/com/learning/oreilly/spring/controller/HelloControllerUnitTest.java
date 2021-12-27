package com.learning.oreilly.spring.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import static org.junit.jupiter.api.Assertions.*;
public class HelloControllerUnitTest {

    @Test
    public void sayHello(){
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = helloController.sayHello("Mr. Anderson", model);
        assertEquals("Mr. Anderson", model.asMap().get("user"));
        assertEquals("hello", result);
    }
}
