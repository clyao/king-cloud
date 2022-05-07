package com.clyao.wxpay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxpayController {

    @GetMapping
    public String pay(){
        return "xxx";
    }


}
