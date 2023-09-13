package com.ambev.techempowers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// testar endpoint
// http://localhost:8080/process?dividend=10&divisor=1
@RestController
public class IntegerParameterController {


    @GetMapping("/process")
    public String processInteger(@RequestParam("dividend") int dividend, @RequestParam("divisor") int divisor) {
        int result =0;
        try {
            result = divide(dividend, divisor);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            //System.err.println("IllegalArgumentException: " + e.getMessage());
            throw new IllegalArgumentException("Invalid argument: " + e.getMessage(), e);
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException: " + e.getMessage());
            throw new ArithmeticException("Not possible calculate");
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
        return "Result " + result;
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        return dividend / divisor;
    }
}

