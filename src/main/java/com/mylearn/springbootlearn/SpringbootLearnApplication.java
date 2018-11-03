package com.mylearn.springbootlearn;

import com.mylearn.springbootlearn.bean.Broker;
import com.mylearn.springbootlearn.bean.Forwards;
import com.mylearn.springbootlearn.bean.User2;
import com.mylearn.springbootlearn.config.ImportDirect;
import com.mylearn.springbootlearn.dao.User2Dao;
import com.mylearn.springbootlearn.dao.UserDao;
import com.mylearn.springbootlearn.register.MyImportBeanDefinitionRegistrar;
import com.mylearn.springbootlearn.service.UserService;
import java.util.List;
import org.eclipse.jdt.internal.compiler.batch.FileSystem.Classpath;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
//@Import(MyImportBeanDefinitionRegistrar.class)
//@MapperScan("com.mylearn.springbootlearn.dao")
@SpringBootApplication

@PropertySource("classpath:my.properties")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringbootLearnApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(SpringbootLearnApplication.class, args);
//		UserDao bean = context.getBean(UserDao.class);
//		System.out.println(bean.getClass().getName());
//		System.out.println(context.getBean(Broker.class).getClass().getName());
//		System.out.println(context.getBean(ImportDirect.class).getClass().getName());

		//实现ImportBeanDefinitionRegistrar 实现Bean的注入
//		System.out.println(context.getBean(MyImportBeanDefinitionRegistrar.class));
//		System.out.println(context.getBean(Forwards.class));

//		System.out.println(context.toString());

		User2Dao bean = context.getBean(User2Dao.class);
		System.out.println(bean);
		User2 user2 = new User2();
		user2.setIda(1);
		List<User2> byId = bean.findById(user2);
		User2 user21 = byId.get(0);
		System.out.println(user21);


		context.getBean(UserService.class).log();

	}




}
