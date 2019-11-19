package com.topshow.entity;

/**
 * 舞蹈老师实体类
 * @author Administrator
 *
 */
public class DanceTeacher {
    
    //ID
    private String id;
    //姓名
    private String name;
    //毕业学院
    private String graduateSchool;
    //教学资质
    private String teachingQualification;
    //教学范围
    private String teachingScope;
    //描述
    private String describe;
    //年龄
    private String age;
    //国籍
    private String international;
    //导师图片
    private String img;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGraduateSchool() {
        return graduateSchool;
    }
    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }
    public String getTeachingScope() {
        return teachingScope;
    }
    public void setTeachingScope(String teachingScope) {
        this.teachingScope = teachingScope;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getTeachingQualification() {
        return teachingQualification;
    }
    public void setTeachingQualification(String teachingQualification) {
        this.teachingQualification = teachingQualification;
    }
    public String getInternational() {
        return international;
    }
    public void setInternational(String international) {
        this.international = international;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    @Override
    public String toString() {
        return "DanceTeacher [id=" + id + ", name=" + name + ", graduateSchool=" + graduateSchool
                + ", teachingQualification=" + teachingQualification + ", teachingScope=" + teachingScope
                + ", describe=" + describe + ", age=" + age + ", international=" + international + ", img=" + img + "]";
    }
    
    
    
}
