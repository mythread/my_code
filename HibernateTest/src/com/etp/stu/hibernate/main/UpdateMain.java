package com.etp.stu.hibernate.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.etp.stu.hibernate.dao.UsermngrDAO;
import com.etp.stu.hibernate.pojo.TUserinfo;

public class UpdateMain {

	public static void main(String[] args) throws Exception {

		TUserinfo tUserinfo=new TUserinfo();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=dateFormat.parse("2012-03-05");
	
		tUserinfo.setUserid("zhangsan4");
		tUserinfo.setUsername("张三三");
		tUserinfo.setAge(56);
		tUserinfo.setBirthday(birthday);
		
		
		UsermngrDAO.update(tUserinfo);
	}

}
