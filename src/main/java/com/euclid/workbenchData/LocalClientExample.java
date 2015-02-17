package com.euclid.workbenchData;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
 












import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.euclid.persistence.Orders.model.Customer;
import com.euclid.persistence.Orders.model.Item;
import com.euclid.persistence.Orders.model.ModifiedItem;
import com.euclid.persistence.Orders.model.Order;
import com.euclid.persistence.Orders.model.OrderInstruction;
import com.euclid.persistence.Orders.model.OrderTotal;
import com.euclid.persistence.Orders.model.OriginalOrder;
import com.euclid.persistence.Orders.service.CustomerService;
import com.euclid.persistence.Orders.service.ItemService;
import com.euclid.persistence.Orders.service.ModifiedItemService;
import com.euclid.persistence.Orders.service.OrderInstructionService;
import com.euclid.persistence.Orders.service.OrderService;
import com.euclid.persistence.Orders.service.OrderTotalService;
import com.euclid.persistence.Orders.service.OriginalOrderService;

public class LocalClientExample extends WriteExcel {
 
  private String cookies;
  private HttpClient client = HttpClientBuilder.create().build();
  private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36";
 
  public void getLocalClientExample() throws Exception {
 
	String url = "https://wb2.harristeeter.com/Login.aspx";
	String wg = "https://wb2.harristeeter.com/StoreMenu.aspx?dayspassexp=61";
	String current_pending = "https://wb2.harristeeter.com/default.asp?View=NewPending";
	String uncommited = "https://wb2.harristeeter.com/default.asp?View=Future";		
 
	// make sure cookies is turn on
	//CookieHandler.setDefault(new CookieManager());
 
	LocalClientExample http = new LocalClientExample();
 
	
	
	//Find out the orderIDs
	http.FindOrderIDs("hi");	
	
	
  }
 
  private void sendPost(String url, List<NameValuePair> postParams) 
        throws Exception {
 
	HttpPost post = new HttpPost(url);
 
	// add header
	post.setHeader("Host", "wb2.harristeeter.com");
	post.setHeader("User-Agent", USER_AGENT);
	post.setHeader("Accept", 
             "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	post.setHeader("Accept-Language", "en-US,en;q=0.8");
	post.setHeader("Cookie", getCookies());
	post.setHeader("Connection", "keep-alive");
	post.setHeader("Referer", "https://wb2.harristeeter.com/Login.aspx");
	post.setHeader("Content-Type", "application/x-www-form-urlencoded");
 
	post.setEntity(new UrlEncodedFormEntity(postParams));
 
	HttpResponse response = client.execute(post);
 
	int responseCode = response.getStatusLine().getStatusCode();
 
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + postParams);
	System.out.println("Response Code : " + responseCode);
 
	BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
 
	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
 
	System.out.println(result.toString());
 
  }
 
  private String GetPageContent(String url) throws Exception {
 
	HttpGet request = new HttpGet(url);
 
	request.setHeader("User-Agent", USER_AGENT);
	request.setHeader("Accept",
		"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	request.setHeader("Accept-Language", "en-US,en;q=0.5");
 
	HttpResponse response = client.execute(request);
	int responseCode = response.getStatusLine().getStatusCode();
 
	System.out.println("\nSending 'GET' request to URL : " + url);
	System.out.println("Response Code : " + responseCode);
 
	BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
 
	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
 
	// set cookies
	setCookies(response.getFirstHeader("Set-Cookie") == null ? "" : 
                     response.getFirstHeader("Set-Cookie").toString());
 
	return result.toString();
 
  }
 
  public List<NameValuePair> getFormParams(
             String html, String username, String password)
			throws UnsupportedEncodingException {
 
	System.out.println("Extracting form's data...");
 
	Document doc = Jsoup.parse(html);
	
	List<NameValuePair> paramList = new ArrayList<NameValuePair>();
	
	// Google form id
	/*Element loginform = doc.getElementById("gaia_loginform");
	Elements inputElements = loginform.getElementsByTag("input");
 
	List<NameValuePair> paramList = new ArrayList<NameValuePair>();
 
	for (Element inputElement : inputElements) {
		String key = inputElement.attr("name");
		String value = inputElement.attr("value");
 
		if (key.equals("Email"))
			value = username;
		else if (key.equals("Passwd"))
			value = password;
		
		paramList.add(new BasicNameValuePair(key, value));
 
	}*/
	paramList.add(new BasicNameValuePair("hdnLoginPostBack", "1"));
	paramList.add(new BasicNameValuePair("txtUsername", "hteeter"));
	paramList.add(new BasicNameValuePair("txtPassword", "Shop001"));
	paramList.add(new BasicNameValuePair("btnLogin", "Login"));
	
	
	return paramList;
  }
 
  public String getCookies() {
	return cookies;
  }
 
  public void setCookies(String cookies) {
	this.cookies = cookies;
  }
  
  public StringBuffer GetHtml(){
  	URL url;
    InputStream is = null;
    BufferedReader br;
    String line = null;
    StringBuffer result = new StringBuffer();
    
    try {
        url = new URL("https://wb2.harristeeter.com/StoreMenu.aspx?dayspassexp=61");
        is = url.openStream();  // throws an IOException
        br = new BufferedReader(new InputStreamReader(is));

        
    	
    	while ((line = br.readLine()) != null) {
    		result.append(line);
    	}        
        
        
    } catch (MalformedURLException mue) {
         mue.printStackTrace();
    } catch (IOException ioe) {
         ioe.printStackTrace();
    } finally {
        try {
        	
            if (is != null) is.close();
        } catch (IOException ioe) {
            // nothing to see here
        }
    }
	return result;
	  
  }
  
  public void WriteExcelFile(String str, String name) throws IOException, WriteException {
		WriteExcel test = new WriteExcel();
	    test.setOutputFile("c:/temp/"+name+".xls");
	    test.write(str);
	    System.out
	        .println("Please check the result file under c:/temp/ ");
  }
  
  public void FindOrderIDs(String html) throws Exception{
	int j = 0; int k = 0;  	
	
	ArrayList<String> orderIDarr = new ArrayList<String>();
	String getOrderIDString = "OrderDetail(";
	
	File folder = new File("c:/temp");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        
        String Fname = listOfFiles[i].getName();
        if (Fname.indexOf(".") > 0)
        	Fname = Fname.substring(0, Fname.lastIndexOf("."));
        
	        //System.out.println("File " + Fname);
	        if(Fname.toLowerCase().contains("_order")){	//If is contains "customer" it will not in 
		        // It will get order details HTML from the local system
		        ReadExcel read = new ReadExcel();
		        read.setInputFile("c:/temp/"+Fname+".xls");
		        String orderID	=	Fname.replace("_order", "");
		    	String htmlPage = read.read("LOCAL");	
		    	String orderDetailsHTML	=	htmlPage;
		    	
		    	// It will get customer details HTML from the local system		    	
		    	read.setInputFile("c:/temp/"+orderID+"_exceptionreport.xls");
		    	String exceptionReportHTML = read.read("LOCAL");		    	
		    	//System.out.println("File " + exceptionReportHTML);
		    	
		    	// It will get customer details HTML from the local system
		    	String custID			=	orderCustomerID(htmlPage).trim();
		    	read.setInputFile("c:/temp/"+custID+"_customer.xls");
		    	String custDetailsHTML = read.read("LOCAL");		    	
		    	//System.out.println("File " + htmlPage);
		    	
		    	String fName	=	custFirstname(custDetailsHTML);
		    	String lName	=	custLastname(custDetailsHTML);
		    	
		    	String add1		=	custAddress1(custDetailsHTML);
		    	String add2		=	custAddress2(custDetailsHTML);
		    	String city		=	custCity(custDetailsHTML);
		    	String state	=	custState(custDetailsHTML);
		    	String zip		=	custZip(custDetailsHTML);
		    	String phone	=	custPhone(custDetailsHTML);
		    	
		    	String address	=	add1+" "+add2+" "+city+" "+state+" "+zip+" "+phone;
		    	
		    	String customerID	=	orderCustomerID(htmlPage).trim();
		    	String email		=	orderEmail(htmlPage);
		    	
		    	
		    	
		    	//System.out.println("\nMap : "+customersMap);
		    	String datetine	=	orderDateTime(htmlPage);
		    	String billadd	=	orderBillAddress(htmlPage);
		    	
		    	String substitution	=	orderSubstitution(htmlPage);
		    	String fullfilment	=	orderFulfillment(htmlPage);
		    	fullfilment			=	fullfilment.replace("Pickup -", "").trim();		    			   		    	
		    	String specialinst	=	orderSpecialInstructions(htmlPage);
		    	String paymethod	=	orderPaymentMethod(htmlPage);
		    	
		    	String totesused	=	orderTotesUsed(htmlPage);
		    	String promotioncode=	orderPromotionCode(htmlPage);
		    	String prdtotal		=	orderProductTotal(htmlPage);
		    	String diposit		=	orderDiposit(htmlPage);
		    	
		    	String taxtotal		=	orderTaxTotal(htmlPage);
		    	String discountcharge	=	orderDiscountCharge(htmlPage);
		    	String servicefee	=	orderServiceFee(htmlPage);
		    	
		    	String specialpromotion	=	orderSpecialPromotions(htmlPage);
		    	
		    	String addcharges		=	orderAdditionalCharges(htmlPage);
		    	String ordertotal		=	orderTotal(htmlPage);
		    	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		    	CustomerService cusService = (CustomerService) context.getBean("customerService");
		    	
		    	if(!cusService.exists(customerID)){
		    		System.out.println("cusID ********* inside"+customerID);
				    	Customer cus = new Customer();
						cus.setCustomerId(customerID);
						cus.setFirstName(fName);
						cus.setLastName(lName);
						cus.setPhone(phone);
						cus.setAddress(address);
						cus.setEmail(email);						
						cusService.persistCustomer(cus);
		    	}
		    	/* -- Customers Table End*/
		    	/*---------------------------------------*/
		    	
		    	/*Orders Map*/
		    	/*List<String> ordersArr  = new ArrayList<String>(); 
		    	ordersArr.add(customerID);
		    	ordersArr.add(fullfilment);*/
		    	/*HashMap ordersMap  = new HashMap();
		    	ordersMap.put(orderID, ordersArr);*/
		    	
		    	OrderService ordService = (OrderService) context.getBean("orderService");
		    	//ordService.deleteAll();
		    	if(!ordService.exists(orderID)){
				    	Order ord = new Order();
				    	ord.setCustomerId(customerID);
				    	ord.setOrderId(orderID);
				    	ord.setPickup(fullfilment);
				    	ordService.persistOrder(ord);
		    	}
		    	/*---------------------------------------*/
		    			    	
		    	/*OrderInstructions Map*/
		    	/*List<String> orderInstructionsArr   = new ArrayList<String>(); 
		    	orderInstructionsArr.add(substitution);
		    	orderInstructionsArr.add(specialinst);
		    	orderInstructionsArr.add(paymethod);
		    	orderInstructionsArr.add(totesused);
		    	orderInstructionsArr.add(promotioncode);*/		    	
		    	/*HashMap orderInstructionsMap  = new HashMap();
		    	orderInstructionsMap.put(orderID, orderInstructionsArr);*/
		    	
		    	OrderInstructionService ordInstService = (OrderInstructionService) context.getBean("orderInstructionService") ;
		    	if(!ordInstService.exists(orderID)){
			    	OrderInstruction ordInst = new OrderInstruction();
			    //	ordInstService.deleteAll();
			    	ordInst.setOrderId(orderID);
			    	ordInst.setPaymentMethod(paymethod);
			    	ordInst.setPromotionCode(promotioncode);
			    	ordInst.setSpecialInstructions(specialinst);
			    	ordInst.setSubstitution(substitution);
			    	ordInst.setTotesUsed(totesused);
			    	
			    	ordInstService.persistOrderInstruction(ordInst);
		    	}
		    	/*---------------------------------------*/
		    	
		    	/*orderTotals Map*/
		   /* 	List<String> orderTotalsArr   = new ArrayList<String>(); 
		    	orderTotalsArr.add(prdtotal);
		    	orderTotalsArr.add(taxtotal);
		    	orderTotalsArr.add(servicefee);
		    	orderTotalsArr.add(addcharges);
		    	orderTotalsArr.add(diposit);
		    	orderTotalsArr.add(discountcharge);
		    	orderTotalsArr.add(specialpromotion);
		    	orderTotalsArr.add(ordertotal);
		    	*/
		    	OrderTotalService ordTotService = (OrderTotalService) context.getBean("orderTotalService");
		    	
		    	if(!ordTotService.exists(orderID)){
				    	OrderTotal ordTotal = new OrderTotal();
				    	//ordTotService.deleteAll();
				    	
				    	ordTotal.setOrderId(orderID);
				    	ordTotal.setAdditionalCharges(addcharges);
				    	ordTotal.setDeposit(diposit);
				    	ordTotal.setDiscount(discountcharge);
				    	ordTotal.setOrderTotal(ordertotal);
				    	ordTotal.setProductTotal(prdtotal);
				    	ordTotal.setServiceFee(servicefee);
				    	ordTotal.setSpecialPromotions(specialpromotion);
				    	ordTotal.setTaxTotal(taxtotal);
				    	
				    	ordTotService.persistOrderTotal(ordTotal);
		    	}
		    	/*
		    	HashMap orderTotalsMap  = new HashMap();
		    	orderTotalsMap.put(orderID, orderTotalsArr);
		    	/*---------------------------------------*/
		    	
		    	
		    	/*Get data from the exceptiona report*/
		    	//exceptionReportHTML
		    	
/*Get data from the exceptiona report*/
		    	getModifiedItems(exceptionReportHTML,orderID);
		    	
		    	OriginalOrderService origOrderService = (OriginalOrderService) context.getBean("originalOrderService");
		    	OriginalOrder origOrder = new OriginalOrder();
		    	
		    	ItemService itemService = (ItemService) context.getBean("itemService");
		    	Item itm = new Item();
		    	
		    	ModifiedItemService modItemService = (ModifiedItemService) context.getBean("modifiedItemService");
		    	ModifiedItem modItem = new ModifiedItem();
		    	
		    	
		    	List<String> sublist = new ArrayList<String>(); 
		    	
		    	HashMap allOrdersMap  		= new HashMap();
		    	HashMap originalOrderMap  	= new HashMap();
		    	HashMap currentOrderMap  	= new HashMap();
		    	
		    	List<String> originalOrderGetItemsCount = originalOrderGetItemsCount(htmlPage); 		    	
		    	List<String> allOrdersSKU = originalOrderSKU(htmlPage); 		    		    	
		    	
		    	
		    	//System.out.println("\nHTML PAGE:\n"+htmlPage);		 
		    	List<String> originalOrderArray = originalOrder(htmlPage);
		    //	System.out.println("\nOder Array:\n"+originalOrderArray);
		    	
		    	//System.exit(1);
		    	int x = 0;
		    	for (int start = 0; start < originalOrderArray.size(); start += 8) {
                    String ProductSKU = null;
		            int end = Math.min(start + 8, originalOrderArray.size());
		            sublist = originalOrderArray.subList(start, end);        
		            
		          //  System.out.println("\nIN Sublist:\n"+sublist+"\nORDER NO:"+orderID);		            
		            
		            if(x < Integer.parseInt(originalOrderGetItemsCount.get(0))){                
		                    ProductSKU        =        allOrdersSKU.get(x);
		                    //System.out.println("\nOriginal:x-"+x+":SKU-"+ProductSKU+"\n");                                    
		                    originalOrderMap.put(orderID, allOrdersSKU.get(x));
		                    
		                    String sku =  allOrdersSKU.get(x).replaceAll("\\s","");
		                    origOrder.setSKU(sku);
		                    itm.setSKU(sku);
		                    originalOrderMap.put(orderID,sublist); // This is the original order
		                    origOrder.setOrderId(orderID);
		                    int temp=0;
		                    for(String eachItem:sublist){
		                    	System.out.println("IN Sublist: "+eachItem);
		                    	temp++;
		                    	switch(temp){
		                    		case 1:
		                    			itm.setAisle(eachItem);
		                    			break;
		                    		case 2:
		                    			origOrder.setQty(eachItem);
		                    			break;
		                    		case 3:
		                    			itm.setItemName(eachItem);
		                    			itm.setDescription(eachItem);
		                    			break;
		                    		case 4:
		                    			origOrder.setSize(eachItem);
		                    			break;
		                    		case 5:
		                    			itm.setUnitPrice(eachItem);
		                    			break;
		                    		case 6:
		                    		//	System.out.println("tax "+eachItem);
		                    			break;
		                    		case 7:
		                    		//	System.out.println("dep "+eachItem);
		                    			break;
		                    		case 8:
		                    		//	System.out.println("Item Original/Substituted" + eachItem);
		                    			break;
		                    		
		                    		default:
		                    			//System.out.println("List Messed up");
		                    			break;
		                    	}
		                    	
		                    }
		                    
		                  //  System.out.println(originalOrderMap);
		                    if(!origOrderService.exists(orderID,sku)){
			                    origOrderService.persistOriginalOrder(origOrder);
		                    }
		                    
		                    if(!itemService.exists(sku)){
			                    itemService.persistItem(itm);
		                    }
		            }
		            else {                            
		                    ProductSKU        =        allOrdersSKU.get(x);
		                    
		                    
		                    //System.out.println("\nCurrent-"+x+":SKU-"+ProductSKU+"\n");                                            
		                    currentOrderMap.put(orderID, allOrdersSKU.get(x));
		                    currentOrderMap.put(orderID,sublist);
		                    
		                    int temp=0;
		                    String Aisle= null,Qty= null,Name= null,Description= null,size= null,unitPrice = null;
		                    for(String eachItem:sublist){
		                    	System.out.println("IN Sublist: "+eachItem);
		                    	temp++;
		                    	switch(temp){
		                    		case 1:
		                    			Aisle = eachItem;
		                    			break;
		                    		case 2:
		                    			Qty = eachItem;
		                    			break;
		                    		case 3:
		                    			Name = eachItem;
		                    			Description = eachItem;
		                    			break;
		                    		case 4:
		                    			size = eachItem;
		                    			break;
		                    		case 5:
		                    			unitPrice = eachItem;
		                    			break;
		                    		case 6:
		                    		//	System.out.println("tax "+eachItem);
		                    			break;
		                    		case 7:
		                    		//	System.out.println("dep "+eachItem);
		                    			break;
		                    		case 8:
		                    		//	System.out.println("Item Original/Substituted" + eachItem);                  			
		                    			
		                    			break;
		                    		
		                    		default:
		                    			break;
		                    	}
		                    	if(!eachItem.equalsIgnoreCase("Orig.")){
                    				if(!itemService.exists(ProductSKU)){
	                    				itm.setAisle(Aisle);
	                    				itm.setDescription(Description);
	                    				itm.setItemName(Name);
	                    				itm.setsize(size);
	                    				itm.setSKU(ProductSKU);
	                    				itm.setUnitPrice(unitPrice);
	                    				itemService.persistItem(itm);
                    				}
		                    	} 
		                    }
		                    
		                 //   System.out.println(currentOrderMap);
		            }
		            x++;
		            
		        }

	        }
        
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
      //if else ends /* (listOfFiles[i].isFile()) {
    }
  }

  public void getModifiedItems(String str, String orderID){
		//str 	= str.replaceAll("\\s+","");
	  	//System.out.println(newstr);
		System.out.println("in Modified");
		
		List<String> OrderedArray = new ArrayList<String>();  
		List<String> ReceivedArray = new ArrayList<String>();  
		//Pattern pattern = Pattern.compile("javascript:ShowDetail(.*?);'><spanstyle"); //SKU
		Pattern pattern = Pattern.compile("<td>Ordered:</td>(.*?)</tr>"); //SKU
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {    
			String value	= matcher.group(1);		
			Pattern modifiedPattern = Pattern.compile("<td>(.*?)</td>"); //SKU
			Matcher modifiedMatcher = modifiedPattern.matcher(value);
			while (modifiedMatcher.find()) {
				String ModifiedData	= modifiedMatcher.group(1);
				//System.out.println(ModifiedData+"__");
				OrderedArray.add(html2text(ModifiedData));
			}		
		}	
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		ModifiedItemService modItemService = (ModifiedItemService) context.getBean("modifiedItemService");
		ModifiedItem modItem = new ModifiedItem();
		HashMap OrderedItemsMap  	= new HashMap();
		Pattern ReceivedPattern = Pattern.compile("<td>Received:</td>(.*?)</tr>"); //SKU
		Matcher Receivedmatcher = ReceivedPattern.matcher(str);
		while (Receivedmatcher.find()) {    			
			String ReceivedValue	= Receivedmatcher.group(1);		
			Pattern ReceivedString = Pattern.compile("<td>(.*?)</td>"); //SKU
			Matcher ReceivedMatcher = ReceivedString.matcher(ReceivedValue);
			while (ReceivedMatcher.find()) {  
				String ReceivedData	= ReceivedMatcher.group(1);
				//System.out.println(ReceivedData+"__");
				ReceivedArray.add(html2text(ReceivedData));
			}		
			OrderedItemsMap.put(orderID, ReceivedArray);
		}
		
		//System.out.println(OrderedArray);
		//System.out.println(ReceivedArray);
		//System.out.println(OrderedItemsMap);
		
		modItem.setOrderId(orderID);
		List<String> sublist = new ArrayList<String>();
		List<String> Received = new ArrayList<String>();
		for (int start = 0; start < OrderedArray.size(); start += 4) {		
	        int end = Math.min(start + 4, OrderedArray.size());
	        
	        sublist = OrderedArray.subList(start, end);
	        System.out.println(sublist);
	        int x =0;
	        String itemOrdered= null;
	        
	         
	        int rlist = 0;
	        Received = ReceivedArray.subList(start, end);
	        for(String eachItem:sublist){
	        	x++;
	        	switch(x){
	        	case 1: 
	        		modItem.setItemOrderedSKU(eachItem);
	        		System.out.println("in modifiedItem table" +modItem.getItemOrderedSKU());
	        		itemOrdered = eachItem;
	        		break;
	        	case 2:
	        		modItem.setItemOrderedQty(eachItem);
	        		break;
	        	case 3:
	        		modItem.setItemOrderedName(eachItem);        		
	        		break;
	        	case 4:
	        		modItem.setItemOrderedSize(eachItem);
	        	default: 
	        		if(x>4){x=0;}
	        		break;
	        	}        	
	        }
	        for(String eachItem:Received){
	        	rlist++;
	        	switch(rlist){
	        	case 1:
	        		modItem.setItemRecievedSKU(eachItem);
	        		break;
	        	case 2:
	        		modItem.setItemRecievedQty(eachItem);
	        		break;
	        	case 3:
	        		modItem.setItemRecievedName(eachItem);
	        		break;
	        	case 4:
	        		modItem.setItemRecievedSize(eachItem);
	        		break;
	        	default:
	        		if(rlist>4){rlist=0;}
	        		break;
	        	}
	        }
	        
	        if(!modItemService.exists(orderID, itemOrdered)){
	        	modItemService.persistModifiedItem(modItem);
	        }
	        System.out.println(Received);
	        
	        
		}
	    //return custArray;
	}
  
public List<String> currentOrder(String str){
	  /*Has all the td of the order details page*/
		  	//String newstr 	= str.replaceAll("\\s+","");
		  	System.out.println(str);
			List<String> custArray = new ArrayList<String>();  
			//Pattern pattern = Pattern.compile("javascript:ShowDetail(.*?);'><spanstyle"); //SKU
			Pattern pattern = Pattern.compile("Current Order(.*?)</TD>");
			
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()) {    
				
				String value	= html2text(matcher.group(1)).trim();
				//value	=	value.replace("(\"", "");
				//value	=	value.replace("\")", "");
				//System.out.println("\n"+value);
			    custArray.add(value);
			}	  	
			//After 8 it will break to new product
			System.out.println(custArray);
		    return custArray;	   
		  }

public List<String> originalOrderGetItemsCount(String str){
  	String newstr 	= str.replaceAll("\\s+","");
  	//System.out.println(str);
	List<String> custArray = new ArrayList<String>();  	
	Pattern pattern = Pattern.compile("<Bstyle='color:blue;'>(.*?)</B>");
	Matcher matcher = pattern.matcher(newstr);		
	while (matcher.find()) {    			
		String value	= html2text(matcher.group(1)).trim();		
		value	=	value.replace("items", "");
		//System.out.println("\n"+value);
	    custArray.add(value);
	}	  	
	//After 8 it will break to new product
	//System.out.println(custArray);
    return custArray;
}

public List<String> originalOrder(String str){
  /*Has all the td of the order details page*/
	  	//String newstr 	= str.replaceAll("\\s+","");
	  	//System.out.println(str);
		List<String> custArray = new ArrayList<String>();  
		//Pattern pattern = Pattern.compile("javascript:ShowDetail(.*?);'><spanstyle"); //SKU
		//Pattern pattern = Pattern.compile("class='pl'>(.*?)</TD>"); // All the order
		
		Pattern pattern = Pattern.compile("class='pl'>(.*?)</TD>");
		Matcher matcher = pattern.matcher(str);		
		while (matcher.find()) {    			
			String value	= html2text(matcher.group(1)).trim();
			
			//value	=	value.replace("\")", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  	
		//After 8 it will break to new product
		//System.out.println(custArray);
	    return custArray;	   
	  }  
  
  public List<String> originalOrderSKU(String str){
	  	String newstr 	= str.replaceAll("\\s+","");
	  	//System.out.println(newstr);
		List<String> custArray = new ArrayList<String>();  
		//Pattern pattern = Pattern.compile("javascript:ShowDetail(.*?);'><spanstyle"); //SKU
		Pattern pattern = Pattern.compile("class='pl'align='right'(.*?)</td>"); //SKU
		Matcher matcher = pattern.matcher(newstr);
		while (matcher.find()) {    			
			String value	= html2text(matcher.group(1)).trim();
			value	=	value.replace(">", "");
			//value	=	value.replace("&nbsp", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  			
		//System.out.println(custArray);
	    return custArray;	   
	  } 

 public String custFirstname(String str){
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("name=\"bFirstName\"(.*?)disabled=\"disabled\"/>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {    
		String value	= html2text(matcher.group(1)).trim();
		value	=	value.replace("value=\"", "");
		value	=	value.replace("\"", "");
		//System.out.println("\n"+value);
	    custArray.add(value);
	}	  	
	//System.out.println(custArray);
    return custArray.get(0);	   
  }  
  
  public String custLastname(String str){
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("name=\"bLastName\"(.*?)disabled=\"disabled\"/>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {    
			String value	= html2text(matcher.group(1)).trim();
			value	=	value.replace("value=\"", "");
			value	=	value.replace("\"", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  	
		//System.out.println(custArray);
	    return custArray.get(0);	   
	  }  
	  
  
  public String custAddress1(String str){
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("name=\"bAddress1\"(.*?)disabled=\"disabled\"/>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {    
		String value	= html2text(matcher.group(1)).trim();
		value	=	value.replace("value=\"", "");
		value	=	value.replace("\"", "");
		//System.out.println("\n"+value);
	    custArray.add(value);
	}	  	
	//System.out.println(custArray);
    return custArray.get(0);	   
  }

  public String custAddress2(String str){
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("name=\"bAddress2\"(.*?)disabled=\"disabled\"/>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {    
			String value	= html2text(matcher.group(1)).trim();
			value	=	value.replace("value=\"", "");
			value	=	value.replace("\"", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  	
		//System.out.println(custArray);
	    return custArray.get(0);	   
	  }

  public String custCity(String str){
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("name=\"bCity\"(.*?)disabled=\"disabled\"/>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {    
			String value	= html2text(matcher.group(1)).trim();
			value	=	value.replace("value=\"", "");
			value	=	value.replace("\"", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  	
		//System.out.println(custArray);
	    return custArray.get(0);	   
	  }
  
  public String custZip(String str){
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("name=\"bZip\"(.*?)disabled=\"disabled\"/>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {    
			String value	= html2text(matcher.group(1)).trim();
			value	=	value.replace("value=\"", "");
			value	=	value.replace("\"", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  	
		//System.out.println(custArray);
	    return custArray.get(0);	   
	  }

  public String custPhone(String str){
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("name=\"bPhone\"(.*?)disabled=\"disabled\"/>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {    
			String value	= html2text(matcher.group(1)).trim();
			value	=	value.replace("value=\"", "");
			value	=	value.replace("\"", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  	
		//System.out.println(custArray);
	    return custArray.get(0);	   
	  }

  
  
  public String custState(String str){
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("name=\"bState\"(.*?)disabled=\"disabled\"/>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {    
			String value	= html2text(matcher.group(1)).trim();
			value	=	value.replace("value=\"", "");
			value	=	value.replace("\"", "");
			//System.out.println("\n"+value);
		    custArray.add(value);
		}	  	
		//System.out.println(custArray);
	    return custArray.get(0);	   
	  }

  
  public String orderDateTime(String str){
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("normal;'>(.*?)</b>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {    
		String value	= html2text(matcher.group(1));	
	    custArray.add(value);
	}	  	
    return custArray.get(0);	   
  }

  public String orderBillAddress(String str){
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("Address</b>(.*?)</table>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) { 		
		String value	= html2text(matcher.group(1));			
	    custArray.add(value);
	}	  		
    return custArray.get(0);	   
  }
  
  public String orderCustomerID(String str){
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("align='center'>(.*?)</td>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {    
	    custArray.add(matcher.group(1));
	}	  	
    return custArray.get(0);	   
  }
  
  public String orderEmail(String str){
	
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("<u>(.*?)</u></a>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {
		String value	=	html2text(matcher.group(1));	    
	    custArray.add(value);
	}	  	
	
    return custArray.get(0);	   
  }
  
  public String orderSubstitution(String str){
	
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("Substitution:</td>(.*?)</td>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {
		String value	=	html2text(matcher.group(1));	    
	    custArray.add(value);
	}	  	
	
    return custArray.get(0);	   
  }  
  
  public String orderFulfillment(String str){
	
	List<String> custArray = new ArrayList<String>();  
	Pattern pattern = Pattern.compile("Fulfillment:</td>(.*?)</td>");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {
		String value	=	html2text(matcher.group(1));	    
	    custArray.add(value);
	}	  	
	
    return custArray.get(0);	   
  }

  public String orderSpecialInstructions(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Instructions:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
	  }
  
  public String orderPaymentMethod(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Method:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
	  }

  public String orderTotesUsed(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Used:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
  }
  
  public String orderPromotionCode(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Code:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
}

  public String orderProductTotal(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Total:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
}
  
  public String orderDiposit(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Deposit:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1)); 	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
}  
  
  public String orderTaxTotal(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Total:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
}

  public String orderDiscountCharge(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Charge:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
}  

  public String orderServiceFee(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Fee:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
  } 
  
  public String orderSpecialPromotions(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Promotions:</u></a></td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));				
		    custArray.add(value);
		}	  	
		
		if(custArray.size() > 0)
			return custArray.get(0);
		else
			return "$0.00";
		
  }
  
  public String orderAdditionalCharges(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Charges:</td>(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
  }

  public String orderTotal(String str){
		
		List<String> custArray = new ArrayList<String>();  
		Pattern pattern = Pattern.compile("Total:</b></td>(.*?)</b></td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
		    custArray.add(value);
		}	  	
		
	    return custArray.get(0);	   
  }
	
   
  public String FindDateTime(String str){
	  String time = null;
	  String date = null;
	  List<String> timeArray = new ArrayList<String>();
	  List<String> dateArray = new ArrayList<String>();
	  
	  //this is for the date	
	  Pattern patternDate = Pattern.compile("width='60'>(.*?)</td>");
	  Matcher matcherDate = patternDate.matcher(str);
	  while (matcherDate.find()) {		 
	  	date = matcherDate.group(1).replace("&nbsp;","");	  			
	  	dateArray.add(date);	  		  		  
	  }

	  //this is for the time	
	  Pattern patternTime = Pattern.compile("align='Right'>(.*?)</td>");
	  Matcher matcherTime = patternTime.matcher(str);
	  while (matcherTime.find()) {		  
	  	time = matcherTime.group(1).replace("&nbsp;","");	  	
	  	timeArray.add(time);	    
	  }
	  //orders.setid(str.substring(orderID));
	  System.out.println(dateArray);System.out.println(timeArray);	
	  System.out.println("\nPattern\n");
	  
	  return "Date&Time";
  }
  public String FindDateTime(String str, int index){
	  String time = null;
	  String date = null;
	  List<String> timeArray = new ArrayList<String>();
	  List<String> dateArray = new ArrayList<String>();
	  
	  //this is for the date	
	  Pattern patternDate = Pattern.compile("width='60'>(.*?)</td>");
	  Matcher matcherDate = patternDate.matcher(str);
	  while (matcherDate.find()) {		 
	  	date = matcherDate.group(1).replace("&nbsp;","");	  			
	  	dateArray.add(date);	  		  		  
	  }

	  //this is for the time	
	  Pattern patternTime = Pattern.compile("align='Right'>(.*?)</td>");
	  Matcher matcherTime = patternTime.matcher(str);
	  while (matcherTime.find()) {		  
	  	time = matcherTime.group(1).replace("&nbsp;","");	  	
	  	timeArray.add(time);	    
	  }
	  //orders.setid(str.substring(orderID));
	  /*System.out.println(dateArray);System.out.println(timeArray);	
	  System.out.println("\nPattern\n");*/
	  
	  return dateArray.get(index)+" "+timeArray.get(index);
  }
  public String FindCustomer(String str){
	  String cust = null;	  
	  List<String> custArray = new ArrayList<String>();	  
	  
	  //this is for the date	
	  Pattern patternCust = Pattern.compile("width='80'>(.*?)</td>");
	  Matcher matcherCust = patternCust.matcher(str);
	  while (matcherCust.find()) {		 
		cust = matcherCust.group(1).replace("&nbsp;","");	  			
		custArray.add(cust);	  		  		  
	  }

	  System.out.println(custArray);	  
	  
	  return "Customename";
  }
  public String FindCustomer(String str, int index){
	  String cust = null;	  
	  List<String> custArray = new ArrayList<String>();	  
	  
	  //this is for the date	
	  Pattern patternCust = Pattern.compile("width='80'>(.*?)</td>");
	  Matcher matcherCust = patternCust.matcher(str);
	  while (matcherCust.find()) {		 
		cust = matcherCust.group(1).replace("&nbsp;","");	  			
		custArray.add(cust);	  		  		  
	  }
	  	   
	  return custArray.get(index);
  }
  
  public String FindPhone(String str){
	  String newstr = str.replaceAll("\\s+","");
	  String phone = null;	  
	  List<String> phoneArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  // for the uncompleted orders = <tdclass='uncomO'width='90'align='left'>
	  Pattern patternPhone = Pattern.compile("<tdclass='origO'width='90'align='left'>(.*?)</td>");
	  Matcher matcherPhone = patternPhone.matcher(newstr);
	  
	  while (matcherPhone.find()) {		 
		  phone = matcherPhone.group(1).replace("&nbsp;","");	  			
		  phoneArray.add(phone);	  		  		  
	  }

	  System.out.println(phoneArray);	
	  return "Phone";
  }
  public String FindPhone(String str, int index){
	  String newstr = str.replaceAll("\\s+","");
	  String phone = null;	  
	  List<String> phoneArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  // for the uncompleted orders = <tdclass='uncomO'width='90'align='left'>
	  Pattern patternPhone = Pattern.compile("<tdclass='origO'width='90'align='left'>(.*?)</td>");
	  Matcher matcherPhone = patternPhone.matcher(newstr);
	  
	  while (matcherPhone.find()) {		 
		  phone = matcherPhone.group(1).replace("&nbsp;","");	  			
		  phoneArray.add(phone);	  		  		  
	  }

	  //System.out.println(phoneArray);	
	  return phoneArray.get(index);
  }
  
  public String FindZip(String str){
	  String newstr = str.replaceAll("\\s+","");
	  String zip = null;	  
	  List<String> zipArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  Pattern patternZip = Pattern.compile("<tdclass='origO'width='45'>(.*?)</font>");
	  Matcher matcherZip = patternZip.matcher(newstr);
	  
	  while (matcherZip.find()) {		 
		  zip = matcherZip.group(1).replace("&nbsp;","");	  			
		  zipArray.add(zip);	  		  		  
	  }

	  System.out.println(zipArray);	
	  return "Zip";
  }
  public String FindZip(String str, int index){
	  String newstr = str.replaceAll("\\s+","");
	  String zip = null;	  
	  List<String> zipArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  Pattern patternZip = Pattern.compile("<tdclass='origO'width='45'>(.*?)</font>");
	  Matcher matcherZip = patternZip.matcher(newstr);
	  
	  while (matcherZip.find()) {		 
		  zip = matcherZip.group(1).replace("&nbsp;","");	  			
		  zipArray.add(zip);	  		  		  
	  }

	  //System.out.println(zipArray);	
	  return zipArray.get(index);
  }
  public String FindTotal(String str){
	  String newstr = str.replaceAll("\\s+","");
	  String total = null;	  
	  List<String> totalArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  Pattern patternTotal = Pattern.compile("<tdclass='origO'width='85'>(.*?)/<B>");
	  Matcher matcherTotal = patternTotal.matcher(newstr);
	  
	  while (matcherTotal.find()) {		 
		  total = matcherTotal.group(1).replace("&nbsp;","");	  			
		  totalArray.add(total);	  		  		  
	  }

	  System.out.println(totalArray);		  
	  return "Total";
  }
  public String FindTotal(String str, int index){
	  String newstr = str.replaceAll("\\s+","");
	  String total = null;	  
	  List<String> totalArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  Pattern patternTotal = Pattern.compile("<tdclass='origO'width='85'>(.*?)/<B>");
	  Matcher matcherTotal = patternTotal.matcher(newstr);
	  
	  while (matcherTotal.find()) {		 
		  total = matcherTotal.group(1).replace("&nbsp;","");	  			
		  totalArray.add(total);	  		  		  
	  }

	  //System.out.println(totalArray);		  
	  return totalArray.get(index);
  }
  public String FindStatus(String str){
	  String newstr = str.replaceAll("\\s+","");
	  String status = null;	  
	  List<String> statusArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  Pattern patternStatus = Pattern.compile("<tdclass='origO'width='100'align='left'>(.*?)</td>");
	  Matcher matcherStatus = patternStatus.matcher(newstr);
	  
	  while (matcherStatus.find()) {		 
		  status = matcherStatus.group(1).replace("&nbsp;","");	  			
		  statusArray.add(status);	  		  		  
	  }

	  System.out.println(statusArray);	 
	  return "Total";
  }
  public String FindStatus(String str, int index){
	  String newstr = str.replaceAll("\\s+","");
	  String status = null;	  
	  List<String> statusArray = new ArrayList<String>();	  
	  
	  //this is for the date		
	  Pattern patternStatus = Pattern.compile("<tdclass='origO'width='100'align='left'>(.*?)</td>");
	  Matcher matcherStatus = patternStatus.matcher(newstr);
	  
	  while (matcherStatus.find()) {		 
		  status = matcherStatus.group(1).replace("&nbsp;","");	  			
		  statusArray.add(status);	  		  		  
	  }

	  //System.out.println(statusArray);	 
	  return statusArray.get(index);
  }
  public boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
  }
  public static String html2text(String html) {
	    return Jsoup.parse(html).text();
  }
  
}