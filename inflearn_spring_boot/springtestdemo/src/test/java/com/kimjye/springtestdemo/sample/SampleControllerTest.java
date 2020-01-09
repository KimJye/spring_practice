package com.kimjye.springtestdemo.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {

     @Autowired
     TestRestTemplate testRestTemplate;

     @Test
     public void hello() throws Exception {
         String result = testRestTemplate.getForObject("/hello", String.class);
         assertThat(result).isEqualTo("hello kimjye");
     }

     //    @Autowired
    //    MockMvc mockMvc;
    //
    //    @Test
    //    public void hello() throws Exception {
    //        mockMvc.perform(get("/hello"))
    //                .andExpect(status().isOk())
    //                .andExpect(content().string("hello kimjye"))
    //                .andDo(print());
    //    }
}