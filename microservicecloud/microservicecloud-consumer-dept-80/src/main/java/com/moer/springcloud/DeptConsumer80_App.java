package com.moer.springcloud;

import com.moer.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Auther: moer
 * @Date: 2019/8/10 16:59
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT" ,configuration = MySelfRule.class)
public class DeptConsumer80_App {

  public static void main(String[] args) {
    SpringApplication.run(DeptConsumer80_App.class,args);
  }


}
