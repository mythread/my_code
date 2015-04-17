package com.etp.stu.hibernate.main;

import java.util.Date;

import com.etp.stu.hibernate.dao.UsermngrDAO;
import com.etp.stu.hibernate.pojo.TUserinfo;

public class InsertMain {

	public static void main(String[] args) {

		TUserinfo tUserinfo=new TUserinfo();
		
		tUserinfo.setUserid("zhangsan4");
		tUserinfo.setUsername("张三");
		tUserinfo.setAge(20);
		tUserinfo.setBirthday(new Date());
		
		
		UsermngrDAO.save(tUserinfo);
	}

}
