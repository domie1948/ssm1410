/**
 * MajorMapper.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 11:21:48
 **/
package com.design.framework.major.dao;

import java.util.List;

import com.design.framework.major.model.Major;

public interface MajorDao {
    /**
     * major
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:21:48
     * 
     **/
    int delete(Integer major_id);

    /**
     * major
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:21:48
     * 
     **/
    int add(Major major);

    /**
     * major
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:21:48
     * 
     **/
    Major load(Integer major_id);

    /**
     * major
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:21:48
     * 
     **/
    int update(Major major);
    List<Major> list();
}