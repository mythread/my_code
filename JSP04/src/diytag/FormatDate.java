package diytag;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class FormatDate extends TagSupport {

	private Date date;
	private String type;
	private String pattern;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			SimpleDateFormat fmt = formatDate();		
			pageContext.getOut().print(fmt.format(date));
		} catch (Exception e) {
			throw new JspTagException(e.getMessage());
		}
		return SKIP_BODY;
	}

	private SimpleDateFormat formatDate() {
		SimpleDateFormat fmt = null;
		if (type.equals("both")) {
			fmt = new SimpleDateFormat(pattern);
		}
		if (type.equals("short")) {
			if (pattern.equals("date")) {
				fmt = new SimpleDateFormat("yyyy年MM月dd日");
			}
			if (pattern.equals("time")) {
				fmt = new SimpleDateFormat("hh时mm分ss秒");
			}
			if (pattern.equals("all")) {
				fmt = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			}
		}
		return fmt;
	}
}
