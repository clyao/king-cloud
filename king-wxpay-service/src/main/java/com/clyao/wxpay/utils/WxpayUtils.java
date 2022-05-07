package com.clyao.wxpay.utils;

import com.clyao.wxpay.config.WxpayConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class WxpayUtils {

    @Autowired
    private WxpayConfig wxpayConfig;

    /**
     * 统一下单
     * @param params
     * @return
     */
    public String unifiedOrder(Map<String, Object> params){
        try {
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi");
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-type","application/json; charset=utf-8");

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.put("mchid","1558950191")
                    .put("appid", "wx74862e0dfcf69954")
                    .put("description", "Image形象店-深圳腾大-QQ公仔")
                    .put("notify_url", "https://www.weixin.qq.com/wxpay/pay.php")
                    .put("out_trade_no", "1217752501201407033233368018");
            rootNode.putObject("amount")
                    .put("total", 1);
            rootNode.putObject("payer")
                    .put("openid", "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");

            objectMapper.writeValue(bos, rootNode);

            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            CloseableHttpResponse response = wxpayConfig.httpClient().execute(httpPost);

            String bodyAsString = EntityUtils.toString(response.getEntity());
            System.out.println(bodyAsString);
            return bodyAsString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
