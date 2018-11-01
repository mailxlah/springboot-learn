package com.mylearn.springbootlearn.service.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylearn.springbootlearn.bean.User;
import com.mylearn.springbootlearn.service.TestInterFace;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class TestInterFaceImpl implements TestInterFace {

  @Autowired
  User user;

  @Autowired
  RedisTemplate<Object,Object> redisTemplate;


  @Override
  public int testInterFace() {

//    RedisSerializer rs = new StringRedisSerializer();
//    redisTemplate.setKeySerializer(rs);
//    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//    ObjectMapper om = new ObjectMapper();
//    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//    jackson2JsonRedisSerializer.setObjectMapper(om);
//    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);



    RedisSerializer rs = new StringRedisSerializer();
    redisTemplate.setKeySerializer(rs);
    ObjectMapper om = new ObjectMapper();
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//    jackson2JsonRedisSerializer.setObjectMapper(om);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.setSerializationInclusion(Include.NON_NULL);
//    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);






//    StringRedisTemplate template = new StringRedisTemplate(factory);
//    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//    ObjectMapper om = new ObjectMapper();
//    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//    jackson2JsonRedisSerializer.setObjectMapper(om);
//    template.setValueSerializer(jackson2JsonRedisSerializer);


    Object alluser =  redisTemplate.opsForValue().get("alluser");
    if (alluser == null) {
      user.setUsername("zhangsan1");
      redisTemplate.opsForValue().set("alluser",user,60, TimeUnit.SECONDS);
      System.out.println(user);
    }
    return 0;
  }

  @Override
  public User testUser() {
    return user;
  }
}
