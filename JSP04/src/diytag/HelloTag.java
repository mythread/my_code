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
			out.print("��ã�IBM Java!");
		}catch(IOException e){
			e.printStackTrace();
		}
		return this.SKIP_BODY;//���Ա�ǩ��ִ�У�ֱ��ִ��doEndTag()
	}
	public int doEndTag(){
		return this.EVAL_PAGE;//����ִ��JSPҳ��ʣ�ಿ��
	}
}
