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
		System.out.println("session 创建");
		System.out.println("session Id:"+event.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session销毁");
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("session 添加属性:"+se.getName()+"="+se.getValue()) ;
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("session 移除属性:"+se.getName()+"="+se.getValue()) ;
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("session 替换属性:"+se.getName()+"="+se.getValue()) ;
	}

}
