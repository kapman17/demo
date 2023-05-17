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
        if (id < 1) {
            throw new UnsupportedOperationException("id must be greater than 0");
        }
        return browserRepository.findTopByIdOrName(id, null).map(Browser::getName).orElse(null);
    }
}
