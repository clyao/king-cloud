package com.clyao.mybatisplustest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clyao.mybatisplustest.entity.Shop;
import com.clyao.mybatisplustest.entity.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

    List<Object> getShop(@Param("lng") Double lng, @Param("lat") Double lat);

}
