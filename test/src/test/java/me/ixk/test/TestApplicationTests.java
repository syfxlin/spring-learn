package me.ixk.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

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

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testMock() {
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("key", "value");
            mockMvc
                .perform(MockMvcRequestBuilders.get("/get").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("value"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
