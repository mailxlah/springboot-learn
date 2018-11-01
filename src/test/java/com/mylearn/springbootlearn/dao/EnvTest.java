package com.mylearn.springbootlearn.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @date 2018/11/2 0:05
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"app.version=1.0"})
public class EnvTest {
  @Autowired
//  Environment env;
      ConfigurableEnvironment env;
  @Before
  public void init(){
    EnvironmentTestUtils.addEnvironment(env,"app.admin.name=name1");
//    EnvironmentTestUtils.addEnvironment(env,"");
  }


  @Test
  public void testValue(){
//    Assert.assertEquals("password",env.getProperty("security.user.password"));
//    Assert.assertEquals("1.0",env.getProperty("app.version"));
    Assert.assertEquals("name1",env.getProperty("app.admin.name"));


  }

}
