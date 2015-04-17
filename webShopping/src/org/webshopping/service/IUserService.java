package org.webshopping.service;

import org.webshopping.bean.Users;

public interface IUserService {

	public boolean login(String username, String password);

	public void register(Users user);

	public boolean userIsExist(String username);

	public Users getUserInfo(String username);

	public void updateUserInfo(Users user);
	
	public boolean isExist(String username,String question, String answer);
	
	public void updatePassword(String username, String password);
}
