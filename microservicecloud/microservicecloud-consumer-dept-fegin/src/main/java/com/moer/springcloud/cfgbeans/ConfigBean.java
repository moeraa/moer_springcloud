package com.moer.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: moer
 * @Date: 2019/8/10 16:42
 * @Description:
 */
// 注解版的配置 相当于spring的applicationContext.XML
@Configuration
public class ConfigBean {
  @Bean
//  @LoadBalanced //springcloud netflix ribbon
  public RestTemplate  getRestTemplate(){
    return new RestTemplate();
  }
//  @Bean
//  public IRule myRule(){
//    //return  new RandomRule(); //随机的访问
//    return new RetryRule(); //会有重试 机制
//  }
}
