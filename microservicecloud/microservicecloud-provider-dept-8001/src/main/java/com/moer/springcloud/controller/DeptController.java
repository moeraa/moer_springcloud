package com.moer.springcloud.controller;

import com.moer.springcloud.entites.Dept;
import com.moer.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
  public boolean add(@RequestBody Dept dept) {
    return deptService.add(dept);
  }

  @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
  public List<Dept> add() {
    return deptService.list();
  }

  @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
  public Dept gey(@PathVariable("id") Long id) {
    return deptService.get(id);
  }


}
