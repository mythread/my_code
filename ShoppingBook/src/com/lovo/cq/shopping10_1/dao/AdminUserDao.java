package com.lovo.cq.shopping10_1.dao;

import java.util.List;
import java.util.Map;

import com.lovo.cq.shopping10_1.po.UserPager;

public interface AdminUserDao {

	public Map getAllUsers();   //显示用户
	public boolean deleteUserById(int id);   //删除用户
	public boolean deleteUsers(int[] ids);
	public UserPager getUserPager(int index, int pageSize);
}
