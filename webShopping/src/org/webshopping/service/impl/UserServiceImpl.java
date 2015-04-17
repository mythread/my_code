package org.webshopping.service.impl;

import java.util.UUID;

import org.webshopping.bean.Users;
import org.webshopping.dao.IUserDao;
import org.webshopping.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao iuserDao;

	@Override
	public boolean login(String username, String password) {

		boolean flag = true;
		if (iuserDao.findUser(username, password) == null) {
			flag = false;
		}

		/* 返回false说明用户名密码不正确 */
		return flag;
	}

	@Override
	public void register(Users user) {
		byte[] name = user.getUsername().getBytes();
		UUID uuid = UUID.nameUUIDFromBytes(name);
		String userid = uuid.toString();
		userid = userid.replaceAll("-", "");
		user.setUserid(userid);
		iuserDao.addOrUpdateUser(user);
	}

	@Override
	public boolean userIsExist(String username) {
		boolean flag = true;
		if (iuserDao.findUserByID(username) == null) {
			flag = false;
		}

		/* 返回false说明用户不存在 */
		return flag;
	}

	@Override
	public Users getUserInfo(String username) {
		Users user = iuserDao.findUserByID(username);
		return user;
	}

	@Override
	public void updateUserInfo(Users user) {
		iuserDao.addOrUpdateUser(user);
	}

	@Override
	public boolean isExist(String username, String question, String answer) {
		boolean exist = iuserDao.findUserBySave(username, question, answer);
		/* 结果为true表示密码提示信息正确 */
		return exist;
	}

	@Override
	public void updatePassword(String username, String password) {
		iuserDao.updatePassword(username, password);
	}

	public void setIuserDao(IUserDao iuserDao) {
		this.iuserDao = iuserDao;
	}

}
