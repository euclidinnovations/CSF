package com.euclid.csf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.euclid.csf.*;
import com.euclid.csf.model.CSF;
import com.euclid.dbSave.LoadData;
import com.euclid.persistence.Orders.model.ModifiedItem;
import com.euclid.persistence.Orders.service.CustomerService;
import com.euclid.persistence.Orders.service.ItemService;
import com.euclid.persistence.Orders.service.ModifiedItemService;
import com.euclid.persistence.Orders.service.OrderService;
import com.euclid.persistence.Orders.service.OrderInstructionService;
import com.euclid.persistence.Orders.service.OrderTotalService;

 
@Controller
public class CSFController{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@RequestMapping("/csf")
	public ModelAndView csfData(Map<String, Object> map, @RequestParam("orderid") String orderId) throws Exception {
		System.out.println("Entered" + orderId);	
		
		//LoadData loadData = new LoadData();
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	try {
							LoadData loadData = new LoadData();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        }, 
		        100000
		);
		
		CSF csfRecievedData = new CSF();
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		OrderService ordService = (OrderService) context.getBean("orderService");
		
		if(ordService.exists(orderId)){
			csfRecievedData =  getDetails(orderId);
			// System.out.println(csfRecievedData);
			 
			return new ModelAndView("views/csf", "message", csfRecievedData);
		}
		
	   
		return new ModelAndView("views/Result", "message", csfRecievedData);
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
		ModifiedItemService modItemService = (ModifiedItemService)context.getBean("modifiedItemService");
		ItemService itemService = (ItemService)context.getBean("itemService");
		
		
		
		csfdata.setOrderId(orderId);
		
		csfdata.setFirstName(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getFirstName());
		
		csfdata.setLastName(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getLastName());
		
		csfdata.setAddress(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getAddress());
		
		csfdata.setPhone(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getPhone());
		
		csfdata.setEmail(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getEmail());
		
		csfdata.setSpecialInstructions(ordInstService.findOrderInstructionById(orderId).getSpecialInstructions());
		
		csfdata.setPaymentType(ordInstService.findOrderInstructionById(orderId).getPaymentMethod());
		
		
		csfdata.setSubstitutionPolicy(ordInstService.findOrderInstructionById(orderId).getSubstitution());
		System.out.println(ordInstService.findOrderInstructionById(orderId).getPaymentMethod());
		
		HashMap<String, ArrayList<String>> modifiedItemsMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> modifiedItemsMatch ;
		List<Object[]> rows = new ArrayList<Object[]>();
		rows = modItemService.getLookupItems(orderId);
		for (Object[] row: rows) {
			
			
			System.out.println("id: " + row[0]);
			
			String itemOrdered = (String) row[0];
			
			String itemRecieved = (String) row[1];
			/*System.out.println("setup 1"+ itemService.findItemById((String) row[1]).getItemName());
			System.out.println("setup 2"+ itemService.findItemById(row[1].toString()).getItemName());*/
			modifiedItemsMatch = new ArrayList<String>();
			modifiedItemsMatch.add(itemRecieved);
			
		List<String[]> mappedItemsList = new ArrayList<String[]>();
		
		/*mappedItemsList = itemService.getMappedItems(itemOrdered, orderId);
		System.out.println("mapped item list "+mappedItemsList.get(0));
		for (String[] mapItem:mappedItemsList) {
			String item =(String) mapItem[0];
			System.out.println("ITEMMMMM "+item);
		}*/
		//modifiedItemsMatch.add(mappedItemsList.get(0).toString());
			
		//	modifiedItemsMatch.add(itemService.findItemById((String) row[1]).getItemName());
			modifiedItemsMap.put(itemOrdered, modifiedItemsMatch);
			//System.out.println("name: " + row[1]);	    
		    
		}
		System.out.println(modifiedItemsMap);
		//System.out.println(modifiedItemsMap);
		
		//csfdata.setModifiedItemsMap(modifiedItemsMap);
		//System.out.println(modifiedItemsMap);
		//lookupItems= modItemService.getLookupItems(orderId);
		
	//	System.out.println("LookupItems: "+lookupItems+ "CHekc is empty: "+lookupItems.isEmpty());
		
		//System.out.println("get item: "+lookupItems.size()+ "item:"+ lookupItems.get(0).toString());
	//	System.out.println("LookupItems:  "+ lookupItems.get(0) +"size: "+lookupItems.size());
		//modItemService.findModifiedItemById(orderId).
		csfdata.setModifiedItemsMap(modifiedItemsMap);
		csfdata.setOrderTotal(ordTotService.findOrderTotalById(orderId).getOrderTotal().toString());
	
		csfdata.setPickup(ordService.findOrderById(orderId).getPickup());
		//cusService.deleteCustomer(cus);
		context.close();
		return csfdata;
	}
}
