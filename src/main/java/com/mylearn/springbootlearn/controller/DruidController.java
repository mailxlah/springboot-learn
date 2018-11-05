package com.mylearn.springbootlearn.controller;

import com.mylearn.springbootlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyou
 * @date 2018/11/5 10:41
 * @Description:
 */
@RestController
public class DruidController {

  @Autowired
  UserService userService;

  @RequestMapping("/addUser2/{name}")
  public Integer addUser(@PathVariable("name") String name){
    return userService.addUser(name);
  }


}
