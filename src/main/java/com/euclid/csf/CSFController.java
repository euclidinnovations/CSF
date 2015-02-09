package com.euclid.csf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.euclid.csf.*;
import com.euclid.csf.model.CSF;
import com.euclid.persistence.Orders.service.CustomerService;
import com.euclid.persistence.Orders.service.OrderService;
import com.euclid.persistence.Orders.service.OrderInstructionService;
import com.euclid.persistence.Orders.service.OrderTotalService;

 
@Controller
public class CSFController{
		
	@RequestMapping("/login")
	public ModelAndView csfData(Map<String, Object> map) {
		System.out.println("Entered");
		String orderId = "12113737";
		CSF csfRecievedData = getDetails(orderId);
		
	    System.out.println(csfRecievedData.getEmail());
		
		return new ModelAndView("views/csf", "message", csfRecievedData);
	}
	
	public CSF getDetails(String orderId){
		System.out.println("load context");
	 	
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		System.out.println(context);
		
		CustomerService cusService = (CustomerService) context.getBean("customerService");
		
		CSF csfdata = new CSF();
		
		// Get CustomerId with orderid
		OrderInstructionService ordInstService = (OrderInstructionService) context.getBean("orderInstructionService");
		System.out.println(ordInstService);
		OrderService ordService = (OrderService) context.getBean("orderService");
		OrderTotalService ordTotService = (OrderTotalService)context.getBean("orderTotalService");
		
		ArrayList<String> itemOrderedList = new ArrayList<String>();
		ArrayList<String> itemRecievedList = new ArrayList<String>();
		
		csfdata.setOrderId(orderId);
		
		csfdata.setFirstName(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getFirstName());
		
		csfdata.setLastName(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getLastName());
		
		csfdata.setAddress(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getAddress());
		
		csfdata.setPhone(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getPhone());
		
		csfdata.setEmail(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getEmail());
		
		csfdata.setSpecialInstructions(ordInstService.findOrderInstructionById(orderId).getSpecialInstructions());
		
		csfdata.setPaymentType(ordInstService.findOrderInstructionById(orderId).getPaymentMethod());
		System.out.println(ordInstService.findOrderInstructionById(orderId).getPaymentMethod());
		csfdata.setItemOrdered(itemOrderedList);
		
		csfdata.setItemsRecieved(itemRecievedList);
		
		csfdata.setOrderTotal(ordTotService.findOrderTotalById(orderId).getOrderTotal().toString());
	
		csfdata.setPickup(ordService.findOrderById(orderId).getPickup());
		//cusService.deleteCustomer(cus);
		context.close();
		return csfdata;
	}
}
