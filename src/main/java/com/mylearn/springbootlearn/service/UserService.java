package com.mylearn.springbootlearn.service;

import com.mylearn.springbootlearn.bean.User2;
import com.mylearn.springbootlearn.dao.User2Dao;
import com.mylearn.springbootlearn.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @date 2018/11/3 10:36
 * @Description:
 */
@Component
public class UserService {

  private Logger log = LoggerFactory.getLogger(UserService.class);
  public  void  log(){
    log.debug("user service debug");
    log.info("user service info");
    log.warn("user service warn");
    log.error("user service error");
  }

  @Autowired
  User2Dao user2Dao;
  public User2 getInfo(int ida){
    User2 user2= user2Dao.findByIdNum(ida);

    return user2;
  }
}
