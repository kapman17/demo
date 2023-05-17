package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.domain.Browser;
import com.example.demo.repository.BrowserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DemoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class DemoServiceImplTest {
    @MockBean
    private BrowserRepository browserRepository;

    @Autowired
    private DemoServiceImpl demoServiceImpl;

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

    /**
     * Method under test: {@link DemoServiceImpl#getBrowserNameById(Integer)}
     */
    @Test
    void testGetBrowserNameById2() {
        Browser browser = new Browser();
        browser.setId(1);
        browser.setName("Name");
        browser.setOptionId(1);
        Optional<Browser> ofResult = Optional.of(browser);
        when(browserRepository.findTopByIdOrName(Mockito.<Integer>any(), Mockito.<String>any())).thenReturn(ofResult);
        assertEquals("Name", demoServiceImpl.getBrowserNameById(1));
        verify(browserRepository).findTopByIdOrName(Mockito.<Integer>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link DemoServiceImpl#getBrowserNameById(Integer)}
     */
    @Test
    void testGetBrowserNameById3() {
        Browser browser = new Browser();
        browser.setId(1);
        browser.setName("Name");
        browser.setOptionId(1);
        Optional<Browser> ofResult = Optional.of(browser);
        when(browserRepository.findTopByIdOrName(Mockito.<Integer>any(), Mockito.<String>any())).thenReturn(ofResult);
        assertThrows(UnsupportedOperationException.class, () -> demoServiceImpl.getBrowserNameById(0));
    }

    /**
     * Method under test: {@link DemoServiceImpl#getBrowserNameById(Integer)}
     */
    @Test
    void testGetBrowserNameById4() {
        when(browserRepository.findTopByIdOrName(Mockito.<Integer>any(), Mockito.<String>any()))
                .thenThrow(new UnsupportedOperationException("An error occurred"));
        assertThrows(UnsupportedOperationException.class, () -> demoServiceImpl.getBrowserNameById(1));
        verify(browserRepository).findTopByIdOrName(Mockito.<Integer>any(), Mockito.<String>any());
    }
}

