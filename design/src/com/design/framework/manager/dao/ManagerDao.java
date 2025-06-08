/**
 * ManagerDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 14:59:38
 **/
package com.design.framework.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.design.framework.manager.model.Manager;

public interface ManagerDao {
    int delete(Integer manager_id);

    int add(Manager manager);

    Manager load(Integer manager_id);

    int update(Manager manager);

	Manager login( @Param("account") String account,@Param("password") String password);
	
	List<Manager> list();
}