package com.song.spring.test;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Transactional
  public Employee addEmployee() throws Exception {

    employeeRepository.deleteAll();

    Employee employee = new Employee("mytest", 23);

    // 模拟异常
    int i = 1 / 0;

    return employee;
  }

}