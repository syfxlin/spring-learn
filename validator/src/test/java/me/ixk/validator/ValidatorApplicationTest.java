package me.ixk.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class ValidatorApplicationTest {
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setMockMvcUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void userSuccess() throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("username", "syfxlin");
        multiValueMap.add("password", "123456");
        multiValueMap.add("email", "syfxlin@gmail.com");
        String json = objectMapper.writeValueAsString(
                multiValueMap.toSingleValueMap()
        );
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user")
                .params(multiValueMap);
        ResultMatcher resultMatcher = MockMvcResultMatchers
                .content()
                .string(json);
        this.mockMvc.perform(requestBuilder).andExpect(resultMatcher);
    }

    @Test
    public void userError() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/user"
        );
        ResultMatcher resultMatcher = MockMvcResultMatchers
                .status()
                .isBadRequest();
        this.mockMvc.perform(requestBuilder).andExpect(resultMatcher);
    }

    @Test
    public void userResult() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/user-result"
        );
        ResultMatcher resultMatcher = MockMvcResultMatchers
                .content()
                .string(
                        "{\"password\":\"must not be null\",\"email\":\"must not be null\",\"username\":\"must not be null\"}"
                );
        this.mockMvc.perform(requestBuilder).andExpect(resultMatcher);
    }
}
