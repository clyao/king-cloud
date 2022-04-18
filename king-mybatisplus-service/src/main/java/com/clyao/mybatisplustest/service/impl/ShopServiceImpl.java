package com.clyao.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clyao.mybatisplustest.entity.Shop;
import com.clyao.mybatisplustest.mapper.ShopMapper;
import com.clyao.mybatisplustest.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Object> getShop(Double lng, Double lat) {
        return shopMapper.getShop(lng, lat);
    }
}
