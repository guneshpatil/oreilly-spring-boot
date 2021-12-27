package com.learning.oreilly.spring.controller;

import com.learning.oreilly.spring.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {
    @Autowired
    TestRestTemplate template;

    @Test
    public void greetWithoutName() {
        ResponseEntity<Greeting> responseEntity = template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        Greeting response = responseEntity.getBody();
        assert response != null;
        assertEquals("Hello, World!", response.getMessage());
    }

    @Test
    public void greetWithName() {
        String name = "Mr. Anderson";
        Greeting greeting = template.getForObject("/rest?name=" + name, Greeting.class);
        assertEquals("Hello, " + name + "!", greeting.getMessage());
    }
}
