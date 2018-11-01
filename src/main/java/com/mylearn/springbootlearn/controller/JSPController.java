package com.mylearn.springbootlearn.controller;

import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @date 2018/10/27 16:51
 * @Description:
 */
@Controller
public class JSPController {
  @RequestMapping("/boot/index")
  public String getIndex(Model model){
//    model.put("time", new Date());
//    model.put("message", "xxxx");
    model.addAttribute("time", new Date());
    model.addAttribute("message", "hello spring boot");
    return "/page1";
  }

}
