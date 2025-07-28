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
	//Constructor Dependency injection (read more at bottom)
	private PaymentService paymentService;
	/*
	We have created a interface (PaymentService) for multiple beans (multiple payment methods) and autowired (injected) them in the application
	Now this constructor call will give error {InternalWorkingOfSpringBootApplication(PaymentService paymentService)}
	because instead of 1 bean, 2 beans were found which conflict each other
	how can we setup which bean to be selected automatically?
	--> we add a conditional service in application.properties in src/main/resources
	and then use @ConditionalOnProperty annotation in the beans to fulfill a particular condition defined in application.properties

	*/
	InternalWorkingOfSpringBootApplication(PaymentService paymentService){
		this.paymentService = paymentService;
	}

// This declaration is for standard classes
// private razorpayPaymentService paymentService=new razorpayPaymentService(); declaration of paymentService object
// This method will run after everything is already completed (ie at the end)
// we can use non static methods in this interface's object as it is not declared as a static.

    @Override
    public void run(String... args) throws Exception {
        String payment = paymentService.pay();
        System.out.println("Payment Done: " + payment);
    }
}
//runs at end of log file printed in terminal after running
// tightly coupled because every time when we'll use other classes, we'll need to declare them seperately which is not what is needed
// we need them to be auto-configured so that the classes and objects are automatically selected (payment service in our case for eg Phonepe, gpay)
// Beans are java objects maintained by Spring Container
// @Component annotation is used to create bean. any class can be used as a bean

/*
// Called "Constructor Dependency Injection" (most recommended method, explicitly states which bean is to be used as dependency)
//for beans way 1 is to create a constructer of the application class which takes an object of the bean as an input
    InternalWorkingOfSpringBootApplication(razorpayPaymentService paymentService) {
        this.paymentService = paymentService;
    }
    private razorpayPaymentService paymentService; //private final can be used to make the object uneditable in the future or in runtime or during compiletime


	//WAY 2: Second method to inject dependency is to use the @autowired annotation (most commonly used)
	@Autowired
	private razorpayPaymentService paymentService;
*/