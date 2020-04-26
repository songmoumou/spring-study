package com.song.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AJohn
 */
@RestController
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @RequestMapping("/add")
  public Employee addEmployee() {
    Employee employee = null;
    try {
      employee = employeeService.addEmployee5();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return employee;

  }


}
