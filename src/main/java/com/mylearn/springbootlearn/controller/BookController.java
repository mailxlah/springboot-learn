package com.mylearn.springbootlearn.controller;

import com.mylearn.springbootlearn.bean.User;
import com.mylearn.springbootlearn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
  UserDao userDao;

  @GetMapping("/home/book")
  public String home() {
    return "bookhome";
  }

  @GetMapping("/home/show")
  public String show(@RequestParam("id") String id) {
    userDao.adduser(" zhangsan");


    return "book" + id;
  }
}
