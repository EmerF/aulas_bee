package com.ambev.techempowers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        if ("error".equals(name)) {
            throw new CustomNotFoundException("User not found!");
        }
        return "Hello, " + name + "!";
    }
}
