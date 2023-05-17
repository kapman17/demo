package com.example.demo.service;

// spring boot test

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoServiceIT {

    // integration test for DemoService
     @Autowired
     private DemoService demoService;
    //
    // @Test
    // public void testDemoService() {
    //     assertEquals(demoService.demo(), "demo");
    // }

    // integration test for DemoService with mocks
    // @MockBean
    // private DemoRepository demoRepository;
    //
    // @Autowired
    // private DemoService demoService;
    //
    @Test
    public void testGetBrowserNameById() {
        String name = demoService.getBrowserNameById(3);
        Assertions.assertEquals("Chrome", name);
    }



}
