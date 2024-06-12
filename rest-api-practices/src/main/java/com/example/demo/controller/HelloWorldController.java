package com.example.demo.controller;

import com.example.demo.model.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("Hello World");
    }

}
