package com.example.springexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHtml {

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }

}
