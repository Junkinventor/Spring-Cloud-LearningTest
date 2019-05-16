package com.ddxgbl.springdatajpatest;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: hi-SpringCould
 * @Package: springdatajap.springdatajap
 * @ClassName: JPADao
 * @Author: 废材
 * @Description: ${description}
 * @Date: 2019/5/11 20:03
 * @Version: 1.0
 */
@Transactional()  //开启事务

public interface JPADao extends JpaRepository<Userid,Integer> {

    //使用修改  新增是必须添加的注解
    @Modifying
    //根据id 修改username  value 编写的为jpql语句
    @Query(value = "update Userid  set username= :username where id = :id",nativeQuery = true )
     void updata(@Param("id") Integer id, @Param("username") String username);


    //当设置nativeQuery=true即可以使用原生SQL进行查询
    @Query(value = "SELECT * FROM Userid order by id",nativeQuery = true)
    List<Userid> findAllByAndDesc();

    //OneAndOne table user、userid
    @Query(value = "SELECT * FROM USERid u inner JOIN User uid ON u.id=uid.id WHERE uid.id= :id  ",nativeQuery = true)
    List<? extends Userid> findByOneAndOne(@Param("id") Integer id);

    /**
     * 一对一  链表查询。
     * 使用的返回值为Userid类
     */
    @Query(value = "SELECT * FROM USERid u inner JOIN User uid ON u.id=uid.id WHERE uid.id= :id  ",nativeQuery = true)
    Userid findByOneAndOneU(@Param("id") Integer id);
}
