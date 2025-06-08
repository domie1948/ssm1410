/**
 * DormDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 15:22:52
 **/
package com.design.framework.dorm.dao;

import java.util.List;

import com.design.framework.dorm.model.Dorm;

public interface DormDao {
	
    int delete(Integer dorm_id);

    int add(Dorm dorm);

    Dorm load(Integer dorm_id);

    int update(Dorm dorm);
    
    public List<Dorm> list();
}