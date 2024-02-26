package com.sparta.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.deliveryproject.dto.StoreRequestDto;
import com.sparta.deliveryproject.service.StoreService;
import com.sparta.deliveryproject.test.CommonTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StoreController.class)
class StoreControllerTest implements CommonTest {
    private MockMvc mvc;

    @MockBean
    private StoreService storeService;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    void postStore() throws Exception {
        StoreRequestDto storeRequestDto = new StoreRequestDto();
        storeRequestDto.setName(TEST_STORE_NAME);
        storeRequestDto.setIntroduce(TEST_STORE_INTRODUCE);
        storeRequestDto.setAddress(TEST_STORE_ADDRESS);
        storeRequestDto.setCategory(TEST_STORE_CATEGORY);

        String storeJson = objectMapper.writeValueAsString(storeRequestDto);

        mvc.perform(post("/api/store")
                        .content(storeJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andDo(print());
    }

    @Test
    void test1() throws Exception {
        // when - then
        mvc.perform(get("/api/store/WESTERN"))
                .andExpect(status().is(200))
                .andDo(print());
    }
}