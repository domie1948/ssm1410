package com.design.framework.manager.service;


import java.util.List;

import com.design.framework.manager.model.Manager;

public interface ManagerService {
    /**
     *
     * FunName: login
     * Description : 用户登录
     * @param：String account,String password
     * @return Manager
     * @Author: pangsir
     * @Create Date: 2016-10-26
     */
    public Manager login(String account,String password);
    
    public Manager get(int user_id);
    
    public void add(Manager manager);
    
    List<Manager> list();
    
    int delete(Integer manager_id);
}
