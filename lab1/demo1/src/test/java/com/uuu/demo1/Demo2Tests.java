package com.uuu.demo1;

import com.uuu.demo1.controllers.RootController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo2Tests {
    @Autowired
    private RootController rootController;

    @Test
    public void checkRootControllerIsAvailable() {
        Assertions.assertNotNull(rootController);
    }
}