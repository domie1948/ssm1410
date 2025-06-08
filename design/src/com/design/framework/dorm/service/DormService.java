package com.design.framework.dorm.service;


import java.util.List;

import com.design.framework.dorm.model.Dorm;

public interface DormService {
    /**
     *
     * FunName: login
     * Description : 用户登录
     * @param：String account,String password
     * @return Dorm
     * @Author: pangsir
     * @Create Date: 2016-10-26
     */
    
    public Dorm get(int user_id);
    
    public void add(Dorm dorm);
    
    public List<Dorm> list();
    
    int delete(Integer dorm_id);
    
    Dorm load(Integer dorm_id);
}
