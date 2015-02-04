package com.euclid.Login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
 
@Controller
public class LoginController extends MultiActionController{
		
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	   public String addLogin(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
	      
	      
	      return "views/csf"; 
	   }
}
