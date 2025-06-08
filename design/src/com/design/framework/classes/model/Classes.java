/**
 * Classes.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 15:21:22
 **/
package com.design.framework.classes.model;

/**
 * classes 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-05 15:21:22
 **/
public class Classes {

    /**班级id,所属表字段为 classes.class_id  */
    private Integer class_id;
    /**班级名称,所属表字段为 classes.class_name  */
    private String class_name;
    /**班级所属专业id,所属表字段为 classes.class_major  */
    private Integer class_major;
    /**备用字段1 int型,所属表字段为 classes.ext1_int  */
    private Integer ext1_int;
    /**备用字段2 varchar型,所属表字段为 classes.ext2_varchar  */
    private String ext2_varchar;

    /**
     * 获取 班级id 字段:classes.class_id
     *
     * @return  classes.class_id  ,班级id
     */
    public Integer getClass_id() {
        return class_id;
    }

    /**
     * 设置 班级id 字段:classes.class_id
     *
     * @param class_id  classes.class_id,班级id
     */
    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    /**
     * 获取 班级名称 字段:classes.class_name
     *
     * @return  classes.class_name  ,班级名称
     */
    public String getClass_name() {
        return class_name;
    }

    /**
     * 设置 班级名称 字段:classes.class_name
     *
     * @param class_name  classes.class_name,班级名称
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name == null ? null : class_name.trim();
    }

    /**
     * 获取 班级所属专业id 字段:classes.class_major
     *
     * @return  classes.class_major  ,班级所属专业id
     */
    public Integer getClass_major() {
        return class_major;
    }

    /**
     * 设置 班级所属专业id 字段:classes.class_major
     *
     * @param class_major  classes.class_major,班级所属专业id
     */
    public void setClass_major(Integer class_major) {
        this.class_major = class_major;
    }

    /**
     * 获取 备用字段1 int型 字段:classes.ext1_int
     *
     * @return  classes.ext1_int  ,备用字段1 int型
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置 备用字段1 int型 字段:classes.ext1_int
     *
     * @param ext1_int  classes.ext1_int,备用字段1 int型
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取 备用字段2 varchar型 字段:classes.ext2_varchar
     *
     * @return  classes.ext2_varchar  ,备用字段2 varchar型
     */
    public String getExt2_varchar() {
        return ext2_varchar;
    }

    /**
     * 设置 备用字段2 varchar型 字段:classes.ext2_varchar
     *
     * @param ext2_varchar  classes.ext2_varchar,备用字段2 varchar型
     */
    public void setExt2_varchar(String ext2_varchar) {
        this.ext2_varchar = ext2_varchar == null ? null : ext2_varchar.trim();
    }
}