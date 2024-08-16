package com.rdred.apirestfull.controller;

import com.rdred.apirestfull.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private  static final String template = "Hola, %s";
    // Similar id uncos con las Atomic
    private static final AtomicLong count = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting hellorWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(count.incrementAndGet(), String.format(template,name));
    }

}
