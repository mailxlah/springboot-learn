package com.mylearn.springbootlearn.dao;

import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @date 2018/11/1 23:32
 * @Description:
 */
@Repository
public class UserDao {
  public Integer adduser(String username){
    System.out.println("user dao adduser [username="+username+"]");
    if (username==null){
      return 0;
    }
    return 1;
  }

}

