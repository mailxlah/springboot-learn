package com.mylearn.springbootlearn.controller;

import static org.junit.Assert.*;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class DbControllerTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void findAll() throws Exception {

    ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/findAll"));
    MvcResult mvcResult = perform.andReturn();
    MockHttpServletResponse response = mvcResult.getResponse();
    System.out.println(response.getContentAsString());
  }

  @Test
  public void addUser() throws Exception {

    ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/addUser/jack"));
    MvcResult mvcResult = perform.andReturn();
    MockHttpServletResponse response = mvcResult.getResponse();
    System.out.println(response.getContentAsString());
  }

  @Autowired
  private MockMvc mvc;

  @Test
  public void getUserInfo() throws Exception {
//    mvc.perform(MockMvcRequestBuilders.get("/getUser/1")).andExpect(
//        MockMvcResultMatchers.status().isOk());
//    mvc.perform(MockMvcRequestBuilders.get("/getUser/1")).andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("bookhome"));

    ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/getUser/1"));
    MvcResult mvcResult = perform.andReturn();
    MockHttpServletResponse response = mvcResult.getResponse();
    System.out.println(response.getContentAsString());

  }

}