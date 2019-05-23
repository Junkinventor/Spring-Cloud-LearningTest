package com.ddxgbl.springmybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMybatisApplicationTests {

    @Autowired
    MapperAndUserid userid;
    @Test
    public void contextLoads() {
        List<t_userid> allandUserid = userid.findAllandUserid();
        for (t_userid t_userid : allandUserid) {
            System.out.println(t_userid);
        }
    }

}
