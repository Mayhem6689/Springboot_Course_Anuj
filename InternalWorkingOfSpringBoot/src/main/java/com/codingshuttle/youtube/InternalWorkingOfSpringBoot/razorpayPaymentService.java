package com.codingshuttle.youtube.InternalWorkingOfSpringBoot;

import org.springframework.stereotype.Component;

@Component //declared as a bean
public class razorpayPaymentService {
    public String pay(){
        String payment ="Razorpay Payment";
        System.out.println("Payment from: "+payment);
        return payment;
    }
}
