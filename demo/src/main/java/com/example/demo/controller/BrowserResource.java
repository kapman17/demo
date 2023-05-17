package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowserResource {

    private final DemoService demoService;

    public BrowserResource(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/browser")
    public String getBrowserName() {
        return demoService.getBrowserNameById(3) == null ? "Chrome" : demoService.getBrowserNameById(3);
    }
}
