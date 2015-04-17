package com.ibm.etp.common.util;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.util.Enumerator;

import com.ibm.etp.dao.UserDao;

/**
 * Application Lifecycle Listener implementation class LogoutListener
 *
 */
public class LogoutListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent arg0) {
    }

	public void sessionDestroyed(HttpSessionEvent arg0) {
    	HttpSession session = arg0.getSession();
    	String userid = (String) session.getAttribute("userid");
    	if (userid != null) {
    		UserDao.logout(userid);
    	}
    }
}
