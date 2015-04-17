package etp.listener ;

import java.util.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;

public class OnLineDemo 
	implements ServletContextListener,HttpSessionListener,HttpSessionAttributeListener
{
	// 声明一个ServletContext对象
	private ServletContext application = null ;
	public void contextInitialized(ServletContextEvent sce)
	{
		// 容器初始化时，向application中存放一个空的容器
		System.out.println("OnLineDemo Listener 初始化");
		this.application = sce.getServletContext() ;
		this.application.setAttribute("alluser",new ArrayList()) ;
	}

	public void contextDestroyed(ServletContextEvent sce)
	{}

	public void sessionCreated(HttpSessionEvent se)
	{}
	public void sessionDestroyed(HttpSessionEvent se)
	{
		// 将用户名称从列表中删除
		List l = (List)this.application.getAttribute("alluser") ;
		String value = (String)se.getSession().getAttribute("uname") ;
		l.remove(value) ;
		this.application.setAttribute("alluser",l) ;
	}

	public void attributeAdded(HttpSessionBindingEvent se)
	{
		// 如果登陆成功，则将用户名保存在列表之中
		List l = (List)this.application.getAttribute("alluser") ;
		l.add(se.getValue()) ;
		this.application.setAttribute("alluser",l) ;
	}
	public void attributeRemoved(HttpSessionBindingEvent se)
	{
		// 将用户名称从列表中删除
		List l = (List)this.application.getAttribute("alluser") ;
		String value = (String)se.getSession().getAttribute("uname") ;
		l.remove(value) ;
		this.application.setAttribute("alluser",l) ;
	}
	public void attributeReplaced(HttpSessionBindingEvent se)
	{
		
	}
}
