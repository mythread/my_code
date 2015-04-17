package etp.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author helinxfy 2010
 */

public class AppListener implements ServletContextAttributeListener,
		ServletContextListener {
	
	public void contextInitialized(ServletContextEvent arg0) {
			System.out.println("AppListener 初始化");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("AppListener 销毁");
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("添加属性："+event.getName()+"="+event.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("移除属性："+event.getName()+"="+event.getValue());

	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("替换属性："+event.getName()+"="+event.getValue());
	}

}
