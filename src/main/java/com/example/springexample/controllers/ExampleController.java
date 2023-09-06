package com.example.springexample.controllers;

import org.springframework.web.bind.annotation.*;


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
        return "hello " + body.getName();
    }
}

class Body {
    public String getName() {
        return name;
    }

    private String name;
}
