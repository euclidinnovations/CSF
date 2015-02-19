package com.euclid.workbenchData;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
 
import java.util.Scanner;
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

import com.euclid.persistence.Orders.model.CurrentOrder;
import com.euclid.persistence.Orders.model.Customer;
import com.euclid.persistence.Orders.model.Item;
import com.euclid.persistence.Orders.model.ModifiedItem;
import com.euclid.persistence.Orders.model.Order;
import com.euclid.persistence.Orders.model.OrderInstruction;
import com.euclid.persistence.Orders.model.OrderTotal;
import com.euclid.persistence.Orders.model.OriginalOrder;
import com.euclid.persistence.Orders.service.CurrentOrderService;
import com.euclid.persistence.Orders.service.CustomerService;
import com.euclid.persistence.Orders.service.ItemService;
import com.euclid.persistence.Orders.service.ModifiedItemService;
import com.euclid.persistence.Orders.service.OrderInstructionService;
import com.euclid.persistence.Orders.service.OrderService;
import com.euclid.persistence.Orders.service.OrderTotalService;
import com.euclid.persistence.Orders.service.OriginalOrderService;
 
public class GetAllTheStores{
 
  private String cookies;
  private HttpClient client = HttpClientBuilder.create().build();
  private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36";
 
   public void getData() throws Exception {
 
	   String url 				=	"https://wb2.harristeeter.com/Login.aspx";
		String wg 				=	"https://wb2.harristeeter.com/StoreMenu.aspx?dayspassexp=61";
		String current_pending 	=	"https://wb2.harristeeter.com/default.asp?View=NewPending";								 
		String uncommited 		=	"https://wb2.harristeeter.com/default.asp?View=Future";			
		String SelectStore		=	"https://wb2.harristeeter.com/SelectAStore.aspx";
		String AllStoreURL		=	"https://wb2.harristeeter.com/CorporateWorkbench.asp?dayspassexp=55";								 
		String CorporateMenuURL	=	"https://wb2.harristeeter.com/CorporateMenu.asp?dayspassexp=55"; 
		String StoreIDurl			=	"https://wb2.harristeeter.com/LoadStore.aspx?StoreId=4236";	
		String storeMenu	=	"https://wb2.harristeeter.com/StoreMenu.aspx";
		
		// make sure cookies is turn on
		CookieHandler.setDefault(new CookieManager());
	 
		GetAllTheStores http = new GetAllTheStores();
	 
		String page = http.GetPageContent(url); // Login
	 
		List<NameValuePair> postParams = 
	               http.getFormParams(page, "hteeter1","Shop001");
	 
		http.sendPost(url, postParams);
		
		// Start working code	
			String step1	=	http.GetPageContent(CorporateMenuURL);	// Get all the store
			//System.out.println("\nStep 1\n"+step1);
			String step2	=	http.GetPageContent(SelectStore);		// Click on particular store
			//System.out.println("\nStep 2\n"+step2);
			String step3	=	http.GetPageContent(StoreIDurl);		// Get store info
			//System.out.println("\nStep 3\n"+step3);
				
			String OneStoreHtml 		= http.GetPageContentsStore(storeMenu,StoreIDurl);	
			
			String CurrPenOrdersHtml 	= http.GetPageContent(current_pending);
		// End working code
		
		//Find the store and store that stores in local system
		http.FindStoresSaveOnLocal(step2);	
			
		//Find out the orderIDs
		//http.FindOrderIDs(SelectStoreHtml);	
		
		System.out.println("Done");
  }
 
  private void sendPost(String url, List<NameValuePair> postParams) 
        throws Exception {
 
	HttpPost post = new HttpPost(url);
 
	// add header
	post.setHeader("Accept", 
            "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	post.setHeader("Accept-Encoding", "gzip, deflate");
	post.setHeader("Accept-Language", "en-US,en;q=0.8");
	post.setHeader("Cache-Control", "max-age=0");
	post.setHeader("Connection", "keep-alive");	
	post.setHeader("Content-Type", "application/x-www-form-urlencoded");
	post.setHeader("Cookie", getCookies());
	post.setHeader("Host", "wb2.harristeeter.com");
	post.setHeader("Origin", "https://wb2.harristeeter.com");
	post.setHeader("Referer", "https://wb2.harristeeter.com/");
	post.setHeader("User-Agent", USER_AGENT);
		
	post.setEntity(new UrlEncodedFormEntity(postParams));
 
	HttpResponse response = client.execute(post);
 
	int responseCode = response.getStatusLine().getStatusCode();
 
	System.out.println("\nSending 'POST' request to URL : " + url);
//	System.out.println("Post parameters : " + postParams);
//	System.out.println("Response Code : " + responseCode);
 
	BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
 
	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
 
//	System.out.println(result.toString());
 
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
//	System.out.println("Response Code : " + responseCode);
 
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
 
  private String GetPageContentsStore(String url, String referer) throws Exception {
	  
		HttpGet request = new HttpGet(url);
	 
		request.setHeader("User-Agent", USER_AGENT);
		request.setHeader("Accept",
			"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		request.setHeader("Accept-Language", "en-US,en;q=0.5");
		request.setHeader("Host", "wb2.harristeeter.com");
		request.setHeader("Referer", referer);		
	 
		HttpResponse response = client.execute(request);
		int responseCode = response.getStatusLine().getStatusCode();
	 
		System.out.println("\nSending 'GET' request to URL : " + url);
	//	System.out.println("Response Code : " + responseCode);
	 
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
	paramList.add(new BasicNameValuePair("txtUsername", "hteeter1"));
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
  
  public List<String> FindStoresSaveOnLocal(String str) throws Exception{
	  	String url 				=	"https://wb2.harristeeter.com/Login.aspx";
		String wg 				=	"https://wb2.harristeeter.com/StoreMenu.aspx?dayspassexp=61";
		String current_pending 	=	"https://wb2.harristeeter.com/default.asp?View=NewPending";								 
		String uncommited 		=	"https://wb2.harristeeter.com/default.asp?View=Future";			
		String SelectStore		=	"https://wb2.harristeeter.com/SelectAStore.aspx";
		String AllStoreURL		=	"https://wb2.harristeeter.com/CorporateWorkbench.asp?dayspassexp=55";								 
		String CorporateMenuURL	=	"https://wb2.harristeeter.com/CorporateMenu.asp?dayspassexp=55"; 		
		String storeMenu	=	"https://wb2.harristeeter.com/StoreMenu.aspx";
	  
		int i=0;
	  	String newstr 	= str.replaceAll("\\s+","");
	  	//System.out.println(str);
		List<String> storeArray = new ArrayList<String>();  
		//Pattern pattern = Pattern.compile("javascript:ShowDetail(.*?);'><spanstyle"); //SKU
		Pattern pattern = Pattern.compile("<aclass=\"bold-text\"href=\"javascript:loadStore(.*?);\">");
		
		Matcher matcher = pattern.matcher(newstr);
		//while (matcher.find()) { i++;   	
			//if(i <= 5) {
				//System.out.println("\n"+i);
				//String storeID	= matcher.group(1);
				String storeID	="1632";
				storeID	=	storeID.replace("(", "");
				storeID	=	storeID.replace(")", "");

//Step 1	// After login landing page
				GetPageContent(CorporateMenuURL);	
//Step 2	// List of all store
				GetPageContent(SelectStore);		
//Step 3	// Create URL for the single store 	
				String StoreIDurl			=	"https://wb2.harristeeter.com/LoadStore.aspx?StoreId="+storeID;	
				
				GetPageContent(StoreIDurl);		// Get store info
			// Get store home page		
				String OneStoreHtml 		= GetPageContentsStore(storeMenu,StoreIDurl);	

//Step 4    // Storing single store details(Current+Pending) at local storage	
				String CurrPenOrdersHtml 	= GetPageContent(current_pending);
				PrintWriter StoreWriter = new PrintWriter("C:/temp/"+storeID+"_store.txt", "UTF-8");
			//	PrintWriter StoreWriter = new PrintWriter("/root/wildfly-8.2.0.Final/Logs/"+storeID+"_store.txt", "UTF-8");
				
				StoreWriter.println(CurrPenOrdersHtml);			
				StoreWriter.close();				

//Step 5	// Write orderID from the current HTML and store into the local 	
				WriteOrdersToLocal(CurrPenOrdersHtml,storeID);
				
//Step 6	// Read the data from the local 								
				ReadOrdersFromLocal(storeID);
				
				storeArray.add(storeID);
			//}
		//}	  			
		//ReadOrdersFromLocal(1632");
		//System.out.println(storeArray);
	    return storeArray;				
	  }

public void WriteOrdersToLocal(String str, String storeID) throws Exception{
	System.out.println("\n IN WriteOrdersToLocal \n " + storeID);
	int j = 0; int k = 0;  	
	String orderIDPage = "https://wb2.harristeeter.com/OrderDetail.asp?OrderID=";
	String custDetailsPage = "https://wb2.harristeeter.com/CustomerAccount.aspx?&CustomerID=";
	String exceptionReportURL = "https://wb2.harristeeter.com/OrderReport.aspx?OrderID=";
	ArrayList<String> orderIDarr = new ArrayList<String>();
	String getOrderIDString = "OrderDetail(";
	
	// find all occurrences forward
	// this is only for the OrderID
	for (int i = -1; (i = str.indexOf(getOrderIDString , i + 1)) != -1; ) {		
		j = i;		
		//if(i<=3){ //DONT KNOW
	    String orderID	=	str.substring(j+12, j+20);	// Fetching the orderID
	       	    	    	    	  
	    String regex = "\\d+";	// This will check for the digits	    
	    
	    //If the orderId has only digits then only, it will added to the array or whatever
	    if(orderID.matches(regex)){	  
			
			//System.out.println("\n"+k+"\n");
			orderIDarr.add(orderID);	// Add the orderID into the ArrayList (If anyone wants)
								
			// This is the entire order details page
			// Create orders file  			
			String fetchOrderDetailsPage = orderIDPage+orderID;
			String htmlPage = GetPageContent(fetchOrderDetailsPage);
			PrintWriter OrderWriter = new PrintWriter("C:/temp/"+storeID+"_"+orderID+"_order.txt", "UTF-8");
			OrderWriter.println(htmlPage);			
			OrderWriter.close();
			//WriteExcelFile(htmlPage,storeID+"_"+orderID+"_order"); // creating the file for order	
			//System.out.println("\n"+orderIDPage+orderID);	
			//System.out.println("\nThis is the orderDetail page\n"+htmlPage);			

			String exeptionReportHTML = GetPageContent(exceptionReportURL+orderID);
			PrintWriter ReportWriter = new PrintWriter("C:/temp/"+storeID+"_"+orderID+"_exceptionreport.txt", "UTF-8");
			ReportWriter.println(exeptionReportHTML);			
			ReportWriter.close();
			//WriteExcelFile(exeptionReportHTML,storeID+"_"+orderID+"_exceptionreport");
			//System.out.println("\n this is the exception report\n"+exeptionReportHTML);
			
			// Create customer/user file
			String custID				=	orderCustomerID(htmlPage).trim();
			String custDetailsHTML 		= 	GetPageContent(custDetailsPage+custID);
			PrintWriter CustomerWriter 	= 	new PrintWriter("C:/temp/"+custID+"_customer.txt", "UTF-8");
			CustomerWriter.println(custDetailsHTML);			
			CustomerWriter.close();
			//WriteExcelFile(custDetailsHTML,custID+"_customer");  // creating the file for customer
			
			
	    }	  
	    k++;
		//} DONT KNOW
	}	
//	System.out.println(orderIDarr);		
  }
  
public void ReadOrdersFromLocal(String storeID) throws Exception{
		
//	System.out.println("\n IN ReadOrdersFromLocal \n " + storeID);
	
	int j = 0; int k = 0;  	
	
	ArrayList<String> orderIDarr = new ArrayList<String>();
	String getOrderIDString = "OrderDetail(";
	
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
	OrderService ordService = (OrderService) context.getBean("orderService");
	List<String> orderList = new ArrayList<String>();
	
	orderList = ordService.getAllOrderIDS();
	
	System.out.println("ORDER IDS LIST ****"+orderList);
	
	File folder = new File("c:/temp");
	File[] listOfFiles = folder.listFiles();	

  for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) {
      
      String Fname = listOfFiles[i].getName();
      
      if (Fname.indexOf(".") > 0)
    	  
      	Fname = Fname.substring(0, Fname.lastIndexOf("."));
      
	        //System.out.println("File " + Fname);
	        //if(!Fname.toLowerCase().contains("_customer") && !Fname.toLowerCase().contains("_exceptionreport") && !Fname.toLowerCase().contains("_store")){	//If is contains "customer" it will not in
	        if(Fname.toLowerCase().contains(storeID) && Fname.toLowerCase().contains("_order")){	//If file is order then it goes in	
		        String path	=	"C:/temp/";
	        	
	        	// It will get ORDER details HTML from the local system
		        String orderID			=	Fname.replace("_order", "");		        		       
		        orderID					=	orderID.replace(storeID+"_", "");		        
		        String OrderFileURL		=	path+storeID+"_"+orderID+"_order.txt";
		    	String htmlPage 		= 	new Scanner(new File(OrderFileURL)).useDelimiter("\\Z").next();
		    	String orderDetailsHTML	=	htmlPage;		    			    	
		    	//System.out.println("\nOrder\n " + orderDetailsHTML);
		    	
		    	// It will get Exceptionreport details HTML from the local system		    	
		    	String ReportURL			=	path+storeID+"_"+orderID+"_exceptionreport.txt";
		    	String exceptionReportHTML 	= 	new Scanner(new File(ReportURL)).useDelimiter("\\Z").next();
		    	//System.out.println("\nExceptionreport\n " + exceptionReportHTML);
		    	
		    	// It will get CUSTOMER details HTML from the local system
		    	String custID			=	orderCustomerID(htmlPage).trim();   
		    	String CustomerURL		=	path+custID+"_customer.txt";
		    	String custDetailsHTML 	= 	new Scanner(new File(CustomerURL)).useDelimiter("\\Z").next();
		    	//System.out.println("\nCustomer\n " + custDetailsHTML);
		    	
		    	String fName		=	custFirstname(custDetailsHTML);
	//	    	System.out.println("\nFirstname\n " + fName);
		    	String lName		=	custLastname(custDetailsHTML);
	//	    	System.out.println("\nLastname\n " + lName);
		    	String add1			=	custAddress1(custDetailsHTML);
	//	    	System.out.println("\n Add1 \n " + add1);
		    	String add2			=	custAddress2(custDetailsHTML);
	//	    	System.out.println("\n add2 \n " + add2);
		    	String city			=	custCity(custDetailsHTML);
	//	    	System.out.println("\n city \n " + city);
		    	String state		=	custState(custDetailsHTML);
	//	    	System.out.println("\n state \n " + state);
		    	String zip			=	custZip(custDetailsHTML);
	//	    	System.out.println("\n zip \n " + zip);
		    	String phone		=	custPhone(custDetailsHTML);		
	//	    	System.out.println("\n phone \n " + phone);
		    	String address		=	add1+" "+add2+" "+city+" "+state+" "+zip+" "+phone;		
	//	    	System.out.println("\n address \n " + address);
		    	String customerID	=	orderCustomerID(htmlPage).trim();
	//	    	System.out.println("\n customerID \n " + customerID);
		    	String email		=	orderEmail(custDetailsHTML);
	//	    	System.out.println("\n email \n " + email);
		    	String datetine		=	orderDateTime(htmlPage);
	//	    	System.out.println("\n datetine \n " + datetine);
		    	String billadd		=	orderBillAddress(htmlPage);
	//	    	System.out.println("\n billadd \n " + billadd);
		    	String substitution	=	orderSubstitution(htmlPage);
	//	    	System.out.println("\n substitution \n " + substitution);
		    	String fullfilment	=	orderFulfillment(htmlPage);
	//	    	System.out.println("\n fullfilment \n " + fullfilment);
		    	fullfilment			=	fullfilment.replace("Pickup -", "").trim();		   
		//    	System.out.println("\n fullfilment \n " + fullfilment);
		    	String specialinst	=	orderSpecialInstructions(htmlPage);
	//	    	System.out.println("\n specialinst \n " + specialinst);
		    	String paymethod	=	orderPaymentMethod(htmlPage);
//		    	System.out.println("\n paymethod \n " + paymethod);
		    	String totesused	=	orderTotesUsed(htmlPage);
//		    	System.out.println("\n totesused \n " + totesused);
		    	String promotioncode=	orderPromotionCode(htmlPage);
//		    	System.out.println("\n promotioncode \n " + promotioncode);
		    	String prdtotal		=	orderProductTotal(htmlPage);
	//	    	System.out.println("\n prdtotal \n " + prdtotal);
		    	String diposit		=	orderDiposit(htmlPage);		    	
	//	    	System.out.println("\n diposit \n " + diposit);
		    	String taxtotal			=	orderTaxTotal(htmlPage);
//		    	System.out.println("\n taxtotal \n " + taxtotal);
		    	String discountcharge	=	orderDiscountCharge(htmlPage);
	//	    	System.out.println("\n discountcharge \n " + discountcharge);
		    	String servicefee		=	orderServiceFee(htmlPage);		
	//	    	System.out.println("\n servicefee \n " + servicefee);
		    	String specialpromotion	=	orderSpecialPromotions(htmlPage);	
	//	    	System.out.println("\n specialpromotion \n " + specialpromotion);
	//	    	System.out.println(htmlPage);
		    	String addcharges	=	orderAdditionalCharges(htmlPage);
		    	//System.out.println("\n addcharges \n " + addcharges);
		    	String ordertotal	=	orderTotal(htmlPage);
		    	//System.out.println("\n ordertotal \n " + ordertotal);
		    	String viccard        =        orderVICcard(htmlPage);
                System.out.println("\n VIC card : " + viccard + "\n OrderID :"+orderID);
                String viccardsavings        =        orderVICcardSavings(htmlPage);
		    	
		    	/*Start of StoreID and OrderID*/
		    	HashMap storeMap  = new HashMap();
		    	storeMap.put(storeID, orderID);
		    	//System.out.println("\n storeMap \n " +storeMap);
		    	/*END of StoreID and orderID*/
		    	
		    	/*Customers Map*/
		    	/*List<String> customersArr  = new ArrayList<String>(); 
		    	customersArr.add(customerID);
		    	customersArr.add(fName);
		    	customersArr.add(lName);
		    	customersArr.add(phone);
		    	customersArr.add(email);
		    	customersArr.add(address);*/
		    	
		    	CustomerService cusService = (CustomerService) context.getBean("customerService");
		    	System.out.println("ORDER ID ******"+orderID);
		    	if(!cusService.exists(customerID)){
		    		//System.out.println("cusID ********* inside"+customerID);
				    	Customer cus = new Customer();
						cus.setCustomerId(customerID);
						cus.setFirstName(fName);
						cus.setLastName(lName);
						cus.setPhone(phone);
						cus.setAddress(address);
						cus.setEmail(email);	
						if(!(viccard.equalsIgnoreCase("NO VIC CARD"))){
							cus.setVic(viccard);
						}
						
					/*	System.out.println("customerID: "+customerID);
						System.out.println("fName: "+fName);
						System.out.println("lName: "+lName);
						System.out.println("phone: "+phone);
						System.out.println("address: "+address);
						System.out.println("\nCustomer\n " + custDetailsHTML);
						System.out.println("email: "+email);*/
						
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
		    	
		    //	OrderService ordService = (OrderService) context.getBean("orderService");
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
			    	if(!(viccardsavings.equalsIgnoreCase("NO VIC CARD SAVINGS"))){

				    	ordInst.setVicSavings(viccardsavings);
			    	}
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
		    	
		    	
		  //  	System.out.println("\nHTML PAGE:\n"+htmlPage);		 
		    	List<String> originalOrderArray = originalOrder(htmlPage);
		    //	System.out.println("\nOder Array:\n"+originalOrderArray);
		    	
		    	//System.exit(1);		    	
		//    	System.out.println("\n ORDER ID : \n"+orderID);		 
		    	int x = 0;
		    	for (int start = 0; start < originalOrderArray.size(); start += 8) {
                    String ProductSKU = null;
		            int end = Math.min(start + 8, originalOrderArray.size());
		            sublist = originalOrderArray.subList(start, end);        
		            
		  //          System.out.println("\nIN Sublist:\n"+sublist+"\nORDER NO:"+orderID);		            
		            
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
		          //          	System.out.println("IN Sublist: "+eachItem);
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
		        //            			System.out.println("tax "+eachItem);
		                    			break;
		                    		case 7:
		         //           			System.out.println("dep "+eachItem);
		                    			break;
		                    		case 8:
		        //            			System.out.println("Item Original/Substituted" + eachItem);
		                    			break;
		                    		
		                    		default:
		          //          			System.out.println("List Messed up");
		                    			break;
		                    	}
		                    	
		                    }
		                    
		       //             System.out.println(originalOrderMap);
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
		        //            	System.out.println("IN Sublist: "+eachItem);
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
		        //            			System.out.println("tax "+eachItem);
		                    			break;
		                    		case 7:
		      //              			System.out.println("dep "+eachItem);
		                    			break;
		                    		case 8:
		        //            			System.out.println("Item Original/Substituted" + eachItem);                  			
		                    			
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
		                    
		       //             System.out.println(currentOrderMap);
		            }
		            x++;
		            
		        }
		    	
		    	getModifiedItems(exceptionReportHTML,orderID);

	        }
	        else {
	        	//THis will hit if database has the orderID
//	        /	getModifiedItems(exceptionReportHTML,orderID);
	        }
	        	
        
      } else if (listOfFiles[i].isDirectory()) {
       // System.out.println("Directory " + listOfFiles[i].getName());
      }
      //if else ends /* (listOfFiles[i].isFile()) {
    
    }
  }


public List<String> currentOrder(String str){
	  /*Has all the td of the order details page*/
		  	//String newstr 	= str.replaceAll("\\s+","");
		//  	System.out.println(str);
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
	//		System.out.println(custArray);
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
		List<String> sublist = new ArrayList<String>(); 
		//Pattern pattern = Pattern.compile("javascript:ShowDetail(.*?);'><spanstyle"); //SKU
		//Pattern pattern = Pattern.compile("class='pl'>(.*?)</TD>"); // All the order
		
		Pattern pattern = Pattern.compile("class='pl'(.*?)</TD>");
		Matcher matcher = pattern.matcher(str);		
		while (matcher.find()) {    			
			String value	=	matcher.group(1).trim();	
			if(value.contains("ShowDetail")){
				//System.out.println("In if : before value");
				//System.out.println(value);	
				value	=	value+"</span>";
				Pattern pattern1 = Pattern.compile("class='pl'(.*?)</span>");
				Matcher matcher1 = pattern1.matcher(value);		
				while (matcher1.find()) {					
					String value1	=	matcher1.group(1).trim();						
					value1	=	html2text(value1);	
					value1	=	value1.replace(",", " - ");
					value1	=	value1.replace(">", "");
					//value1	=	value1.replace("</span>", "");					
					//System.out.println("\n"+value);
					//System.out.println("In while : value : "+value1);
				    custArray.add(value1);
				}
				//System.out.println("In if : after value");
				//System.out.println(value);				
			}
			else {
				//System.out.println("After if else : value : "+value);
				value	=	html2text(value);	
				value	=	value.replace(",", " - ");
				value	=	value.replace(">", "");
				//System.out.println("\n"+value);
			    custArray.add(value);
			}
		}	  	
		//System.out.println("After 8 it will break to new product");
		//System.out.println(custArray);
		
		/*System.out.println("After 8 it will break to new product");
		for (int start = 0; start < custArray.size(); start += 8) {
    		System.out.println("\n Started count : \n"+start);	
            String ProductSKU = null;
            int end = Math.min(start + 8, custArray.size());
            sublist = custArray.subList(start, end);
            System.out.println(sublist);
		}    
		
		System.exit(1);*/
	    return custArray;	   
}

public void getModifiedItems(String str, String orderID){
	//str 	= str.replaceAll("\\s+","");
  	//System.out.println(newstr);
	
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
        for(String eachItem:sublist){
        	x++;
        	switch(x){
        	case 1: 
        		modItem.setItemOrderedSKU(eachItem);
   //     		System.out.println("in modifiedItem table" +modItem.getItemOrderedSKU());
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
         
        int rlist = 0;
        Received = ReceivedArray.subList(start, end);
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
        
        if(modItemService.exists(orderID, itemOrdered))
        modItemService.persistModifiedItem(modItem);
  //      System.out.println(Received);
        
        
	}
    //return custArray;
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
			if(value != null && !value.isEmpty()){
				custArray.add(value);
			}
			else
				custArray.add("");
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
		
		if(value != null && !value.isEmpty()){
			custArray.add(value);
		}
		else
			custArray.add("");	    
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
	//Pattern pattern = Pattern.compile("<u>(.*?)</u></a>");
	
	Pattern pattern = Pattern.compile("name=\"loginEmail\"(.*?)>");
	
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {
		String value	=	html2text(matcher.group(1));
		value	=	value.replace("value=\"", "");
		value	=	value.replace("disabled=\"disabled\"/", "");
		value	=	value.replace("\"", "");		
		//System.out.println(value);
	    custArray.add(value.trim());
	}	  	
	//System.out.println(custArray);
	//System.exit(1);
  return custArray.get(0);	   
}

public String orderVICcard(String str){
    str = str.replaceAll("\\s+","");
                                                                                                            //System.out.println(str);
    List<String> custArray = new ArrayList<String>(); 
    Pattern pattern = Pattern.compile("VICCard:</td>(.*?)</td>");
    
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
            String value        =        html2text(matcher.group(1)).trim();
                                                                                                            //System.out.println(value);
            if(value != null && !value.isEmpty()) {
                                                                                                            //System.out.println("IN IF");
                                                                                                            //System.exit(1);
                    custArray.add(value);
            }
            else {
                                                                                                            //System.out.println("IN ELSE");
                                                                                                            //System.exit(1);
                    custArray.add("NO VIC CARD");
            }        
    }        
                                                                                                            //System.out.println(custArray.size());
    if(custArray.size() == 0)
            custArray.add("NO VIC CARD");
                                                                                                            //System.out.println(custArray.size());
                                                                                                            //System.exit(1);
    return custArray.get(0);        
}

public String orderVICcardSavings(String str){
    List<String> custArray = new ArrayList<String>(); 
    custArray.add("NO VIC CARD SAVINGS");
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
		Pattern pattern = Pattern.compile("Charges:(.*?)</td>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String value	=	html2text(matcher.group(1));	    
			if(value != null && !value.isEmpty()){
		//		System.out.println("\n There a value in IF:"+value+"\n");
				custArray.add(value);
			}
			else {
	//			System.out.println("\n There a value in ELSE:"+value+"\n");	
				custArray.add("");
			}	
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
//	  System.out.println(dateArray);System.out.println(timeArray);	
//	  System.out.println("\nPattern\n");
	  
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

	//  System.out.println(custArray);	  
	  
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

//	  System.out.println(totalArray);		  
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

//	  System.out.println(statusArray);	 
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