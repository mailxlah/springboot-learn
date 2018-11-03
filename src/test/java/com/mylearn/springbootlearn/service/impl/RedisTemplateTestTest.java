package com.mylearn.springbootlearn.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTestTest {

  @Autowired
  RedisTemplateTest redisTemplateTest;

  @Test
  public void findAll() throws Exception {
    redisTemplateTest.findAll();
  }

}