package com.moer.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: moer
 * @Date: 2019/8/17 12:10
 * @Description:
 */
@Configuration
public class MySelfRule {
  @Bean
  public IRule myRule(){
    return new RandomRule_moer();
  }
}
