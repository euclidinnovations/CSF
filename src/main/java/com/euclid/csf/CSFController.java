package com.euclid.csf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.euclid.persistence.Orders.service.OriginalOrderService;

 
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
		        10000
		);
		//LoadData loadData = new LoadData();
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
		//System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		
		//System.out.println(context);
		
		CustomerService cusService = (CustomerService) context.getBean("customerService");
		
		CSF csfdata = new CSF();
		
		// Get CustomerId with orderid
		OrderInstructionService ordInstService = (OrderInstructionService) context.getBean("orderInstructionService");
	//	System.out.println(ordInstService);
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
		
		csfdata.setVic(cusService.findCustomerById(ordService.findOrderById(orderId).getCustomerId()).getVic());
		
		csfdata.setSubstitutionPolicy(ordInstService.findOrderInstructionById(orderId).getSubstitution());
		csfdata.setVicSavings(ordInstService.findOrderInstructionById(orderId).getVicSavings());
		
		
		HashMap<String, ArrayList<String>> modifiedItemsMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> modifiedItemsMatch ;
		List<Object[]> rows = new ArrayList<Object[]>();
		rows = modItemService.getLookupItems(orderId);
		for (Object[] row: rows) {
			
			
			//System.out.println("id: " + row[0]);
			
			String itemOrdered = (String) row[0];
			
			
			String itemRecieved = (String) row[1];
			modifiedItemsMatch = new ArrayList<String>();
			modifiedItemsMatch.add(itemRecieved);
			ArrayList<String> newlist = (ArrayList<String>) getOriginalOrderItemNames(orderId);
			
		//	System.out.println("NEW LIST *** "+newlist);
			newlist.retainAll(getModifiedItems(itemOrdered));
			modifiedItemsMatch.addAll(newlist);
			List<String[]> mappedItemsList = new ArrayList<String[]>();		
			modifiedItemsMap.put(itemOrdered, modifiedItemsMatch);
		    
		}
		csfdata.setModifiedItemsMap(modifiedItemsMap);
		csfdata.setOrderTotal(ordTotService.findOrderTotalById(orderId).getOrderTotal().toString());
	
		csfdata.setPickup(ordService.findOrderById(orderId).getPickup());
		context.close();
		return csfdata;
	}

	private ArrayList<String> getOriginalOrderItemNames(String orderId) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		ItemService itemService = (ItemService)context.getBean("itemService");
		OriginalOrderService orgOrderService = (OriginalOrderService)context.getBean("originalOrderService");
		List<String> origList = new ArrayList<String>();
		origList = orgOrderService.getAllOriginalItemSKUs(orderId);
		ArrayList<String> origItemList = new ArrayList<String>();
		for(String s: origList){
			origItemList.add(itemService.findItemById(s).getItemName());
		}
		//System.out.println("Orig Item List Names :"+origItemList);
		return origItemList;
	}

	private List<String> getModifiedItems(String itemOrdered) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		ItemService itemService = (ItemService)context.getBean("itemService");
		String str = itemOrdered;
		String[] splitStrings = str.split("\\s+");
		List<String> mappedItemsList = new ArrayList<String>();
		for(String s:splitStrings){
			
			if(!(s.equalsIgnoreCase("-") || s.equalsIgnoreCase("and") || s.equalsIgnoreCase("or") || s.equalsIgnoreCase("per") || s.equalsIgnoreCase("a")|| s.equalsIgnoreCase("b") || s.equalsIgnoreCase("c") || s.equalsIgnoreCase("d") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("f") || s.equalsIgnoreCase("g") || s.equalsIgnoreCase("h") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("j") || s.equalsIgnoreCase("k") || s.equalsIgnoreCase("l") || s.equalsIgnoreCase("m") || s.equalsIgnoreCase("n") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("p") || s.equalsIgnoreCase("q") || s.equalsIgnoreCase("r") || s.equalsIgnoreCase("s") || s.equalsIgnoreCase("t") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("v") || s.equalsIgnoreCase("w") || s.equalsIgnoreCase("x") || s.equalsIgnoreCase("y") || s.equalsIgnoreCase("z"))){
			List<String> mappedStrings = itemService.getMappedItems(s);
			mappedItemsList.addAll(mappedStrings);
			}
			//System.out.println("Mapped Strings "+mappedItemsList.toString() +" and size is "+mappedItemsList.size());
			
			
			
		}
		
		Set<String> mySet = new HashSet<String>(mappedItemsList);


		List<String> mappedItems = new ArrayList<String>(mySet);
		for(String strItmOrdered:mappedItems){
			if(mappedItems.contains(strItmOrdered)){
				mappedItems.remove(strItmOrdered);
			}
		}

		return mappedItems;
		
	}
}
