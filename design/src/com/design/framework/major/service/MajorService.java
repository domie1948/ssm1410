/**
 * MajorMapper.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 11:21:48
 **/
package com.design.framework.major.service;

import java.util.List;

import com.design.framework.major.model.Major;

public interface MajorService {
	
    int delete(Integer major_id);
    int add(Major major);
    Major load(Integer major_id);
    int update(Major major);
    List<Major> list();
}