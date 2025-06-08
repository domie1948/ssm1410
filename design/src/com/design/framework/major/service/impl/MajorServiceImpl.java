package com.design.framework.major.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.major.dao.MajorDao;
import com.design.framework.major.model.Major;
import com.design.framework.major.service.MajorService;

@Service
public class MajorServiceImpl implements MajorService {
	
	@Autowired
    private MajorDao majorDao;

	@Override
	public int delete(Integer major_id) {
		return this.majorDao.delete(major_id);
	}

	@Override
	public int add(Major major) {
		return this.majorDao.add(major);
	}

	@Override
	public Major load(Integer major_id) {
		return this.majorDao.load(major_id);
	}

	@Override
	public int update(Major major) {
		return this.majorDao.update(major);
	}

	@Override
	public List<Major> list() {
		return this.majorDao.list();
	}

}
