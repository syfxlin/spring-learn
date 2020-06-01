package me.ixk.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before");
    }

    @Test
    public void testAdd() {
        System.out.println("Test");
        assertEquals(1 + 1, 2);
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After Class");
    }

    @AfterEach
    public void after() {
        System.out.println("After");
    }
}
