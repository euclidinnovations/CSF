package com.euclid.dbSave;

import com.euclid.workbenchData.GetAllTheStores;




public class LoadData{
	
	public LoadData() throws Exception{
		readHtml();
	}
	
	public void readHtml() throws Exception{
		 
		GetAllTheStores getStore = new GetAllTheStores();
		getStore.getData();
	    	/*new HttpCilentExample(); 
	    	LocalClientExample loc = new LocalClientExample();
	    	loc.getLocalClientExample();*/
	}
	
}