package com.euclid.dbSave;

import com.euclid.workbenchData.HttpCilentExample;
import com.euclid.workbenchData.LocalClientExample;




public class LoadData{
	
	public LoadData() throws Exception{
		readHtml();
		System.out.println("IN LOAD DATA++++++++++++++++");
	}
	
	public void readHtml() throws Exception{
		HttpCilentExample readDataFromWorkbench = new HttpCilentExample(); 
		LocalClientExample readLocalData = new LocalClientExample();
	}
	
}