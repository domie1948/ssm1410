/**
 * ClassesDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 15:21:22
 **/
package com.design.framework.classes.dao;

import java.util.List;

import com.design.framework.classes.model.Classes;

public interface ClassesDao {
    /**
     * classes
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 15:21:22
     * 
     **/
    int delete(Integer class_id);

    /**
     * classes
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 15:21:22
     * 
     **/
    int add(Classes classes);

    /**
     * classes
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 15:21:22
     * 
     **/
    Classes load(Integer class_id);

    /**
     * classes
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 15:21:22
     * 
     **/
    int update(Classes classes);
    List<Classes> list();
    List<Classes> majorClassList(Integer class_major);
}