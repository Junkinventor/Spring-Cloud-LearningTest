package com.ddxgbl.springdatajpatest;

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

@Entity   //声明映射
public class Userid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    /**
     * 注册时间
     */
    private Date time;

    @OneToOne(cascade = CascadeType.ALL)
    /*@JoinTable(name = "user",inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))*/
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     * name: 数据库字段名
     * nullable: 是否为空
     *
     */
    @Column(name = "username" ,nullable = true)
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册时间
     * @return time - 注册时间
     * @Temporal TIMESTAMP：年-月-日  时-分-秒
     */
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTime() {
        return time;
    }

    /**
     * 设置注册时间
     *
     * @param time 注册时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Userid{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", time=" + time +
                '}';
    }
}