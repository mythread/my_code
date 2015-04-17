/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.webshopping.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;
import org.webshopping.bean.Users;
import org.webshopping.service.IUserService;

/**
 * MyEclipse Struts Creation date: 04-05-2008
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/userinfo" name="userinfoForm"
 *                input="/userinfo/index.jsp" parameter="method" scope="request"
 *                validate="true"
 */
public class UserinfoAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	private IUserService iuserService;

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm infoForm = (DynaValidatorForm) form;
		String username = (String) request.getSession()
				.getAttribute("username");
		Users user = this.iuserService.getUserInfo(username);
		if (user != null) {
			infoForm.set("email", user.getEmail());
			infoForm.set("phone", user.getPhone());
			infoForm.set("address", user.getAddress());
			infoForm.set("username", user.getUsername());
			request.setAttribute("edit", "true");
			return mapping.findForward("success");
		} else {
			/* 查询失败 */
			return mapping.getInputForward();
		}
	}

	public ActionForward doedit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm infoForm = (DynaValidatorForm) form;
		String username = (String) request.getSession()
				.getAttribute("username");
		Users user = this.iuserService.getUserInfo(username);
		if (user != null) {
			user.setAddress(infoForm.getString("address"));
			user.setEmail(infoForm.getString("email"));
			user.setPhone(infoForm.getString("phone"));
			this.iuserService.updateUserInfo(user);
			/* 给页面的提示，更新成功 */
			request.setAttribute("editsuc", "success");
			return mapping.findForward("success");
		} else {
			/* 查询失败 */
			return mapping.getInputForward();
		}
	}

	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	}
}