package org.webshopping.dao;

import org.webshopping.bean.Users;

public interface IUserDao {

	public void addOrUpdateUser(Users user);

	public Users findUser(String username, String password);

	public Users findUserByID(String username);

	public boolean findUserBySave(String username, String question,
			String answer);

	public void updatePassword(String username, String password);
}
