package com.clyao.mybatisplustest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clyao.mybatisplustest.entity.Shop;

import java.util.List;

public interface ShopService extends IService<Shop> {

    public List<Object> getShop(Double lng, Double lat);

}
