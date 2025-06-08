/**
 * Student.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-05 11:11:47
 **/
package com.design.framework.student.model;

/**
 * student 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-05 11:11:47
 **/
public class Student {

    /**学生id 主键,所属表字段为 student.student_id  */
    private Integer student_id;
    /**学生姓名,所属表字段为 student.student_name  */
    private String student_name;
    /**学生年龄,所属表字段为 student.student_age  */
    private Integer student_age;
    /**学生性别 男生1 女生0,所属表字段为 student.student_sex  */
    private Integer student_sex;
    /**社会面貌 党员2 团员1 群众0,所属表字段为 student.student_social_presence  */
    private Integer student_social_presence;
    /**学生班级id,所属表字段为 student.student_class  */
    private Integer student_class;
    /**学生宿舍id,所属表字段为 student.student_dorm  */
    private Integer student_dorm;
    /**学生专业id,所属表字段为 student.student_major  */
    private Integer student_major;
    /**学生联系电话,所属表字段为 student.student_tel  */
    private String student_tel;
    /**学生是否缴费 0未缴费 1已缴费,所属表字段为 student.student_tuition  */
    private Integer student_tuition;
    /**学生家庭住址,所属表字段为 student.student_home  */
    private String student_home;
    /**备用字段1 int型,所属表字段为 student.ext1_int  */
    private Integer ext1_int;
    /**备用字段2 varchar型,所属表字段为 student.ext2_varchar  */
    private String ext2_varchar;

    /**
     * 获取 学生id 主键 字段:student.student_id
     *
     * @return  student.student_id  ,学生id 主键
     */
    public Integer getStudent_id() {
        return student_id;
    }

    /**
     * 设置 学生id 主键 字段:student.student_id
     *
     * @param student_id  student.student_id,学生id 主键
     */
    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    /**
     * 获取 学生姓名 字段:student.student_name
     *
     * @return  student.student_name  ,学生姓名
     */
    public String getStudent_name() {
        return student_name;
    }

    /**
     * 设置 学生姓名 字段:student.student_name
     *
     * @param student_name  student.student_name,学生姓名
     */
    public void setStudent_name(String student_name) {
        this.student_name = student_name == null ? null : student_name.trim();
    }

    /**
     * 获取 学生年龄 字段:student.student_age
     *
     * @return  student.student_age  ,学生年龄
     */
    public Integer getStudent_age() {
        return student_age;
    }

    /**
     * 设置 学生年龄 字段:student.student_age
     *
     * @param student_age  student.student_age,学生年龄
     */
    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    /**
     * 获取 学生性别 男生1 女生0 字段:student.student_sex
     *
     * @return  student.student_sex  ,学生性别 男生1 女生0
     */
    public Integer getStudent_sex() {
        return student_sex;
    }

    /**
     * 设置 学生性别 男生1 女生0 字段:student.student_sex
     *
     * @param student_sex  student.student_sex,学生性别 男生1 女生0
     */
    public void setStudent_sex(Integer student_sex) {
        this.student_sex = student_sex;
    }

    /**
     * 获取 社会面貌 党员2 团员1 群众0 字段:student.student_social_presence
     *
     * @return  student.student_social_presence  ,社会面貌 党员2 团员1 群众0
     */
    public Integer getStudent_social_presence() {
        return student_social_presence;
    }

    /**
     * 设置 社会面貌 党员2 团员1 群众0 字段:student.student_social_presence
     *
     * @param student_social_presence  student.student_social_presence,社会面貌 党员2 团员1 群众0
     */
    public void setStudent_social_presence(Integer student_social_presence) {
        this.student_social_presence = student_social_presence;
    }

    /**
     * 获取 学生班级id 字段:student.student_class
     *
     * @return  student.student_class  ,学生班级id
     */
    public Integer getStudent_class() {
        return student_class;
    }

    /**
     * 设置 学生班级id 字段:student.student_class
     *
     * @param student_class  student.student_class,学生班级id
     */
    public void setStudent_class(Integer student_class) {
        this.student_class = student_class;
    }

    /**
     * 获取 学生宿舍id 字段:student.student_dorm
     *
     * @return  student.student_dorm  ,学生宿舍id
     */
    public Integer getStudent_dorm() {
        return student_dorm;
    }

    /**
     * 设置 学生宿舍id 字段:student.student_dorm
     *
     * @param student_dorm  student.student_dorm,学生宿舍id
     */
    public void setStudent_dorm(Integer student_dorm) {
        this.student_dorm = student_dorm;
    }

    /**
     * 获取 学生专业id 字段:student.student_major
     *
     * @return  student.student_major  ,学生专业id
     */
    public Integer getStudent_major() {
        return student_major;
    }

    /**
     * 设置 学生专业id 字段:student.student_major
     *
     * @param student_major  student.student_major,学生专业id
     */
    public void setStudent_major(Integer student_major) {
        this.student_major = student_major;
    }

    /**
     * 获取 学生联系电话 字段:student.student_tel
     *
     * @return  student.student_tel  ,学生联系电话
     */
    public String getStudent_tel() {
        return student_tel;
    }

    /**
     * 设置 学生联系电话 字段:student.student_tel
     *
     * @param student_tel  student.student_tel,学生联系电话
     */
    public void setStudent_tel(String student_tel) {
        this.student_tel = student_tel == null ? null : student_tel.trim();
    }

    /**
     * 获取 学生是否缴费 0未缴费 1已缴费 字段:student.student_tuition
     *
     * @return  student.student_tuition  ,学生是否缴费 0未缴费 1已缴费
     */
    public Integer getStudent_tuition() {
        return student_tuition;
    }

    /**
     * 设置 学生是否缴费 0未缴费 1已缴费 字段:student.student_tuition
     *
     * @param student_tuition  student.student_tuition,学生是否缴费 0未缴费 1已缴费
     */
    public void setStudent_tuition(Integer student_tuition) {
        this.student_tuition = student_tuition;
    }

    /**
     * 获取 学生家庭住址 字段:student.student_home
     *
     * @return  student.student_home  ,学生家庭住址
     */
    public String getStudent_home() {
        return student_home;
    }

    /**
     * 设置 学生家庭住址 字段:student.student_home
     *
     * @param student_home  student.student_home,学生家庭住址
     */
    public void setStudent_home(String student_home) {
        this.student_home = student_home == null ? null : student_home.trim();
    }

    /**
     * 获取 备用字段1 int型 字段:student.ext1_int
     *
     * @return  student.ext1_int  ,备用字段1 int型
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置 备用字段1 int型 字段:student.ext1_int
     *
     * @param ext1_int  student.ext1_int,备用字段1 int型
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取 备用字段2 varchar型 字段:student.ext2_varchar
     *
     * @return  student.ext2_varchar  ,备用字段2 varchar型
     */
    public String getExt2_varchar() {
        return ext2_varchar;
    }

    /**
     * 设置 备用字段2 varchar型 字段:student.ext2_varchar
     *
     * @param ext2_varchar  student.ext2_varchar,备用字段2 varchar型
     */
    public void setExt2_varchar(String ext2_varchar) {
        this.ext2_varchar = ext2_varchar == null ? null : ext2_varchar.trim();
    }

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name="
				+ student_name + ", student_age=" + student_age
				+ ", student_sex=" + student_sex + ", student_social_presence="
				+ student_social_presence + ", student_class=" + student_class
				+ ", student_dorm=" + student_dorm + ", student_major="
				+ student_major + ", student_tel=" + student_tel
				+ ", student_tuition=" + student_tuition + ", student_home="
				+ student_home + ", ext1_int=" + ext1_int + ", ext2_varchar="
				+ ext2_varchar + "]";
	}
    
}