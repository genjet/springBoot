package com.uuu.demo1;

import com.uuu.demo1.controllers.GreetController;
import com.uuu.demo1.controllers.RootController;
import com.uuu.demo1.services.GreetingService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@WebMvcTest(controllers = {RootController.class, GreetController.class})
@WebMvcTest
public class Demo6Tests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GreetingService service;

    @Test
    public void mockMvcShouldNotNull() {
        Assertions.assertNotNull(mockMvc);
    }

    private static final String TEST_STRING1 = "hello mocktio test";

    @Test
    public void performGreet() throws Exception {
        Mockito.when(service.greet()).thenReturn(TEST_STRING1);
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                //.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(TEST_STRING1.substring(0,5))));
    }
}