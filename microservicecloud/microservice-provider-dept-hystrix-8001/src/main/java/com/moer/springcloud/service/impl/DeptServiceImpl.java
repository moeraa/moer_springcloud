package com.moer.springcloud.service.impl;

import com.moer.springcloud.dao.DeptDao;
import com.moer.springcloud.entites.Dept;
import com.moer.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: moer
 * @Date: 2019/8/10 12:19
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {
  @Autowired
  private DeptDao deptDao;
  @Override
  public boolean add(Dept dept) {

    return deptDao.addDept(dept);
  }

  @Override
  public Dept get(Long id) {
    return deptDao.findById(id);
  }

  @Override
  public List<Dept> list() {
    return deptDao.findAll();
  }
}
