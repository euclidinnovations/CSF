package com.euclid.csfcommunication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.euclid.persistence.Orders.service.CustomerService;
import com.euclid.persistence.Orders.service.OrderService;

@Controller
@RequestMapping("/sendEmail.do")
public class SendEmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(method = RequestMethod.POST)
	public String doSendEmail(HttpServletRequest request, @RequestParam("orderID") String orderID) {
		// takes input from e-mail form
		//String recipientAddress = "madhuri.atluri@euclidinnovations.com";
		String subject = "Thank you for shopping with Harris Teeter";
		
		
	    System.out.println("In EMail Controller:" + orderID);
		
	    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
	    CustomerService cusService = (CustomerService) context.getBean("customerService");
	    OrderService ordService = (OrderService) context.getBean("orderService");
	   
	    String recipientAddress = cusService.findCustomerById(ordService.findOrderById(orderID).getCustomerId()).getEmail();
	    String reciepientName = cusService.findCustomerById(ordService.findOrderById(orderID).getCustomerId()).getFirstName() +" " +
	    		cusService.findCustomerById(ordService.findOrderById(orderID).getCustomerId()).getLastName();
	    String message = "Dear "+ reciepientName + ", thank you for placing order. Your order number is "
                + orderID + "\n\t Please Find the Customer Statement Form in the attachment";
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		
		// sends the e-mail
		mailSender.send(email);
		context.close();
		// forwards to the view named "Result"
		return "views/order";
	}
}