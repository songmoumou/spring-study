package com.song.spring.test;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author AJohn
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {


  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;
  String name;
  int age;
}
