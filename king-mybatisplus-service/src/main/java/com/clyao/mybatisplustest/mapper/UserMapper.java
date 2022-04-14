package com.clyao.mybatisplustest.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.clyao.mybatisplustest.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-03-08 15:55:53
* @Entity com.clyao.mybatisplustest.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAllByName(@Param("name") String name);

}




