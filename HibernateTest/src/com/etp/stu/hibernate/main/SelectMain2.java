package com.etp.stu.hibernate.main;

import com.etp.stu.hibernate.dao.UsermngrDAO;
import com.etp.stu.hibernate.pojo.TUserinfo;

public class SelectMain2 {

	public static void main(String[] args) {

		TUserinfo tUserinfo=null;
		tUserinfo=UsermngrDAO.select2("zhangsan4");
		
		System.out.println(tUserinfo.getUsername());
	}
}
