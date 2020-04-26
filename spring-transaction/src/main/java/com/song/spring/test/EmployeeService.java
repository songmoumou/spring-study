package com.song.spring.test;

import javax.transaction.Transactional;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AJohn
 */
@Service
public class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;
  @Autowired
  TestService testService;


  @Transactional
  public Employee addEmployee() {
    Employee employee = new Employee("test", 23);
    employeeRepository.save(employee);
    // 假设这里出了Exception
    int i = 1 / 0;
    return employee;
  }

  //调用本类方法，不会开启事务，不会滚
  public Employee addEmployee2() throws Exception {
    return this.addEmployee();

  }
  //调用本类方法，造成不回滚的两种解决方法addEmployee4，addEmployee5
  //调用本类方法，本方法添加Transactional，抛出RuntimeException，回滚
  @Transactional
  public Employee addEmployee4() throws Exception {
    try {
      this.addEmployee();  //这里this调用会使事务失效，数据会被保存
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException();
    }
    return null;

  }

  //调用本类方法，本方法不添加Transactional，this调用改成动态代理调用(AopContext.currentProxy()) 回滚
  public Employee addEmployee5() throws Exception {
    try {
      EmployeeService proxy =(EmployeeService) AopContext.currentProxy();
      proxy.addEmployee();
    }catch (Exception e){
      e.printStackTrace();
      throw new RuntimeException();
    }
    return null;

  }
  // 没有事务的方法去调用别的类有事务的方法，回滚
  public Employee addEmployee3() throws Exception {
    return testService.addEmployee();
  }
}
