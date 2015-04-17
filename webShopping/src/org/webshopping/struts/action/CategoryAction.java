/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.webshopping.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;
import org.webshopping.bean.Category;
import org.webshopping.service.ICategoryService;

/**
 * MyEclipse Struts Creation date: 04-10-2008
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/category" name="categoryForm" input="/error.jsp"
 *                parameter="method" scope="request" validate="true"
 * @struts.action-forward name="success" path="/index.jsp"
 */
public class CategoryAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	private ICategoryService icategoryService;

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward listRoot(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/* 查询根分类 */
		List<Category> categoryRoot = icategoryService
				.findByParentId(ICategoryService.CATEGORY_ROOT);
		request.setAttribute("categoryRoot", categoryRoot);
		return mapping.findForward("successRoot");
	}

	public ActionForward listChild(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm categoryForm = (DynaValidatorForm) form;
		/* 获得分类编号 */
		int cid = Integer.parseInt((String) categoryForm.get("cid"));
		/* 查询子分类 */
		List<Category> categoryChild = icategoryService.findByParentId(cid);
		request.setAttribute("categoryChild", categoryChild);
		return mapping.findForward("successChild");
	}

	public void setIcategoryService(ICategoryService icategoryService) {
		this.icategoryService = icategoryService;
	}
}