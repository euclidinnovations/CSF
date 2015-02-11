package com.euclid.dbSave;

import com.euclid.workbenchData.HttpCilentExample;
import com.euclid.workbenchData.LocalClientExample;




public class LoadData{
	
	public LoadData() throws Exception{
		readHtml();
	}
	
	public void readHtml() throws Exception{
		 new HttpCilentExample(); 
		 new LocalClientExample();
	}
	
}