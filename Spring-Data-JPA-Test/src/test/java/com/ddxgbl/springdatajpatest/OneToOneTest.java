package com.ddxgbl.springdatajpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: Spring-Boot-Cloud-Test
 * @Package: com.ddxgbl.springdatajpatest
 * @ClassName: OneToOneTest
 * @Author: 废材
 * @Description: 一对一关联关系测试
 * @Date: 2019/5/15 9:10
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOneTest {

    @Autowired
    private JPADao jpaDao;
    @Test
    public void OneToOne(){
        //创建角色
        User user=new User();
        user.setName("Druid");

        //创建用户
        Userid userid=new Userid();
        userid.setUsername("Anna");

        //建立关系
        user.setUserid(userid);
        userid.setUser(user);

        //保存数据



    }

    @Test
    public void OneToOne2(){

        Userid byOneAndOneU = this.jpaDao.findByOneAndOneU(1);

        User user1 = byOneAndOneU.getUser();

        System.out.println("user1  "+user1);
        System.out.println("byOneAndOneU  "+byOneAndOneU);

    }

}
