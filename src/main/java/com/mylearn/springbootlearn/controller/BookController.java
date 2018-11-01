package com.mylearn.springbootlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @date 2018/11/2 0:35
 * @Description:
 */
@RestController
public class BookController {



  @GetMapping("/home/book")
  public String home(){
    return "bookhome";
  }

  @GetMapping("/home/show")
  public String show(@RequestParam("id")String id){
    return "book"+id;
  }
}
