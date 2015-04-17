package com.ibm.etp.login.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 处理login.jsp页
 * 面的登录事件，并根据登录结果，分发到不同页面
 * </dd>
 * </dl>
 * @copyright :Copyright 2012, WXIBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2012-3-28	WXIBM		zxc						create
 */
public class LoginAction extends ActionSupport {
    /** 用户名 */
    private String username; // 保持和jsp页面表单中属性一致

    /** 密码 */
    private String password; // 保持和jsp页面表单中属性一致

    /**
     * <dl>
     * <dt><b>Method机能概要:</b></dt>
     * <dd>处理用户登录，当用户名和密码都为admin时，返回登录成功，否则失败</dd>
     * </dl>
     * @return String
     * @throws Exception
     */
    public String execute() throws Exception {
        if (username != null && "admin".equals(username.trim())
                && password != null && "admin".equals(password.trim())) {
            return SUCCESS;
        }
        return "failure";
    }
    
    /**
     * <dl>
     * <dt><b>Method机能概要:</b></dt>
     * <dd>得到用户名</dd>
     * </dl>
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * <dl>
     * <dt><b>Method机能概要:</b></dt>
     * <dd>设置用户名</dd>
     * </dl>
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * <dl>
     * <dt><b>Method机能概要:</b></dt>
     * <dd>得到密码</dd>
     * </dl>
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * <dl>
     * <dt><b>Method机能概要:</b></dt>
     * <dd>设置密码</dd>
     * </dl>
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
