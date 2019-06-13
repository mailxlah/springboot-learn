package com.mylearn.springbootlearn;

import com.mylearn.springbootlearn.bean.User2;
import com.mylearn.springbootlearn.dao.User2Dao;
import com.mylearn.springbootlearn.service.UserService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
//@Import(MyImportBeanDefinitionRegistrar.class)
//@MapperScan("com.mylearn.springbootlearn.dao")
@SpringBootApplication
//@Import({DynamicDataSourceRegister.class})
@PropertySource("classpath:my.properties")
@EnableAspectJAutoProxy
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

		// test(context);

	}

	private static void test(ConfigurableApplicationContext context) {
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
