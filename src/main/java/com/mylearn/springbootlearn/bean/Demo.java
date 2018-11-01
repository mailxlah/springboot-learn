package com.mylearn.springbootlearn.bean;

import java.io.Serializable;

/**
 *
 * @date 2018/10/29 10:50
 * @Description:
 */
public class Demo implements Serializable {
  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
