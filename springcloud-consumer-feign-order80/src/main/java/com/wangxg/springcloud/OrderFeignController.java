package com.wangxg.springcloud;

import com.wangxg.springcloud.client.PaymentFeignClient;
import com.wangxg.springcloud.entities.CommonResult;
import com.wangxg.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignClient paymentFeignClient;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignClient.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    String paymentFeignTimeOut(){
        return paymentFeignClient.paymentFeignTimeOut();
    }
}
