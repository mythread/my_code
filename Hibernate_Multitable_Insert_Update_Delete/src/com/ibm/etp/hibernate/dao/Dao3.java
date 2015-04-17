package com.ibm.etp.hibernate.dao;

import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.etp.hibernate.pojo.Goodsinfo;
import com.ibm.etp.hibernate.pojo.Ordergoods;
import com.ibm.etp.hibernate.pojo.Orderinfo;
import com.ibm.etp.hibernate.pojo.Ordertype;
import com.ibm.etp.hibernate.pojo.Userinfo;
import com.ibm.etp.hibernate.util.HibernateSessionFactory;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2012, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2012-4-9	IBM			zxc					create
 */
public class Dao3 {
	/*
	 * 对许多表进行操作
	 */
	
	public static void newOrder(int orderno, int ordertypeno, int userno, int[] goodsnos, int[] amounts, int[] prices) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			
			// 为了创建orderinfo，需要userinfo
			Userinfo userinfo = (Userinfo) session.get(Userinfo.class, userno);
			// 为了创建orderinfo，需要ordertype
			Ordertype ordertype = (Ordertype) session.get(Ordertype.class, ordertypeno);
			
			
			// 创建orderinfo
			Orderinfo orderinfo = new Orderinfo();
			orderinfo.setOrderno(orderno);
			orderinfo.setOrdertype(ordertype);
			orderinfo.setOrderdate(new Date());
			// 关联一个外键userinfo
			orderinfo.setUserinfo(userinfo);
			
			for (int i = 0; i < goodsnos.length; i++) {
				// 创建ordergoods
				Ordergoods ordergoods = new Ordergoods();
				ordergoods.setOrdergoodsno(i + 6); // 只是为了创建主键用
				ordergoods.setAmount(amounts[i]);
				ordergoods.setPrice(prices[i]);
				// 为了创建ordergoods，需要goodsinfo
				Goodsinfo goodsinfo = (Goodsinfo) session.get(Goodsinfo.class, goodsnos[i]);
				ordergoods.setGoodsinfo(goodsinfo);
				
				// 重要语句，两个对象产生主外键关联
				ordergoods.setOrderinfo(orderinfo);
			
				// 重要语句，两个对象产生主外键关联,双向关联
				orderinfo.getOrdergoodses().add(ordergoods);
			}
			
			session.save(orderinfo);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
	}
	
	/*
	 * 对订单做一些项目的删除，对一些项目进行修改，增加一些项目
	 * 相当于orderinfo不动  ordergoods 增删改一些记录
	 * 
	 * 由于增删改订单详细信息，需要实现读取一些信息，所以传参数稍显麻烦
	 * 故直接在下面方法里面直接手工增删改一些信息
	 * 
	 * 这段代码重复执行可能导致主键冲突，外键冲突等异常
	 * 所以只能执行一次。如果再次执行，需要重新恢复一次数据库
	 */
	public static void modifyOrder() {
		int orderno = 1;// 订单号为1
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			
			
			
			
			// 得到orderinfo表的所有数据
			Orderinfo orderinfo = (Orderinfo) session.get(Orderinfo.class, orderno);
			
			
			
			
			
			
			
			// 因为orderinfo里面有ordergoodses属性
			// 所以可以得到里面原来已有的订单信息
			
			Iterator<Ordergoods> iterator = orderinfo.getOrdergoodses().iterator();
			
			
			
			
			
			
			
			
			// 现在修改一个：
			Ordergoods ordergoods = iterator.next();
			System.out.println("即将修改ordergoods对象id:" + ordergoods.getOrdergoodsno());
			ordergoods.setAmount(10);
			
			// 修改！
			session.update(ordergoods);
			
			
			
			
			

			// 另外删一个：
			iterator.hasNext();
			Ordergoods ordergoods2 = iterator.next();
			System.out.println("即将删除ordergoods对象id:" + ordergoods2.getOrdergoodsno());
			
			// 因为ordergoods和orderinfo关联，所以在orderinfo里面把和ordergoods2对象的关联取消
			orderinfo.getOrdergoodses().remove(ordergoods2);
			
			// 删除！
			session.delete(ordergoods2);
			
			
			
			
			
			
			
			// 再多创建个：
			Ordergoods ordergoods3 = new Ordergoods();
			ordergoods3.setOrdergoodsno(39);
			ordergoods3.setGoodsinfo((Goodsinfo) session.get(Goodsinfo.class, 3));
			ordergoods3.setAmount(15);
			ordergoods3.setPrice(1000);
			// 这个要和orderinfo产生关联
			ordergoods3.setOrderinfo(orderinfo);
			// orderinfo要和orergoods3有关联
			orderinfo.getOrdergoodses().add(ordergoods3);
			// 存入
			System.out.println("即将插入ordergoods对象id:" + ordergoods3.getOrdergoodsno());
			session.save(ordergoods3);
			
			
			
			// 提交了！
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
}
