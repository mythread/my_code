import com.opensymphony.xwork2.ActionSupport;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2010, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2010-8-17	IBM			Peng						create
 */
public class LoginAction extends ActionSupport{
	private String userid;
	private String userpwd;
	
	public String execute() throws Exception {
		if(userid == null || "".equals(userid)) {
			this.addFieldError("userid", "用户名不能为空啊！！！");
		}
		if(userid != null && userid.length() < 3) {
			this.addFieldError("userid", "用户名长度不能少于3！！！");
		}
		if(userid != null && userid.length() > 10) {
			this.addFieldError("userid", "用户名长度不能大于10！！！");
		}
		if(userpwd == null || "".equals(userpwd)) {
			this.addFieldError("userpwd", "密码咋能为空啊！！！");
		}
		if(userpwd != null && userpwd.length() < 6) {
			this.addFieldError("userpwd", "密码长度不能少于6！！！");
		}
		if(userpwd != null && userpwd.length() > 20) {
			this.addFieldError("userpwd", "密码长度不能大于20！！！");
		}
		if(userid != null && "admin".equals(userid.toLowerCase())) {
			this.addActionError("admin账户已被禁用，请勿登录");
		}
		if(userid != null && "guest".equals(userid.toLowerCase())) {
			this.addActionError("guest账户已被禁用，请勿登录");
		}
		if (!getFieldErrors().isEmpty() || !getActionErrors().isEmpty()) {
			return INPUT;
		}
		return SUCCESS;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
}
