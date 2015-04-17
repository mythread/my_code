package com.etp.stu.hibernate.main;

import java.util.List;

import com.etp.stu.hibernate.dao.UsermngrDAO;
import com.etp.stu.hibernate.pojo.TUserinfo;

public class SelectMain {

	public static void main(String[] args) {

		List<TUserinfo> tUserinfo=null;
		tUserinfo=UsermngrDAO.select("zhangsan4","张三三");
		
		System.out.println(tUserinfo.size());
	}
}
