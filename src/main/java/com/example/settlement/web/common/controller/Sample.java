package com.example.settlement.web.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {

    @RequestMapping("/sample")
    public String sample() {
        return "Sample!!!";
    }
}
