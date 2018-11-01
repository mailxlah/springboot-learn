package com.mylearn.springbootlearn.config;

import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

/**
 *
 * @date 2018/11/1 23:15
 * @Description:
 */
@Configuration
public class ExportConfiguration {
//  @Bean
  @ExportMetricWriter
  public MetricWriter createMetricWriter(MBeanExporter exporter){
    return new JmxMetricWriter(exporter);
  }
}
