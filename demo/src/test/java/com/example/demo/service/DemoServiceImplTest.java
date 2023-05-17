package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.domain.Browser;
import com.example.demo.repository.BrowserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DemoServiceImplTest {
    /**
     * Method under test: {@link DemoServiceImpl#DemoServiceImpl(BrowserRepository)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     DemoServiceImpl.browserRepository

        new DemoServiceImpl(mock(BrowserRepository.class));
    }

    /**
     * Method under test: {@link DemoServiceImpl#getBrowserNameById(Integer)}
     */
    @Test
    void testGetBrowserNameById() {
        Browser browser = new Browser();
        browser.setId(1);
        browser.setName("Name");
        browser.setOptionId(1);
        BrowserRepository browserRepository = mock(BrowserRepository.class);
        when(browserRepository.findTopByIdOrName(Mockito.<Integer>any(), Mockito.<String>any()))
                .thenReturn(Optional.of(browser));
        assertEquals("Name", (new DemoServiceImpl(browserRepository)).getBrowserNameById(1));
        verify(browserRepository).findTopByIdOrName(Mockito.<Integer>any(), Mockito.<String>any());
    }
}

