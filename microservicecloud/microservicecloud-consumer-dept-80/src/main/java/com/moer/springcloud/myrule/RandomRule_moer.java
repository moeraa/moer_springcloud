package com.moer.springcloud.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * @Auther: moer
 * @Date: 2019/8/17 13:34
 * @Description:
 */
public class RandomRule_moer extends AbstractLoadBalancerRule {

  private int currentIndex = 0;//当前提供服务的机器号
  private int total = 0;    //总共被调用的次数，目前要求每台被调用5次


  @Override
  public Server choose(Object key) {
    return choose(getLoadBalancer(), key);
  }


  public Server choose(ILoadBalancer lb, Object key) {
    if (lb == null) {
      return null;
    }
    Server server = null;

    while (server == null) {
      if (Thread.interrupted()) {
        return null;
      }
      List<Server> upList = lb.getReachableServers();
      List<Server> allList = lb.getAllServers();

      int serverCount = allList.size();
      if (serverCount == 0) {
        return null;
      }


//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);
      if (total < 5) {
        server = upList.get(currentIndex);
        total++;
      } else {
        total = 0;
        currentIndex++;
        if (currentIndex >= upList.size()) {
          currentIndex = 0;
        }

      }


      if (server == null) {
        /*
         * The only time this should happen is if the server list were
         * somehow trimmed. This is a transient condition. Retry after
         * yielding.
         */
        Thread.yield();
        continue;
      }

      if (server.isAlive()) {
        return (server);
      }

      // Shouldn't actually happen.. but must be transient or a bug.
      server = null;
      Thread.yield();
    }

    return server;

  }

  @Override
  public void initWithNiwsConfig(IClientConfig clientConfig) {

  }


  /**
   * @Auther: moer
   * @Date: 2019/8/10 16:59
   * @Description:
   */
  @SpringBootApplication
  @EnableEurekaClient
  //@RibbonClient(name = "MICROSERVICECLOUD-DEPT" ,configuration = MySelfRule.class)
  @EnableFeignClients(basePackages= {"com.moer.springcloud"})
  @ComponentScan("com.moer.springcloud")
  public static class DeptConsumer80_Fegin_App {

    public static void main(String[] args) {
      SpringApplication.run(DeptConsumer80_Fegin_App.class,args);
    }


  }
}
