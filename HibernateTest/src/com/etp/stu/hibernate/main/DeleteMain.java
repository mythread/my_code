package com.etp.stu.hibernate.main;

import com.etp.stu.hibernate.dao.UsermngrDAO;
import com.etp.stu.hibernate.pojo.TUserinfo;

public class DeleteMain {

	public static void main(String[] args) {

		TUserinfo tUserinfo=new TUserinfo();
		
		tUserinfo.setUserid("zhangsan");
		
		UsermngrDAO.delete(tUserinfo);
	}
}
