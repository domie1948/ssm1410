package com.design.framework.classes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.classes.dao.ClassesDao;
import com.design.framework.classes.model.Classes;
import com.design.framework.classes.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
    private ClassesDao classesDao;
	
	@Override
	public int delete(Integer class_id) {
		return this.classesDao.delete(class_id);
	}

	@Override
	public int add(Classes classes) {
		return this.classesDao.add(classes);
	}

	@Override
	public Classes load(Integer class_id) {
		return this.classesDao.load(class_id);
	}

	@Override
	public int update(Classes classes) {
		return this.classesDao.update(classes);
	}

	@Override
	public List<Classes> list() {
		return this.classesDao.list();
	}

	@Override
	public List<Classes> majorClassList(Integer class_major) {
		return this.classesDao.majorClassList(class_major);
	}

}
