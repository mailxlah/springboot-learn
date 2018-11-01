package com.mylearn.springbootlearn.mapper;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserMapperTest {

  @MockBean
  UserMapper userMapper;

  @Test(expected = NullPointerException.class)
  public void creatUser() throws Exception {
    BDDMockito.given(userMapper.creatUser("admin")).willReturn(Integer.valueOf(1));
    BDDMockito.given(userMapper.creatUser("")).willReturn(Integer.valueOf(0));
    BDDMockito.given(userMapper.creatUser(null)).willThrow(NullPointerException.class);

    Assert.assertEquals(Integer.valueOf(1),userMapper.creatUser("admin"));
  }

}