package diytag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author helinxfy 2009
 */

public class HelloTag extends BodyTagSupport {
	public HelloTag(){
	}
	public int doStartTag(){
		JspWriter out=this.pageContext.getOut();
		try{
			out.print("你好，IBM Java!");
		}catch(IOException e){
			e.printStackTrace();
		}
		return this.SKIP_BODY;//忽略标签体执行，直接执行doEndTag()
	}
	public int doEndTag(){
		return this.EVAL_PAGE;//继续执行JSP页面剩余部分
	}
}
