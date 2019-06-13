package com.mylearn.springbootlearn.controller;

import com.mylearn.springbootlearn.dao.UserDaoa;
import com.mylearn.springbootlearn.service.impl.RedisTemplateTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2018/11/2 0:35
 * @Description:
 */
@RestController
public class BookController {

  @Autowired
//  @Qualifier("userDao")
      UserDaoa userDao;

  @Autowired
  RedisTemplateTest rd;

  @GetMapping("/home/book")
  public String home() {
    return "bookhome";
  }

  @GetMapping("/home/show")
  public String show(@RequestParam("id") String id) {
    userDao.adduser(" zhangsan");

    return "book" + id;
  }

  @GetMapping("/home/rd")
  public String show() {
    rd.findAll();

    return "book";
  }

}
