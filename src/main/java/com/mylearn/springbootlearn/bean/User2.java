package com.mylearn.springbootlearn.bean;

/**
 *
 * @date 2018/11/3 0:19
 * @Description:
 */
public class User2 {

  private Integer ida;
  private String name;
  private String nickName;

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Integer getIda() {
    return ida;
  }

  public void setIda(Integer ida) {
    this.ida = ida;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User2{" +
        "ida=" + ida +
        ", name='" + name + '\'' +
        ", nickName='" + nickName + '\'' +
        '}';
  }
}
