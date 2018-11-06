package com.mylearn.springbootlearn.bean;

import java.io.File;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

/**
 * @author changyou
 * @date 2018/11/6 20:12
 * @Description:
 */
@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

  /**
   * Customize the specified {@link ConfigurableEmbeddedServletContainer}.
   *
   * @param container the container to customize
   */
  @Override
  public void customize(ConfigurableEmbeddedServletContainer container) {
    System.out.println("---------------"+container.getClass());
    TomcatEmbeddedServletContainerFactory factory= (TomcatEmbeddedServletContainerFactory) container;
//    factory.setPort(1003);
    factory.setBaseDirectory(new File("e:/log"));
    factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());

  }

  private AccessLogValve getLogAccessLogValve(){
    AccessLogValve log = new AccessLogValve();
    log.setDirectory("e:/log/tomcat");
    log.setEnabled(true);
    log.setPattern("common");
    log.setPrefix("springboot-access-log-my");
    log.setSuffix(".txt");
    return log;
  }

  class  MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer{

    /**
     * Customize the connector.
     *
     * @param connector the connector to customize
     */
    @Override
    public void customize(Connector connector) {
      System.out.println("aaaa---------:"+connector.getProtocolHandler().getClass());
    }
  }
}


