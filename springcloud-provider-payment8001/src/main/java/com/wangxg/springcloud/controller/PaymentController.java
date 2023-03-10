package com.wangxg.springcloud.controller;

import com.wangxg.springcloud.entities.CommonResult;
import com.wangxg.springcloud.entities.Payment;
import com.wangxg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-18 10:43
 */
@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result > 0)
        {
            return new CommonResult(200,"插入数据库成功,serverPort: ");
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("1111111111111111221");
        if(payment != null)
        {
            return new CommonResult(200,"查询成功,serverPort:  ");
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }

}
