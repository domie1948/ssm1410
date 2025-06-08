package com.design.framework.student.service;

import java.util.List;

import com.design.framework.student.model.Student;

public interface StudentService {
	
    int delete(Integer student_id);
    int add(Student student);
    Student load(Integer student_id);
    int update(Student student);
    List<Student> list(Student student);
}
