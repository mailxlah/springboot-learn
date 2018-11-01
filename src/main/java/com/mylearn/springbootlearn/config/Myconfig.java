package com.mylearn.springbootlearn.config;

import com.mylearn.springbootlearn.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @date 2018/10/26 9:30
 * @Description:
 */
@Configuration
@EnableConfigurationProperties
public class Myconfig {

  @Bean
  public  User user(){
    return new User();
  }


}
