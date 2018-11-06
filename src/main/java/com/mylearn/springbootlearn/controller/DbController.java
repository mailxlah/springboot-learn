package com.mylearn.springbootlearn.controller;

import com.mylearn.springbootlearn.bean.User2;
import com.mylearn.springbootlearn.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @date 2018/11/3 15:49
 * @Description:
 */
@RestController
public class DbController {

  @Autowired
  UserService userService;




  @RequestMapping("/getUser/{ida}")
  public User2 getUserInfo(@PathVariable("ida") int ida){
    return userService.getInfo(ida);
  }

  @RequestMapping("/addUser/{name}")
  public Integer addUser(@PathVariable("name") String name){
//    return userService.addUser(name);
//    jdbcTemplate
    return userService.addUser2(name);
//    return userService.addUser3(name);
  }

  @RequestMapping("/findAll")
  public List<Map> findAll(){
    return userService.findAll();
  }


}
