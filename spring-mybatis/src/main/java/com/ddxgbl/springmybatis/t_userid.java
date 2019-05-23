package com.ddxgbl.springmybatis;

import java.util.Date;

/**
 * @ProjectName: Spring-Boot-Cloud-Test
 * @Package: com.ddxgbl.springmybatis
 * @ClassName: t_userid
 * @Author: 废材
 * @Description: Userid 表
 * @Date: 2019/5/23 9:49
 * @Version: 1.0
 */

public class t_userid {
    private Integer id;

    private String username;

    private String password;

    /**
     * 注册时间
     */
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "t_userid{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", time=" + time +
                '}';
    }
}
