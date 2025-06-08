package com.design.framework.manager.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.manager.dao.ManagerDao;
import com.design.framework.manager.model.Manager;
import com.design.framework.manager.service.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;



    @Override
    public Manager login(String account,String password ) {
        Manager manager = this.managerDao.login(account,password);
        if(manager==null){
            throw new RuntimeException ("用户名或者密码错误,请重新登录!");
        }else{
        	return manager;
        }
    }
    

    @Override
    public Manager get(int manager_id ) {
        return  this.managerDao.load(manager_id);
    }
    
    @Override
    public void add(Manager manager) {
        try{
            //1.保存用户信息
            this.managerDao.add(manager);
        }catch (Exception e) {
            throw new RuntimeException("更新失败,原因为:"+e.getMessage());
        }

    }


	@Override
	public List<Manager> list() {
		return this.managerDao.list();
	}


	@Override
	public int delete(Integer manager_id) {
		return this.managerDao.delete(manager_id);
	}
    

}
