package com.moer.springcloud.controller;

import com.moer.springcloud.entites.Dept;
import com.moer.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  private DeptClientService service = null;

  @RequestMapping(value = "/consumer/dept/add")
  public Object add(Dept dept) {
    return this.service.add(dept);
  }

  @RequestMapping(value = "/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id) {
    return this.service.get(id);
  }

  @RequestMapping(value = "/consumer/dept/list")
  public List<Dept> list() {
    return this.service.list();
  }


}
