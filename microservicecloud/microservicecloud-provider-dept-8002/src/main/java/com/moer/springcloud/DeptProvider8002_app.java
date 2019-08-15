package com.moer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: moer
 * @Date: 2019/8/10 12:08
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient
public class DeptProvider8002_app {

  public static void main(String[] args) {
    SpringApplication.run(DeptProvider8002_app.class, args);
  }
}
