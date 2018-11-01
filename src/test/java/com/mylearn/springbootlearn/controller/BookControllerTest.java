package com.mylearn.springbootlearn.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

  @Test
  public void home1() throws Exception {
  }

  @Test
  public void show() throws Exception {
    String forObject = testRestTemplate.getForObject("/home/show?id=10", String.class);
    Assert.assertEquals(forObject,"book10");
  }

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  public void home() throws Exception {
    String forObject = testRestTemplate.getForObject("/home/book", String.class);
    Assert.assertEquals(forObject,"bookhome");
  }

}