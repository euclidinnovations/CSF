package com.euclid.csf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.euclid.csf.model.CSF;
import com.euclid.csf.model.CSFSaveData;
import com.euclid.persistence.Orders.model.CSFSave;
import com.euclid.persistence.Orders.model.ModifiedItem;
import com.euclid.persistence.Orders.model.OrderInstruction;
import com.euclid.persistence.Orders.service.CSFSaveService;
import com.euclid.persistence.Orders.service.CustomerService;
import com.euclid.persistence.Orders.service.ItemService;
import com.euclid.persistence.Orders.service.ModifiedItemService;
import com.euclid.persistence.Orders.service.OrderService;
import com.euclid.persistence.Orders.service.OrderInstructionService;
import com.euclid.persistence.Orders.service.OrderTotalService;
import com.euclid.persistence.Orders.service.OriginalOrderService;

 
@Controller
@RequestMapping("/csf")
public class CSFController{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView csfData(Map<String, Object> model, @RequestParam("orderid") String orderId) {
		// // System.out.println("Entered" + orderId);	
		CSFSaveData csfSaveData = new CSFSaveData();
		model.put("userForm", csfSaveData);
		//LoadData loadData = new LoadData();
		CSF csfRecievedData = new CSF();
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		OrderService ordService = (OrderService) context.getBean("orderService");
		HashMap<String, ArrayList<String>> modifiedItemsMapR =  new HashMap<String, ArrayList<String>>();
		
		if(ordService.exists(orderId)){
			csfRecievedData =  getDetails(orderId);
			// // System.out.println(csfRecievedData);
			CSFSaveService csfService = (CSFSaveService)context.getBean("csfSaveService");
			// // System.out.println("ORDER ID BEFORE CSF SERVICE "+orderId);
			if(csfService.exists(orderId)){
				// // System.out.println("In exicsf loop "+orderId);
				csfRecievedData.setBulkItems(csfService.findCSFSaveById(orderId).getBulkItems());
				csfRecievedData.setCallNotes(csfService.findCSFSaveById(orderId).getCallNotes());
				csfRecievedData.setCouponsRedeemed(csfService.findCSFSaveById(orderId).getCouponsRedeemed());
				csfRecievedData.setDeliveryPerson(csfService.findCSFSaveById(orderId).getDeliveryPerson());
				csfRecievedData.setDryGoods(csfService.findCSFSaveById(orderId).getDryGoods());
				csfRecievedData.setFloral(csfService.findCSFSaveById(orderId).getFloral());
				csfRecievedData.setFrozen(csfService.findCSFSaveById(orderId).getFrozen());
				csfRecievedData.setHot(csfService.findCSFSaveById(orderId).getHot());
				csfRecievedData.setPerishables(csfService.findCSFSaveById(orderId).getPerishables());
				csfRecievedData.setPersonalShopper(csfService.findCSFSaveById(orderId).getPersonalShopper());
				csfRecievedData.setReceived(csfService.findCSFSaveById(orderId).getReceived());
				csfRecievedData.setCheckID(csfService.findCSFSaveById(orderId).getCheckID());
				csfRecievedData.setCustomerCalled(csfService.findCSFSaveById(orderId).getCustomerCalled());
				csfRecievedData.setDob(csfService.findCSFSaveById(orderId).getDob());
				csfRecievedData.setDryGoodsSection(csfService.findCSFSaveById(orderId).getDryGoodsSection());
				csfRecievedData.setFloralSection(csfService.findCSFSaveById(orderId).getFloralSection());
				csfRecievedData.setFrozenSection(csfService.findCSFSaveById(orderId).getFrozenSection());
				csfRecievedData.setHotSection(csfService.findCSFSaveById(orderId).getHotSection());
				csfRecievedData.setPerishablesSection(csfService.findCSFSaveById(orderId).getPerishablesSection());
				csfRecievedData.setRX(csfService.findCSFSaveById(orderId).getRX());
				
				// // System.out.println("Modified Items in changed csf "+setModifiedMapItems(orderId));
			
				csfRecievedData.setModifiedItemsMap(setModifiedMapItems(orderId));
				if(ordService.getCompletedOrderIDS().contains(orderId)){
					// // System.out.println("The order Id: "+orderId+" and the exisiting completed orders "+ordService.getCompletedOrderIDS());
					HashMap<String,String> modfMap = getModifiedMapSaveData(orderId);
					csfRecievedData.setModSavedMap(modfMap);
					context.close();
					return new ModelAndView("views/Exicsf", "message", csfRecievedData);
				}
				context.close();
				return new ModelAndView("views/csf", "message", csfRecievedData);
			}
			// // System.out.println("Modified Items in changed csf "+setModifiedMapItems(orderId));
			csfRecievedData.setModifiedItemsMap(setModifiedMapItems(orderId));
			context.close(); 
			return new ModelAndView("views/csf", "message", csfRecievedData);
		}
		context.close();
		return new ModelAndView("views/Result", "message", csfRecievedData);
		
	}
	private HashMap<String, String> getModifiedMapSaveData(String orderId) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		ModifiedItemService modItemService = (ModifiedItemService)context.getBean("modifiedItemService");
		List<Object[]> rows=modItemService.getLookupItems(orderId);
		HashMap<String,String> modMap = new HashMap<String,String>();
		for (Object[] row: rows) {
			
			String itemOrdered = (String) row[0];
			String itemRecieved = (String) row[1];
			
			modMap.put(itemOrdered, itemRecieved);
		    
		}
		
		context.close();
		
		return modMap;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String  csfDataSave(@ModelAttribute("userForm")CSFSaveData csfdata, 
			 Map<String, Object> model){
		// // System.out.println("ORDER ID IN CSF SAVE DATA CONTROLLER ****");
		
		
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		CSFSaveService csfService = (CSFSaveService)context.getBean("csfSaveService");
		String orderid= csfdata.getOrderId().substring(0, 8);
		
		String PersonalShopper = null, DeliveryPerson = null, BulkItems = null,RX = null, CustomerCalled = null, CheckID= null,DOB= null;	
		
		if(csfService.exists(csfdata.getOrderId())){
			PersonalShopper = csfService.findCSFSaveById(orderid).getPersonalShopper();
			DeliveryPerson = csfService.findCSFSaveById(orderid).getDeliveryPerson();
			BulkItems = csfService.findCSFSaveById(orderid).getBulkItems();
			RX = csfService.findCSFSaveById(orderid).getRX();
			CustomerCalled =csfService.findCSFSaveById(orderid).getCustomerCalled();
		
			CheckID = csfService.findCSFSaveById(orderid).getCheckID();
			DOB = csfService.findCSFSaveById(orderid).getDob();
			csfService.deleteAll(orderid);
			
		}
		if(!(csfService.exists(csfdata.getOrderId()))){
			CSFSave csfSaveData = new CSFSave();
			csfSaveData.setOrderId(orderid);
			csfSaveData.setBulkItems(csfdata.getBulkItems());
			csfSaveData.setCallNotes(csfdata.getCallNotes());
			csfSaveData.setCouponsRedeemed(csfdata.getCouponsRedeemed());
			csfSaveData.setDryGoods(csfdata.getDryGoods());
			csfSaveData.setFloral(csfdata.getFloral());
			csfSaveData.setFrozen(csfdata.getFrozen());
			csfSaveData.setPerishables(csfdata.getPerishables());
		
			if(csfdata.getPersonalShopper().isEmpty()){
				csfSaveData.setPersonalShopper(PersonalShopper);
				}
			else{
				csfSaveData.setPersonalShopper(csfdata.getPersonalShopper());	
			}
			if(csfdata.getDeliveryPerson().isEmpty()){
				csfSaveData.setDeliveryPerson(DeliveryPerson);
				}
			else{
				csfSaveData.setDeliveryPerson(csfdata.getDeliveryPerson());	
			}
			if(csfdata.getBulkItems().isEmpty()){
				csfSaveData.setBulkItems(BulkItems);
				}
			else{
				csfSaveData.setBulkItems(csfdata.getBulkItems());	
			}
			if(csfdata.getRX().isEmpty()){
				csfSaveData.setRX(RX);
				}
			else{
				csfSaveData.setRX(csfdata.getRX());
			}
			if(csfdata.getCustomerCalled().isEmpty()){
				csfSaveData.setCustomerCalled(CustomerCalled);
				}
			else{
				csfSaveData.setCustomerCalled(csfdata.getCustomerCalled());
			}
			if(csfdata.getCheckID().isEmpty()){
				csfSaveData.setCheckID(CheckID);
				}
			else{
				csfSaveData.setCheckID(csfdata.getCheckID());
			}
			if(csfdata.getDob().isEmpty()){
				csfSaveData.setDob(DOB);
				}
			else{
				csfSaveData.setDob(csfdata.getDob());
			}
			
			
			csfSaveData.setReceived(csfdata.getReceived());
			csfSaveData.setPerishablesSection(csfdata.getPerishablesSection());
			csfSaveData.setDryGoodsSection(csfdata.getDryGoodsSection());
			csfSaveData.setFloralSection(csfdata.getFloralSection());
			csfSaveData.setFrozenSection(csfdata.getFrozenSection());
			csfSaveData.setHotSection(csfdata.getHotSection());
			csfSaveData.setHot(csfdata.getHot());
			
			csfService.persistCSFSave(csfSaveData);
		}
		
		HashMap<String,String> modifiedList = new HashMap<String,String>();
		modifiedList = getList(csfdata.getModifiedItems());
		setModifiedItems(modifiedList, orderid);
		OrderInstructionService orderInstructionService = (OrderInstructionService)context.getBean("orderInstructionService");
		OrderInstruction orderInstruction = new OrderInstruction();
		orderInstruction.setOrderId(orderid);
		orderInstruction.setPromotionCode(orderInstructionService.findOrderInstructionById(orderid).getPromotionCode());
		orderInstruction.setSpecialInstructions(orderInstructionService.findOrderInstructionById(orderid).getSpecialInstructions());
		orderInstruction.setSubstitution(orderInstructionService.findOrderInstructionById(orderid).getSubstitution());
		orderInstruction.setTotesUsed(orderInstructionService.findOrderInstructionById(orderid).getTotesUsed());
		orderInstruction.setVicSavings(orderInstructionService.findOrderInstructionById(orderid).getVicSavings());
		if(csfdata.getPaymentType() == null){
			orderInstruction.setPaymentMethod(orderInstructionService.findOrderInstructionById(orderid).getPaymentMethod());
		}else{
			orderInstruction.setPaymentMethod(csfdata.getPaymentType());
		}
		orderInstructionService.updateOrderInstruction(orderInstruction);
		context.close();
		return "views/order";
		
	}
	
	private void setModifiedItems(HashMap<String, String> modifiedList, String orderId) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		ModifiedItemService modItemService = (ModifiedItemService)context.getBean("modifiedItemService");
		ModifiedItem modItem = new ModifiedItem();
		modItemService.deleteAll(orderId);
		
		Iterator<Entry<String, String>> it = modifiedList.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        if(!(modItemService.exists(orderId + pair.getKey().toString()))){
	        	System.out.println(pair.getKey() + " = " + pair.getValue());
	        	modItem.setModId(orderId+pair.getKey().toString());
	        	modItem.setOrderId(orderId);
	        	modItem.setItemOrderedName(pair.getKey().toString());
	        	modItem.setItemRecievedName(pair.getValue().toString());
	        	modItemService.persistModifiedItem(modItem);
	        }
	        modItemService.updateMItem(orderId,pair.getKey().toString(),pair.getValue().toString());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		context.close();
	}
	private HashMap<String, String> getList(String modifiedItems) {
		// TODO Auto-generated method stub
		String[] splits = modifiedItems.split("_");
		HashMap<String,String> modMap = new HashMap<String,String>();
		
		int i=0;
		String key = null;
		for(String s : splits)
		    {
			
				if(i%2==0){
					key=s;
					
				}
				else{
					modMap.put(key, s);
				}
				i++;
		    }
		
		return modMap;
	}
	public HashMap<String, ArrayList<String>> setModifiedMapItems(String orderId){
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		ModifiedItemService modItemService = (ModifiedItemService)context.getBean("modifiedItemService");
		HashMap<String, ArrayList<String>> modifiedItemsMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> modifiedItemsMatch ;
		List<Object[]> rows = new ArrayList<Object[]>();
		rows = modItemService.getLookupItems(orderId);
		for (Object[] row: rows) {
			String itemOrdered = (String) row[0];
			String itemRecieved = (String) row[1];
			modifiedItemsMatch = new ArrayList<String>();
			
			if (itemRecieved != null && !itemRecieved.isEmpty()) {
				  modifiedItemsMatch.add(itemRecieved);
				}
			else{
				modifiedItemsMatch.add("No Item Substituted");
			}
			
			
			// System.out.println("ITem ORdered: "+itemOrdered);
			// System.out.println("Item Recieved: "+itemRecieved+ "ArraySize: "+modifiedItemsMatch.size());
			ArrayList<String> newlist = (ArrayList<String>) getOriginalOrderItemNames(orderId);
			
			newlist.retainAll(getModifiedItems(itemOrdered));
			// System.out.println("New List: "+newlist);
			modifiedItemsMatch.addAll(newlist);
			
			// System.out.println("New List: "+modifiedItemsMatch);
			modifiedItemsMap.put(itemOrdered, modifiedItemsMatch);
			// System.out.println("Modified Items Map: "+modifiedItemsMap);
			
		}
		context.close();
		return modifiedItemsMap;
		
	}
	public CSF getDetails(String orderId){
		//// System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		
		//// System.out.println(context);
		
		CustomerService cusService = (CustomerService) context.getBean("customerService");
		
		CSF csfdata = new CSF();
		
		// Get CustomerId with orderid
		OrderInstructionService ordInstService = (OrderInstructionService) context.getBean("orderInstructionService");
	//	// System.out.println(ordInstService);
		OrderService ordService = (OrderService) context.getBean("orderService");
		OrderTotalService ordTotService = (OrderTotalService)context.getBean("orderTotalService");
		ModifiedItemService modItemService = (ModifiedItemService)context.getBean("modifiedItemService");
		//CSFSaveService csfService = (CSFSaveService)context.getBean("csfSaveService");
		
		
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
		//// System.out.println("Orig Item List Names :"+origItemList);
		context.close();
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
			//// System.out.println("Mapped Strings "+mappedItemsList.toString() +" and size is "+mappedItemsList.size());
			
			
			
		}
		
		Set<String> mySet = new HashSet<String>(mappedItemsList);


		List<String> mappedItems = new ArrayList<String>(mySet);
		
		
		/*Iterator<String> iter = mappedItems.iterator();

		while (iter.hasNext()) {
		    String st = iter.next();

		    if (mappedItems.contains(itemOrdered))
		        iter.remove();
		}*/
			// // System.out.println("Mapped Items "+mappedItems);
			context.close();
		return mappedItems;
		
	}
}
