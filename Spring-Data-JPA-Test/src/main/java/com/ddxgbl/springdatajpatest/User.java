package com.ddxgbl.springdatajpatest;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;


/**
 * @ProjectName: hi-SpringCould
 * @Package: springdatajap.springdatajap
 * @ClassName: Userid
 * @Author: 废材
 * @Description:
 * @Date: 2019/5/11 19:59
 * @Version: 1.0
 */

@Entity   //声明映射  实体类
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private Integer sex;

    private Integer age;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private Userid userid ;


    public Userid getUserid() {
        return userid;
    }

    public void setUserid(Userid userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}