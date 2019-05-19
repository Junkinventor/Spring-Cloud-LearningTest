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
                /**
                 * 1、使用root为查询参数进行声明
                 * 2、使用CriteriaBuilder 为已经声明了的参数进行赋值
                 * 3、返回值为Predicate类型
                 * 4、注意findOne方法的返回类型仅能存储一组数据
                 */

                //查询的字段
                Path<Object> username = root.get("username");
                Path<Object> password = root.get("password");

                //使用模糊查询
                Predicate like = criteriaBuilder.like(username.as(String.class), "%尔%");
                Predicate likepass = criteriaBuilder.like(password.as(String.class), "%79%");

                //使用精确查询
                Predicate equalTest = criteriaBuilder.equal(username,"科尔");
                Predicate equal = criteriaBuilder.equal(password, "7979");


                //精确的多参数查询 and与  or或
                Predicate and = criteriaBuilder.and(equal,equalTest);


                Predicate andLink = criteriaBuilder.and(like,likepass);

                return andLink;
            }
        };
        List<Userid> all = jpaDao.findAll(spec);
        System.out.println(all);

        //值得注意的是Optional 只能存储一组数据  它只是一个简单的容器
        //Optional<Userid> one = jpaDao.findOne(spec);
        //System.out.println(one);
    }


}
