package etp.listener ;

import java.util.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;

public class OnLineDemo 
	implements ServletContextListener,HttpSessionListener,HttpSessionAttributeListener
{
	// ����һ��ServletContext����
	private ServletContext application = null ;
	public void contextInitialized(ServletContextEvent sce)
	{
		// ������ʼ��ʱ����application�д��һ���յ�����
		System.out.println("OnLineDemo Listener ��ʼ��");
		this.application = sce.getServletContext() ;
		this.application.setAttribute("alluser",new ArrayList()) ;
	}

	public void contextDestroyed(ServletContextEvent sce)
	{}

	public void sessionCreated(HttpSessionEvent se)
	{}
	public void sessionDestroyed(HttpSessionEvent se)
	{
		// ���û����ƴ��б���ɾ��
		List l = (List)this.application.getAttribute("alluser") ;
		String value = (String)se.getSession().getAttribute("uname") ;
		l.remove(value) ;
		this.application.setAttribute("alluser",l) ;
	}

	public void attributeAdded(HttpSessionBindingEvent se)
	{
		// �����½�ɹ������û����������б�֮��
		List l = (List)this.application.getAttribute("alluser") ;
		l.add(se.getValue()) ;
		this.application.setAttribute("alluser",l) ;
	}
	public void attributeRemoved(HttpSessionBindingEvent se)
	{
		// ���û����ƴ��б���ɾ��
		List l = (List)this.application.getAttribute("alluser") ;
		String value = (String)se.getSession().getAttribute("uname") ;
		l.remove(value) ;
		this.application.setAttribute("alluser",l) ;
	}
	public void attributeReplaced(HttpSessionBindingEvent se)
	{
		
	}
}
