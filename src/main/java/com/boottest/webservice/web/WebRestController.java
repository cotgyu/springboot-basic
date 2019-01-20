package com.boottest.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/Hello")
    public String Hello(){
        return "helloWorld";
    }
}
