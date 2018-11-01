package com.mylearn.springbootlearn.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest2 {



  @Test
  public void show() throws Exception {
//    String forObject = testRestTemplate.getForObject("/home/show?id=10", String.class);
//    Assert.assertEquals(forObject,"book10");
  }

  @Autowired
  private MockMvc mvc;

  @Test
  public void home() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/home/book")).andExpect(MockMvcResultMatchers.status().isOk());

  }

}