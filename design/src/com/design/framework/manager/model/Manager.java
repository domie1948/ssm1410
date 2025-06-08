/**
 * Manager.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 14:59:38
 **/
package com.design.framework.manager.model;

/**
 * manager 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-05 14:59:38
 **/
public class Manager {

    /**管理员id,所属表字段为 manager.manager_id  */
    private Integer manager_id;
    /**管理员账号,所属表字段为 manager.manager_account  */
    private String manager_account;
    /**管理员密码,所属表字段为 manager.manager_password  */
    private String manager_password;
    /**管理员姓名,所属表字段为 manager.manager_name  */
    private String manager_name;
    /**管理员角色 系部3 财务2 宿舍1 系统0,所属表字段为 manager.manager_role  */
    private Integer manager_role;
    /**备用字段1 int型,所属表字段为 manager.ext1_int  */
    private Integer ext1_int;
    /**备用字段2 varchar型,所属表字段为 manager.ext2_varchar  */
    private String ext2_varchar;

    /**
     * 获取 管理员id 字段:manager.manager_id
     *
     * @return  manager.manager_id  ,管理员id
     */
    public Integer getManager_id() {
        return manager_id;
    }

    /**
     * 设置 管理员id 字段:manager.manager_id
     *
     * @param manager_id  manager.manager_id,管理员id
     */
    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    /**
     * 获取 管理员账号 字段:manager.manager_account
     *
     * @return  manager.manager_account  ,管理员账号
     */
    public String getManager_account() {
        return manager_account;
    }

    /**
     * 设置 管理员账号 字段:manager.manager_account
     *
     * @param manager_account  manager.manager_account,管理员账号
     */
    public void setManager_account(String manager_account) {
        this.manager_account = manager_account == null ? null : manager_account.trim();
    }

    /**
     * 获取 管理员密码 字段:manager.manager_password
     *
     * @return  manager.manager_password  ,管理员密码
     */
    public String getManager_password() {
        return manager_password;
    }

    /**
     * 设置 管理员密码 字段:manager.manager_password
     *
     * @param manager_password  manager.manager_password,管理员密码
     */
    public void setManager_password(String manager_password) {
        this.manager_password = manager_password == null ? null : manager_password.trim();
    }

    /**
     * 获取 管理员姓名 字段:manager.manager_name
     *
     * @return  manager.manager_name  ,管理员姓名
     */
    public String getManager_name() {
        return manager_name;
    }

    /**
     * 设置 管理员姓名 字段:manager.manager_name
     *
     * @param manager_name  manager.manager_name,管理员姓名
     */
    public void setManager_name(String manager_name) {
        this.manager_name = manager_name == null ? null : manager_name.trim();
    }

    /**
     * 获取 管理员角色 系部3 财务2 宿舍1 系统0 字段:manager.manager_role
     *
     * @return  manager.manager_role  ,管理员角色 系部3 财务2 宿舍1 系统0
     */
    public Integer getManager_role() {
        return manager_role;
    }

    /**
     * 设置 管理员角色 系部3 财务2 宿舍1 系统0 字段:manager.manager_role
     *
     * @param manager_role  manager.manager_role,管理员角色 系部3 财务2 宿舍1 系统0
     */
    public void setManager_role(Integer manager_role) {
        this.manager_role = manager_role;
    }

    /**
     * 获取 备用字段1 int型 字段:manager.ext1_int
     *
     * @return  manager.ext1_int  ,备用字段1 int型
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置 备用字段1 int型 字段:manager.ext1_int
     *
     * @param ext1_int  manager.ext1_int,备用字段1 int型
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取 备用字段2 varchar型 字段:manager.ext2_varchar
     *
     * @return  manager.ext2_varchar  ,备用字段2 varchar型
     */
    public String getExt2_varchar() {
        return ext2_varchar;
    }

    /**
     * 设置 备用字段2 varchar型 字段:manager.ext2_varchar
     *
     * @param ext2_varchar  manager.ext2_varchar,备用字段2 varchar型
     */
    public void setExt2_varchar(String ext2_varchar) {
        this.ext2_varchar = ext2_varchar == null ? null : ext2_varchar.trim();
    }
}