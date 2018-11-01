package com.mylearn.springbootlearn;

import com.mylearn.springbootlearn.service.impl.RedisTemplateTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearnApplicationTests {

	@Autowired
	RedisTemplateTest redisTemplateTest;
	@Test
	public void contextLoads() {
		redisTemplateTest.findAll();
	}

}
