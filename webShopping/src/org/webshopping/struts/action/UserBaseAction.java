package org.webshopping.struts.action;

import org.apache.struts.action.Action;
import org.webshopping.service.IUserService;

public class UserBaseAction extends Action {

	protected IUserService iuserService;

	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	}

}
