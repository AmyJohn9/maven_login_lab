package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/")
    public String details() {
        return "<h2>LOGIN VALIDATION SYSTEM</h2>"
                + "<form action='/check' method='get'>"
                + "User Name: <input type='text' name='u'/><br><br>"
                + "Quantity: <input type='text' name='p'/><br><br>"
                + "<button type='submit'>Confirm order</button>"
                + "</form>";
    }
    @GetMapping("/check")
    public String getMethodName(@RequestParam(required = false) String u,
                               @RequestParam(required = false) String p) {

        if (u == null || u.isEmpty() || p == null || p.isEmpty()) {
            return "<h1>Enter the Details First</h1>";
        } else {
            return "<h1>Order placed successfully!</h1>"
                    + "<h2>User Name: " + u + "</h2>"
                    + "<h2>Status: " + p + "</h2>";
        }
    }
}