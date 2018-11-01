package com.mylearn.springbootlearn.controller;

import com.mylearn.springbootlearn.bean.User;
import com.mylearn.springbootlearn.service.TestInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @date 2018/10/26 0:12
 * @Description:
 */
@Controller
public class MyController {

  @RequestMapping("hello")
  public String mytest(){
    return "myhello";
  }

  @RequestMapping("hello2")
  @ResponseBody
  public String mytest2(){
    return "myhello2";
  }

  @Autowired
  private TestInterFace testInterFace;


  @Autowired
  CounterService  counterService;

  @RequestMapping("/num")
  @ResponseBody
  int home() {
    counterService.increment("root.num");
    System.out.println("xxxx22");
    int i = testInterFace.testInterFace();
    return i++;
  }
  @RequestMapping("/get")
  @ResponseBody
  User getUser() {



    return testInterFace.testUser();
  }

}
