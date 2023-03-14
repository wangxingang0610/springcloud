package com.wangxg.springcloud.fallback;

import com.wangxg.springcloud.client.PaymentHystrixClient;
import org.springframework.stereotype.Component;

/**
 * 降级处理
 */
@Component
public class PaymentFallbackService implements PaymentHystrixClient {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService paymentInfo_OK, o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService paymentInfo_TimeOut, o(╥﹏╥)o";
    }

}
