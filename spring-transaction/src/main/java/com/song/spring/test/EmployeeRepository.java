package com.song.spring.test;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author AJohn
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
