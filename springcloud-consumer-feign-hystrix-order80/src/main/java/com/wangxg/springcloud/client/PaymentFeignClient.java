package com.wangxg.springcloud.client;

import com.wangxg.springcloud.entities.CommonResult;
import com.wangxg.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("SPRINGCLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentFeignClient {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) ;

}
