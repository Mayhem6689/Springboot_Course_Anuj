package com.codingshuttle.youtube.InternalWorkingOfSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//instead of using the main method for running the CLI Commands, we use the Command Line runner interface to abstract main.
public class InternalWorkingOfSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingOfSpringBootApplication.class, args);
	}


	private razorpayPaymentService paymentService=new razorpayPaymentService();// declaration of paymentService object
// This method will run after everything is already completed (ie at the end)
	// we can use non static methods in this interface's object as it is not declared as a static.
	@Override
	public void run(String... args) throws Exception {
	String payment = paymentService.pay();
	System.out.println("Payment Done: "+payment);
	}
}
//runs at end of log file printed in terminal after running
// tightly coupled because every time when we'll use other classes, we'll need to declare them seperately which is not what is needed
// we need them to be auto-configured so that the classes and objects are automatically selected (payment service in our case for eg Phonepe, gpay)
// Beans are java objects maintained by Spring Container
// @Component annotation is used to create bean. any class can be used as a bean