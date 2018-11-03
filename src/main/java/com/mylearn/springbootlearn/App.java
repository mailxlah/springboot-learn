package com.mylearn.springbootlearn;

import com.mylearn.springbootlearn.bean.Forwards;
import com.mylearn.springbootlearn.register.MyImportBeanDefinitionRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(MyImportBeanDefinitionRegistrar.class)
@Configuration
//@SpringBootApplication
public class App {
 
 
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
 
        //实现ImportBeanDefinitionRegistrar 实现Bean的注入
        System.out.println(context.getBean(MyImportBeanDefinitionRegistrar.class));
        System.out.println(context.getBean(Forwards.class));
//        System.out.println(context.getBean(Security.class));
 
    }
 
 
}
