package com.ddxgbl.springdatajpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
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
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
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

    @Test
    public void SpecificationTest(){
        Specification<Userid> spec = new Specification<Userid>() {
            @Override
            public Predicate toPredicate(Root<Userid> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //查询的字段
                Path<Object> username = root.get("username");

                //使用模糊查询
                Predicate like = criteriaBuilder.like(username.as(String.class), "%尔%");

                //使用精确查询
                Predicate equalTest = criteriaBuilder.equal(username,"科尔");

                return equalTest;
            }
        };
        List<Userid> all = jpaDao.findAll(spec);
        //System.out.println(all);

        //值得注意的是Optional 只能存储一组数据  它只是一个简单的容器
        Optional<Userid> one = jpaDao.findOne(spec);
        System.out.println(one);
    }


}
