/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.webshopping.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.webshopping.bean.Orderitem;
import org.webshopping.service.IOrderItemService;

/**
 * MyEclipse Struts Creation date: 04-30-2008
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/userinfo/orderItem" name="orderItemForm"
 *                input="/error.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/userinfo/orderitem.jsp"
 */
public class OrderItemAction extends Action {
	/*
	 * Generated Methods
	 */
	private IOrderItemService iorderItemService;

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaValidatorForm orderItemForm = (DynaValidatorForm) form;
		int soid = Integer.parseInt((String)orderItemForm.get("soid"));
		List<Orderitem> item = this.iorderItemService.getAllItems(soid);
		request.setAttribute("orderItem", item);
		return mapping.findForward("success");
	}

	public void setIorderItemService(IOrderItemService iorderItemService) {
		this.iorderItemService = iorderItemService;
	}
}