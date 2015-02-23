package com.euclid.csf;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.euclid.dbSave.LoadData;

public class TimerServlet extends HttpServlet {
	
	
	private static Timer m_timer;
	public void init(ServletConfig config)  throws ServletException{
		m_timer = new Timer();
		HouseKeepingTask task = new HouseKeepingTask();
		m_timer.scheduleAtFixedRate(task, 0, 5*60*1000);
	}
	private class HouseKeepingTask extends TimerTask {
		int count=0;
        public void run() {
        	try {
				LoadData loadData = new LoadData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("Running ..."+count++);
        }
	}
}
