package edu.userdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class TestController {
    @GetMapping
    public String test(){
        return "Java version is " + System.getProperty("java.version");
    }
    @GetMapping("/add/{a}")
    public Integer add(@PathVariable Integer a, @RequestParam Integer b){
        return a+b;
    }
    @GetMapping("/eve/{a}")
    public String eveOrOdd(@PathVariable Integer a){
        Function<Integer,String> f= x->x%2==0?"this no is even":"this no is odd";
        return f.apply(a);
    }
}
