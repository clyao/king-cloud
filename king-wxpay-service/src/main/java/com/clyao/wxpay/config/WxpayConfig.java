package com.clyao.wxpay.config;

import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.*;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import lombok.Data;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

/**
 * 微信配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wxpay")
public class WxpayConfig {

    private String mchId;

    private String mchSerialNo;

    private String privateKeyPath;

    private String apiV3Key;

    private String appId;

    private String domain;

    private String notifyDomain;

    /**
     * 加载商户私钥
     * @param privateKeyPath
     * @return
     */
    private PrivateKey getPrivateKey(String privateKeyPath){
        try {
            PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new FileInputStream(privateKeyPath));
            return merchantPrivateKey;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从证书管理器中获取verifier
     * @return
     */
    @Bean
    public Verifier getVerifier(){
        try {
            PrivateKey privateKey = getPrivateKey(privateKeyPath);
            PrivateKeySigner privateKeySigner = new PrivateKeySigner(mchSerialNo, privateKey);
            CertificatesManager certificatesManager  = CertificatesManager.getInstance();
            certificatesManager.putMerchant(mchId, new WechatPay2Credentials(mchId, privateKeySigner), apiV3Key.getBytes(StandardCharsets.UTF_8));
            Verifier verifier = certificatesManager.getVerifier(mchId);
            return verifier;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构造的HttpClient
     * @return
     */
    public CloseableHttpClient httpClient(){
        WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                .withMerchant(mchId, mchSerialNo, getPrivateKey(privateKeyPath))
                .withValidator(new WechatPay2Validator(getVerifier()));
        CloseableHttpClient httpClient = builder.build();
        return httpClient;
    }


}
