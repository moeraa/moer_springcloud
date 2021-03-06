package com.moer.springcloud.controller;

import com.moer.springcloud.entites.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: moer
 * @Date: 2019/8/10 16:48
 * @Description:
 */
@RestController
public class DeptController_Consumer {

//  private static final String REST_URL_PREFIX = "http://localhost:8001";
private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

  @Autowired
  private RestTemplate restTemplate;

  // restful 客户端的模板
  // （url request response）
  @RequestMapping(value = "/consumer/dept/add")
  public boolean add(Dept dept) {
    return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
  }

  @RequestMapping(value = "/consumer/dept/get/{id}")
  public Dept get(@PathVariable Long id) {
    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
  }

  @RequestMapping(value = "/consumer/dept/list")
  public List<Dept> list() {
    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
  }

  //测试@EnableDiscoveryClient,消费端可以调用服务发现
  @RequestMapping(value="/consumer/dept/discovery")
  public Object discovery()
  {
    return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
  }

}
