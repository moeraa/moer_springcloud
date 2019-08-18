package com.moer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: moer
 * @Date: 2019/8/18 11:26
 * @Description:
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Hystrix_DashBorad_APP {

  public static void main(String[] args) {
    SpringApplication.run(DeptConsumer_Hystrix_DashBorad_APP.class,args);
  }


}
