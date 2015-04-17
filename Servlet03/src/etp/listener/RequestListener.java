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
		System.out.println("request 初始化");
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request 销毁");

	}

	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("request 添加属性："+event.getName()+"="+event.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("request 移除属性："+event.getName()+"="+event.getValue());
	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("request 替换属性："+event.getName()+"="+event.getValue());
	}

}
