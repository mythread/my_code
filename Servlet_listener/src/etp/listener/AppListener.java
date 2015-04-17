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
			System.out.println("AppListener ��ʼ��");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("AppListener ����");
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("������ԣ�"+event.getName()+"="+event.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("�Ƴ����ԣ�"+event.getName()+"="+event.getValue());

	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("�滻���ԣ�"+event.getName()+"="+event.getValue());
	}

}
