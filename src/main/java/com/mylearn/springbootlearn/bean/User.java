package com.mylearn.springbootlearn.bean;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @date 2018/10/26 9:10
 * @Description:
 */
@Component
public class User implements Serializable {
private String username;
private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
