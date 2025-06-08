/**
 * Major.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 11:21:48
 **/
package com.design.framework.major.model;

/**
 * major 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-05 11:21:48
 **/
public class Major {

    /**专业id,所属表字段为 major.major_id  */
    private Integer major_id;
    /**专业名称,所属表字段为 major.major_name  */
    private String major_name;
    /**备用字段1 int型,所属表字段为 major.ext1_int  */
    private Integer ext1_int;
    /**备用字段2 varchar型,所属表字段为 major.ext2_varchar  */
    private String ext2_varchar;

    /**
     * 获取 专业id 字段:major.major_id
     *
     * @return  major.major_id  ,专业id
     */
    public Integer getMajor_id() {
        return major_id;
    }

    /**
     * 设置 专业id 字段:major.major_id
     *
     * @param major_id  major.major_id,专业id
     */
    public void setMajor_id(Integer major_id) {
        this.major_id = major_id;
    }

    /**
     * 获取 专业名称 字段:major.major_name
     *
     * @return  major.major_name  ,专业名称
     */
    public String getMajor_name() {
        return major_name;
    }

    /**
     * 设置 专业名称 字段:major.major_name
     *
     * @param major_name  major.major_name,专业名称
     */
    public void setMajor_name(String major_name) {
        this.major_name = major_name == null ? null : major_name.trim();
    }

    /**
     * 获取 备用字段1 int型 字段:major.ext1_int
     *
     * @return  major.ext1_int  ,备用字段1 int型
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置 备用字段1 int型 字段:major.ext1_int
     *
     * @param ext1_int  major.ext1_int,备用字段1 int型
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取 备用字段2 varchar型 字段:major.ext2_varchar
     *
     * @return  major.ext2_varchar  ,备用字段2 varchar型
     */
    public String getExt2_varchar() {
        return ext2_varchar;
    }

    /**
     * 设置 备用字段2 varchar型 字段:major.ext2_varchar
     *
     * @param ext2_varchar  major.ext2_varchar,备用字段2 varchar型
     */
    public void setExt2_varchar(String ext2_varchar) {
        this.ext2_varchar = ext2_varchar == null ? null : ext2_varchar.trim();
    }
}