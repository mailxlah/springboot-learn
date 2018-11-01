package com.mylearn.springbootlearn.configration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @date 2018/11/1 23:57
 * @Description:
 */
@TestConfiguration
public class TestBeanConfigration {

  @Bean
  public Runnable creatRunnable(){
    return ()->{};
  }
}
