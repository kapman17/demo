package com.example.demo.service;

import com.example.demo.domain.Browser;
import com.example.demo.repository.BrowserRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private final BrowserRepository browserRepository;

    public DemoServiceImpl(BrowserRepository browserRepository) {
        this.browserRepository = browserRepository;
    }

    @Override
    public String getBrowserNameById(Integer id) {
        return browserRepository.findTopByIdOrName(id, null).map(Browser::getName).orElse(null);
    }
}
