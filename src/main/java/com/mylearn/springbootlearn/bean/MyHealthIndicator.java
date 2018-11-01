package com.mylearn.springbootlearn.bean;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 *
 * @date 2018/11/1 22:51
 * @Description:
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

  @Override
  public Health health() {
    return Health.down().withDetail("error","spring boot down").build();
  }
}
