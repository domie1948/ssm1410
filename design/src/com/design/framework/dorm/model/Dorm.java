/**
 * Dorm.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 15:22:52
 **/
package com.design.framework.dorm.model;

/**
 * dorm 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-05 15:22:52
 **/
public class Dorm {

    /**宿舍id,所属表字段为 dorm.dorm_id  */
    private Integer dorm_id;
    /**宿舍名称,所属表字段为 dorm.dorm_name  */
    private String dorm_name;
    /**备用字段1 int型,所属表字段为 dorm.ext1_int  */
    private Integer ext1_int;
    /**备用字段2 varchar型,所属表字段为 dorm.ext2_varchar  */
    private String ext2_varchar;

    /**
     * 获取 宿舍id 字段:dorm.dorm_id
     *
     * @return  dorm.dorm_id  ,宿舍id
     */
    public Integer getDorm_id() {
        return dorm_id;
    }

    /**
     * 设置 宿舍id 字段:dorm.dorm_id
     *
     * @param dorm_id  dorm.dorm_id,宿舍id
     */
    public void setDorm_id(Integer dorm_id) {
        this.dorm_id = dorm_id;
    }

    /**
     * 获取 宿舍名称 字段:dorm.dorm_name
     *
     * @return  dorm.dorm_name  ,宿舍名称
     */
    public String getDorm_name() {
        return dorm_name;
    }

    /**
     * 设置 宿舍名称 字段:dorm.dorm_name
     *
     * @param dorm_name  dorm.dorm_name,宿舍名称
     */
    public void setDorm_name(String dorm_name) {
        this.dorm_name = dorm_name == null ? null : dorm_name.trim();
    }

    /**
     * 获取 备用字段1 int型 字段:dorm.ext1_int
     *
     * @return  dorm.ext1_int  ,备用字段1 int型
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置 备用字段1 int型 字段:dorm.ext1_int
     *
     * @param ext1_int  dorm.ext1_int,备用字段1 int型
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取 备用字段2 varchar型 字段:dorm.ext2_varchar
     *
     * @return  dorm.ext2_varchar  ,备用字段2 varchar型
     */
    public String getExt2_varchar() {
        return ext2_varchar;
    }

    /**
     * 设置 备用字段2 varchar型 字段:dorm.ext2_varchar
     *
     * @param ext2_varchar  dorm.ext2_varchar,备用字段2 varchar型
     */
    public void setExt2_varchar(String ext2_varchar) {
        this.ext2_varchar = ext2_varchar == null ? null : ext2_varchar.trim();
    }
}