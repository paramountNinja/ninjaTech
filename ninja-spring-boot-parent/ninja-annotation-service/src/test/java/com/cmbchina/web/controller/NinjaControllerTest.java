package com.cmbchina.web.controller;

import com.cmbchina.web.request.DemoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/5
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class NinjaControllerTest {
    @InjectMocks
    NinjaController ninjaController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapperReal;

    @Before
    public void setUp() {
        objectMapperReal = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
        //构建mvc环境
        mockMvc = MockMvcBuilders.standaloneSetup(ninjaController)
                //.setControllerAdvice()
                .build();
    }


    @Test
    public void testValidTest() throws Exception {
        DemoRequest demoRequest = new DemoRequest();
        //demoRequest.setChnlId("01");
        demoRequest.setChnlUserId("123");
        demoRequest.setCredits(1);
        String json = objectMapperReal.writeValueAsString(demoRequest);

        ResultActions resultActions = mockMvc.perform(post("/test/valid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isOk());
        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }
}

