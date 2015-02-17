package com.euclid.Login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.euclid.dbSave.LoadData;

 
@Controller
public class LoginController extends MultiActionController{
		
		@RequestMapping("/login")
	   public String addLogin(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
	      
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
		
			//LoadData loadData = new LoadData();	 
		 
	      return "views/order"; 
	   }
}
