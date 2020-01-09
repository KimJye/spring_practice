package com.kimjye.demospringbootmvc.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_JSON() throws Exception {
        String userJson="{\"username\":\"kimjye\", \"password\":\"123\"}";

        // 요청을 만들고 응답을 확인하는 과정
        // json으로 요청하고 xml으로 응답
        mockMvc.perform(post("/users/create").
                contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("kimjye"))
                .andExpect(xpath("User/password").string("123"));


        // 요청을 만들고 응답을 확인하는 과정
        // json으로 요청하고 json으로 응답
//        mockMvc.perform(post("/users/create").
//                contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(userJson))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.username", is(equalTo("kimjye"))))
//            .andExpect(jsonPath("$.password", is(equalTo("123"))));
    }
}
