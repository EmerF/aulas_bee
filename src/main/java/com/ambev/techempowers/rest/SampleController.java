package com.ambev.techempowers.rest;

import com.ambev.techempowers.exceptions.CustomNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//curl -i http://localhost:8080/api/hello/error
//curl -i -X GET http://localhost:8080/api/generic

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        if ("error".equals(name)) {
            throw new CustomNotFoundException("Error mesmo!!");
        }
        return "Hello, " + name + "!";
    }

    @GetMapping("/generic")
    public String generic() throws Exception {
            throw new Exception("Generic Error");
    }


}
