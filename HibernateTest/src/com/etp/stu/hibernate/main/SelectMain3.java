package com.etp.stu.hibernate.main;

import java.util.List;

import com.etp.stu.hibernate.dao.UsermngrDAO;
import com.etp.stu.hibernate.pojo.TUserinfo;

public class SelectMain3 {
	// 抛出放射调用异常
	public static void main(String[] args) {

		TUserinfo tUserinfo = new TUserinfo();
		tUserinfo.setUserid("zhang");
		tUserinfo.setUsername("三");
		List<TUserinfo> list = null;
		list = (List<TUserinfo>) UsermngrDAO.select3(tUserinfo);

		System.out.println(list.size());
	}
}
