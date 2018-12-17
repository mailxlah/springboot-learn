package com.mylearn.springbootlearn.dao;

import static org.junit.Assert.*;

import com.mylearn.springbootlearn.bean.UserDO;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoJpaTest {
  @Autowired
  private UserDaoJpa userDao;

  @Before
  public void before() {
    UserDO userDO = new UserDO();
    userDO.setId(1L);
    userDO.setName("风清扬");
    userDO.setAccount("fengqy");
    userDO.setPwd("123456");
    userDao.save(userDO);
    userDO = new UserDO();
    userDO.setId(3L);
    userDO.setName("东方不败");
    userDO.setAccount("bubai");
    userDO.setPwd("123456");
    userDao.save(userDO);
    userDO.setId(5L);
    userDO.setName("向问天");
    userDO.setAccount("wentian");
    userDO.setPwd("123456");
    userDao.save(userDO);
  }
  @Test
  public void testAdd() {
    UserDO userDO = new UserDO();
    userDO.setId(2L);
    userDO.setName("任我行");
    userDO.setAccount("renwox");
    userDO.setPwd("123456");
    userDao.save(userDO);
    userDO = new UserDO();
    userDO.setId(4L);
    userDO.setName("令狐冲");
    userDO.setAccount("linghuc");
    userDO.setPwd("123456");
    userDao.save(userDO);

//    userDao.delete(1l);
  }

//  @After
//  public void after() {
//    userDao.deleteById(1L);
//    userDao.deleteById(3L);
//    userDao.deleteById(5L);
//  }

  @Test
  public void testLocate() {
    Optional<UserDO> userDOOptional = userDao.findById(1L);
    if (userDOOptional.isPresent()) {
      UserDO userDO = userDOOptional.get();
      System.out.println("name = " + userDO.getName());
      System.out.println("account = " + userDO.getAccount());
    }
  }


}