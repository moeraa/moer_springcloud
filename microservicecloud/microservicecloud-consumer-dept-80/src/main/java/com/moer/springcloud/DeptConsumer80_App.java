package com.moer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: moer
 * @Date: 2019/8/10 16:59
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer80_App {

  public static void main(String[] args) {
    SpringApplication.run(DeptConsumer80_App.class,args);
  }


}