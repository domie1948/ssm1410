package com.design.framework.dorm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.dorm.dao.DormDao;
import com.design.framework.dorm.model.Dorm;
import com.design.framework.dorm.service.DormService;


@Service
public class DormServiceImpl implements DormService {
    @Autowired
    private DormDao dormDao;




    @Override
    public Dorm get(int dorm_id ) {
        return  this.dormDao.load(dorm_id);
    }
    
    @Override
    public void add(Dorm dorm) {
        try{
            //1.保存用户信息
            this.dormDao.add(dorm);
        }catch (Exception e) {
            throw new RuntimeException("更新失败,原因为:"+e.getMessage());
        }

    }

	@Override
	public List<Dorm> list() {
		 return this.dormDao.list();
	}

	@Override
	public int delete(Integer dorm_id) {
		return this.dormDao.delete(dorm_id);
	}

	@Override
	public Dorm load(Integer dorm_id) {
		return this.dormDao.load(dorm_id);
	}
    

}
