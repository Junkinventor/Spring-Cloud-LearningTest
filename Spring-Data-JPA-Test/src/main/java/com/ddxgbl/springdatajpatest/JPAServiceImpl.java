package com.ddxgbl.springdatajpatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: hi-SpringCould
 * @Package: springdatajap.springdatajap
 * @ClassName: JPAServiceImpl
 * @Author: 废材
 * @Description:
 * @Date: 2019/5/11 20:04
 * @Version: 1.0
 */
@Service
public class JPAServiceImpl implements JPAService {
    @Autowired
    private JPADao jpaDao;

    @Override
    public Optional<Userid> getCityById(Integer id) {
        Optional<Userid> byId = jpaDao.findById(id);
        return byId;
    }

    public List<Userid> findAllByAndDesc() {
        List<Userid> allByAndDesc = jpaDao.findAllByAndDesc();
        return allByAndDesc;
    }

    @Override
    public void  DeletUser(Integer id){
        jpaDao.deleteById(id);
    }


    public void insete(Userid userid){
        jpaDao.save(userid);
    }

    public void updata(Integer id,String username){
        jpaDao.updata(id,username);

    }

    public Userid findByOneAndOneU(Integer id) {
        Userid byOneAndOne = jpaDao.findByOneAndOneU(id);
        return byOneAndOne;
    }
}
