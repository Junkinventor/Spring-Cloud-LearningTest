package com.ddxgbl.springdatajpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务支持
@EnableTransactionManagement
public class SpringDataJpaTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringDataJpaTestApplication.class, args);
    }

}
