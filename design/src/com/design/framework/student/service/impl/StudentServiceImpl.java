package com.design.framework.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.student.dao.StudentDao;
import com.design.framework.student.model.Student;
import com.design.framework.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private StudentDao studentDao;

	@Override
	public int delete(Integer student_id) {
		return this.studentDao.delete(student_id);
	}

	@Override
	public int add(Student student) {
		return this.studentDao.add(student);
	}

	@Override
	public Student load(Integer student_id) {
		return this.studentDao.load(student_id);
	}

	@Override
	public int update(Student student) {
		return this.studentDao.update(student);
	}

	@Override
	public List<Student> list(Student student) {
		return this.studentDao.list(student);
	}

}
