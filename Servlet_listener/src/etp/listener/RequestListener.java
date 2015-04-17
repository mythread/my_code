package etp.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author helinxfy 2010
 */

public class RequestListener implements ServletRequestAttributeListener,
		ServletRequestListener {

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request ��ʼ��");
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request ����");

	}

	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("request ������ԣ�"+event.getName()+"="+event.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("request �Ƴ����ԣ�"+event.getName()+"="+event.getValue());
	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("request �滻���ԣ�"+event.getName()+"="+event.getValue());
	}

}
