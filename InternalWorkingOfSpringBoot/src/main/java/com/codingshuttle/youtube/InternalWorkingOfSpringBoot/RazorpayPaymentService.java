package com.codingshuttle.youtube.InternalWorkingOfSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component //declared as a bean
@ConditionalOnProperty(name="payment.provider", havingValue = "razorpay") //Conditional on value of property "payment.provider" configured in application.properties
public class RazorpayPaymentService implements PaymentService {

    @Override //uses constructor/function of implemented(inherited) interface or class
    public String pay(){
        String payment ="Razorpay Payment";
        System.out.println("Payment from: "+payment);
        return payment;
    }
}
