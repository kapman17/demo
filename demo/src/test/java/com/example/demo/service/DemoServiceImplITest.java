package com.example.demo.service;

// spring boot test

import com.example.demo.domain.Browser;
import com.example.demo.repository.BrowserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoServiceImplITest {

    @Autowired
    private DemoService demoService;

    @Autowired
    private BrowserRepository browserRepository;

    @BeforeEach
    public void setUp() {
        Browser browser = new Browser();
        browser.setId(3);
        browser.setName("Chrome");

        Browser browser1 = new Browser();
        browser1.setId(4);
        browser1.setName("Firefox");

        browserRepository.saveAll(List.of(browser, browser1));
    }

    @Test
    public void testGetBrowserByName() {
        String name = demoService.getBrowserNameById(4);
        Assertions.assertEquals("Firefox", name);
    }
}
