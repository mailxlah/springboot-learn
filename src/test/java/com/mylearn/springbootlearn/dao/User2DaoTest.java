package com.mylearn.springbootlearn.dao;

import static org.junit.Assert.*;

import com.mylearn.springbootlearn.bean.User2;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class User2DaoTest {

  @Test
  @Rollback(false)
  public void add() throws Exception {
    User2 user2 = new User2();
    user2.setIda(10);
    user2.setName("wangwu");
    int add = user2Dao.add(user2);
    System.out.println(user2.getIda());
  }

  @Autowired
  User2Dao user2Dao;
  @Test
  public void findById() throws Exception {
    User2 user2 = new User2();
    user2.setIda(1);
    List<User2> byId = this.user2Dao.findById(user2);
    User2 user21 = byId.get(0);
    System.out.println(user21);
  }

  @Test
  public void findAll() throws Exception {
    User2 user2 = new User2();
    user2.setIda(1);
    List<Map> byId = this.user2Dao.findAll();
//    User2 user21 = byId.get(0);
    System.out.println(byId);
  }

}