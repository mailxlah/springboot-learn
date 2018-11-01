package com.mylearn.springbootlearn.dao;

import com.mylearn.springbootlearn.bean.User;
import com.mylearn.springbootlearn.configration.TestBeanConfigration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @date 2018/11/1 23:45
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= TestBeanConfigration.class)
public class ApplicationContexTest {

  @Autowired
  ApplicationContext context;
  @Test
  public void testNull(){
    User bean = context.getBean(User.class);
    Assert.assertNotNull(bean);

    Runnable runnable = context.getBean(Runnable.class);
    Assert.assertNotNull(runnable);
  }
}
