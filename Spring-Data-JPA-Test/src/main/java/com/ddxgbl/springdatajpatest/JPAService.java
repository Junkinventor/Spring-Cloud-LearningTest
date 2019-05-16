package com.ddxgbl.springdatajpatest;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: hi-SpringCould
 * @Package: springdatajap.springdatajap
 * @ClassName: JPAService
 * @Author: 废材
 * @Description: ${description}
 * @Date: 2019/5/11 20:08
 * @Version: 1.0
 */
public interface JPAService {
      //根据id   查询
      Optional<Userid> getCityById(Integer id);
      //根据id倒序
      List<Userid> findAllByAndDesc();

      //根据id  删除
      void  DeletUser(Integer id);

      //添加
      void insete(Userid userid);

      //修改
      void updata(Integer id, String username);

      Userid findByOneAndOneU(Integer id);
}
