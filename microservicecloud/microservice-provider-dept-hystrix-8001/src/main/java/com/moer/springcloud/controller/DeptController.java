package com.moer.springcloud.controller;

import com.moer.springcloud.entites.Dept;
import com.moer.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: moer
 * @Date: 2019/8/10 12:25
 * @Description:
 */
@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;
  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
  public boolean add(@RequestBody Dept dept) {
    return deptService.add(dept);
  }

  @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
  public List<Dept> add() {
    return deptService.list();
  }
  //不够灵活 高耦合
  @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
  @HystrixCommand(fallbackMethod = "processHystrix_Get")
  public Dept gey(@PathVariable("id") Long id) {
    Dept dept = this.deptService.get(id);
    if (null == dept){
      throw new RuntimeException("该id " + id + "没有对应的信息");
    }else {
      return dept;
    }
  }

  @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
  public Object discovery()
  {
    List<String> list = discoveryClient.getServices();
    System.out.println("**********" + list);

    List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
    for (ServiceInstance element : srvList) {
      System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
          + element.getUri());
    }
    return this.discoveryClient;
  }

  public Dept processHystrix_Get(@PathVariable("id") Long id){
    return new Dept().setDeptno(id).setDname("该id "+ id + "没有对应的信息，null -- @HystrilxCommand")
        .setDb_source("no this database in MYSQL");
  }

}
