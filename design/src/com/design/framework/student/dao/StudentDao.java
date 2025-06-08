/**
 * StudentDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 11:11:47
 **/
package com.design.framework.student.dao;

import java.util.List;

import com.design.framework.student.model.Student;

public interface StudentDao {
    /**
     * student
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:11:47
     * 
     **/
    int delete(Integer student_id);

    /**
     * student
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:11:47
     * 
     **/
    int add(Student student);

    /**
     * student
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:11:47
     * 
     **/
    Student load(Integer student_id);

    /**
     * student
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-04-05 11:11:47
     * 
     **/
    int update(Student student);
    List<Student> list(Student student);
}