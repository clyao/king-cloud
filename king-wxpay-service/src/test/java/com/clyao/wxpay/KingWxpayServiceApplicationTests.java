package com.clyao.wxpay;

import com.clyao.wxpay.utils.WxpayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class KingWxpayServiceApplicationTests {



    @Test
    public void test1(){
        Map<String, Object> map = new HashMap<>();
        String s = new WxpayUtils().unifiedOrder(map);
        System.out.println(s);
    }

}
