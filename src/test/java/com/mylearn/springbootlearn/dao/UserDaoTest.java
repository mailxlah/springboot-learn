package com.mylearn.springbootlearn.dao;

import static org.junit.Assert.*;

import javax.swing.Spring;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

  @Autowired
  UserDao userDao;
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void adduser() throws Exception {
    Assert.assertEquals(Integer.valueOf(1),userDao.adduser("zhangsan"));
    Assert.assertEquals(Integer.valueOf(1),userDao.adduser(null));
  }

}