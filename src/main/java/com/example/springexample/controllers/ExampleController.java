package com.example.springexample.controllers;

import org.springframework.web.bind.annotation.*;


/**
 * ExampleController
 */
@RestController
@RequestMapping(path = "/hello")
public class ExampleController {


    @GetMapping()
    public String helloSpringParams(@RequestParam String name) {
        return "hello " + name;
    }

    @GetMapping(path = "/{name}")
    public String helloSpringPath(@PathVariable String name) {
        return "hello " + name;
    }

    @PostMapping()
    public String helloSpringBody(@RequestBody Body body) {
        return "hello " + body.name;
    }
}

class Body {
    public String name;
}
