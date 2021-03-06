/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.webshopping.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.webshopping.service.IUserService;

/**
 * MyEclipse Struts Creation date: 04-05-2008
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/pass" name="passForm" input="/userinfo/password.jsp"
 *                parameter="method" scope="request" validate="true"
 * @struts.action-forward name="dopassword" path="/userinfo/ password2.jsp"
 * @struts.action-forward name="success" path="/userinfo/index.jsp"
 */
public class PassAction extends DispatchAction {
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
	public ActionForward pass(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm passForm = (DynaActionForm) form;

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String question = passForm.getString("question");
		String answer = passForm.getString("answer");
		boolean exist = this.iuserService.isExist(username, question, answer);
		if (exist) {
			session.setAttribute("status", "true");
			return mapping.findForward("doPassword");
		} else {
			/* 验证失败 */
			ActionMessages error = new ActionMessages();
			error.add("question", new ActionMessage("passForm.err"));
			this.addErrors(request, error);
			return mapping.getInputForward();
		}
	}

	public ActionForward dopass(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm passForm = (DynaActionForm) form;
		HttpSession session = request.getSession();
		String status = (String) session.getAttribute("status");
		if (status != null) {
			String username = (String) session.getAttribute("username");
			this.iuserService.updatePassword(username, passForm
					.getString("password"));
			session.removeAttribute("status");
			/* 给页面用的提示，密码修改成功 */
			request.setAttribute("dopasssuc", "success");
			return mapping.findForward("success");
		} else {
			/* 非法操作 */
			request.setAttribute("dopass", "illegal");
			return mapping.getInputForward();
		}
	}

	public IUserService getIuserService() {
		return iuserService;
	}

	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	}
}