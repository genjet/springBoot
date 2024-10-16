package com.uuu.demo1;

import org.junit.jupiter.api.*;

public class Demo1Tests {
    @BeforeAll
    public static void prepareOnce() {
        System.out.println("one term startup");
    }

    @AfterAll
    public static void finalCleanup() {
        System.out.println("final clean up");
    }

    @BeforeEach
    public void prepare() {
        System.out.println("prepare for the test");
    }

    @AfterEach
    public void cleanup() {
        System.out.println("clean up test space, and store result");
    }

    @Test
    public void doTest1() {
        System.out.println("will do test1 here");
    }

    @Test
    public void doTest2() {
        System.out.println("will do test2 here");

    }
}