package com.wangxg.springcloud.controller;

import com.wangxg.springcloud.client.PaymentFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderHystirxController {

    @Resource
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentFeignClient.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentFeignClient.paymentInfo_TimeOut(id);
    }
}
