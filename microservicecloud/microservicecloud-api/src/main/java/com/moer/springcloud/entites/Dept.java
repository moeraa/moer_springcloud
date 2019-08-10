package com.moer.springcloud.entites;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: moer
 * @Date: 2019/8/10 11:01
 * @Description:
 */
@NoArgsConstructor
@Data
@SuppressWarnings("serial")
@Accessors(chain = true)
public class Dept implements Serializable {

  private Long deptno;
  private String dname;
  private String db_source;

  public Dept(Long deptno) {
    this.deptno = deptno;
  }
}
