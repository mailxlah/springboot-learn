package com.mylearn.springbootlearn;

import org.eclipse.jdt.internal.compiler.batch.FileSystem.Classpath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:my.properties")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringbootLearnApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(SpringbootLearnApplication.class, args);
		System.out.println(context.toString());
	}
}
