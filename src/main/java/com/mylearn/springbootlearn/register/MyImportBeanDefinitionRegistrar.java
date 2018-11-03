package com.mylearn.springbootlearn.register;
 
import com.mylearn.springbootlearn.bean.Forwards;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
 
/**
 * registerBeanDefinitions 方法中的参数 BeanDefinitionRegistry 可以往Spring IOC Container 中动态地装配Bean
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
 
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
 
        //手动注入 Forwards 类的实例
        BeanDefinitionBuilder beanDef_forwards = BeanDefinitionBuilder.rootBeanDefinition(Forwards.class);
        registry.registerBeanDefinition("forwards", beanDef_forwards.getBeanDefinition());
 
        //手动注入 Security类的实例
//        BeanDefinitionBuilder beanDef_security = BeanDefinitionBuilder.rootBeanDefinition(Security.class);
//        registry.registerBeanDefinition("security", beanDef_security.getBeanDefinition());
    }
 
}
