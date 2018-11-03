package com.mylearn.springbootlearn.config;
 
import com.mylearn.springbootlearn.bean.Broker;
import com.mylearn.springbootlearn.bean.Customer;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
 
 
@Component
@Import({Customer.class,Broker.class})
/**
 *使用Import 将指定的类的实例注入至Spring 容器中
 */
public class ImportDirect {
 
}
