package com.euclid.Login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.euclid.persistence.Customer.model.Customer;
import com.euclid.persistence.Customer.service.CustomerService;
 
@Controller
public class LoginController extends MultiActionController{
		
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	   public String addLogin(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
	      
		 	System.out.println("load context");
		 	
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
			System.out.println(context);
			Customer cus = new Customer();
			cus.setCustomerId("123");
			cus.setFirstName("Madhuri");
			cus.setLastName("Atluri");
			cus.setPhone(123456789);
			cus.setAddress("VJA");
			cus.setEmail("matluri139@gmail.com");
			CustomerService cusService = (CustomerService) context.getBean("customerService");
			cusService.persistCustomer(cus);
			System.out.println("Updated phone :" + cusService.findCustomerById("123").getPhone());
			cus.setPhone(1230996);
			cusService.updateCustomer(cus);
			System.out.println("Updated phone :" + cusService.findCustomerById("123").getPhone());
			cusService.deleteCustomer(cus);
			context.close();
	      return "views/dashboard"; 
	   }
}
