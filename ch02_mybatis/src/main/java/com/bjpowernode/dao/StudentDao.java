package com.bjpowernode.dao;

import com.bjpowernode.bean.Student;

import java.util.List;

/**
 * @author free
 * @version 1.0
 */
public interface StudentDao {
  List<Student> selectStudents();
}
