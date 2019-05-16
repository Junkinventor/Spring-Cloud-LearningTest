package com.ddxgbl.springdatajpatest;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: hi-SpringCould
 * @Package: springdatajap.springdatajap
 * @ClassName: JPAController
 * @Author: 废材
 * @Description:
 * @Date: 2019/5/11 20:07
 * @Version: 1.0
 */
@RestController
@RequestMapping("/JPA")
public class JPAController {

    @Autowired(required = true)
    JPAService jpaService;

    @RequestMapping("/find")
   public String ControllerJpa(@RequestParam("id") Integer id){
        Optional<Userid> cityById = jpaService.getCityById(id);
        return "( ╯□╰ )"+"name"+cityById.get().getUsername()+"\nid"+cityById.get().getId()+"\nTime"+cityById.get().getTime();
    }

    @RequestMapping("/findDesc")
   public String  ControllerAllByAndDesc(){
       List<? extends Userid> allByAndDesc = jpaService.findAllByAndDesc();
       return "( ╯□╰ )"+allByAndDesc;
    }

    @RequestMapping("/delete")
   public String ControllerJpaDelete(@RequestParam("id") Integer id){
        jpaService.DeletUser(id);
        return "( ╯□╰ )";
    }

    @RequestMapping("save")
    public void ControllerInsert(Userid userid){
        userid.setId(2);
        userid.setPassword("7979");
        userid.setTime(new Date());
        userid.setUsername("76");
        jpaService.insete(userid);
    }

    //更新
    @RequestMapping("update")
    public void ControllerUpdate(@RequestParam("id") Integer id, @RequestParam("username") String username){
        jpaService.updata(id,username);
    }

    //根据id  进行一对一的链表查询
    @RequestMapping("OneAndOne")
    public String findByOneAndOne(@RequestParam("id") Integer id){
       return null;
    }


    //根据id  进行一对一的链表查询
    @RequestMapping("OneAndOneU")
    public String findByOneAndOneU(@RequestParam("id") Integer id){
        Userid byOneAndOne = jpaService.findByOneAndOneU(id);

        User user = byOneAndOne.getUser();

        return byOneAndOne.toString()+user.toString();
    }
}
