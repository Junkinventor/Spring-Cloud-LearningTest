package com.ddxgbl.springmybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @ProjectName: Spring-Boot-Cloud-Test
 * @Package: com.ddxgbl.springmybatis
 * @ClassName: MapperAndUserid
 * @Author: 废材
 * @Description: ${description}
 * @Date: 2019/5/23 9:48
 * @Version: 1.0
 */
@Mapper
public interface MapperAndUserid {
    @Select("select * from userid ")
    List<t_userid> findAllandUserid();
}
