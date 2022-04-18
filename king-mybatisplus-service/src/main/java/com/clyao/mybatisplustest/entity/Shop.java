package com.clyao.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "shop")
public class Shop {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String shopName;

    private Double lng;

    private Double lat;

}
