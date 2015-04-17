package etp.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author helinxfy 2010
 */

public class SessionListener implements HttpSessionAttributeListener,
		HttpSessionListener {
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session ����");
		System.out.println("session Id:"+event.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session����");
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("session �������:"+se.getName()+"="+se.getValue()) ;
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("session �Ƴ�����:"+se.getName()+"="+se.getValue()) ;
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("session �滻����:"+se.getName()+"="+se.getValue()) ;
	}

}
