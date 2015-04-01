package com.euclid.csf;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.euclid.dbSave.LoadData;

public class TimerServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Timer m_timer;
	public void init(ServletConfig config)  throws ServletException{
		m_timer = new Timer();
		HouseKeepingTask task = new HouseKeepingTask();
		//System.out.println("Running ..."+m_timer);
		m_timer.scheduleAtFixedRate(task, 0, 3*60*1000);
		
	}
	private class HouseKeepingTask extends TimerTask {
		int count=0;
        public void run() {
        	try {
        		//System.out.println("Running ..."+count++);
        		new LoadData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 System.out.println("Running ..."+count++);
        }
	}
}
